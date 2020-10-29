package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Product;
import com.management.ssm.model.ProductCategory;
import com.management.ssm.repository.productCategoryRepository;
import com.management.ssm.repository.productRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class productController {
    @Autowired
    private productRepository productrepository;
    @Autowired
    private productCategoryRepository productcategoryrepository;

    private Logger log = LoggerFactory.getLogger(Image.class);

    // Get all records including NOTACTIVE
    @RequestMapping(method = RequestMethod.GET)
    public String getAllProducts() throws JsonProcessingException {
        ArrayList<Product> productlist = (ArrayList<Product>) productrepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(productlist);
        return value;
    }

    // Get all active records
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllActiveProducts() throws JsonProcessingException {
        ArrayList<Product> productlist = (ArrayList<Product>) productrepository.findActive();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(productlist);
        return value;
    }

    // Get a single record on the basis of id
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable long id) throws JsonProcessingException {
        Product product = productrepository.findOne(id);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(product);
        return value;
    }

    // Posting a record in table
    @RequestMapping(method = RequestMethod.POST)
    public String insertProduct(@RequestBody String data) throws JsonProcessingException, JSONException {
        ObjectMapper mapper = new ObjectMapper();
        Product product = new Product();
        JSONObject object = new JSONObject(data);
        if (!(object.has("product_NAME") && object.has("product_PRICE") && object.has("productcategory_ID")
                && object.has("product_STOCK") && object.has("product_DESCRIPTION")))
            return "Please enter all information";
        // Entering data into object of a product
        product.setPRODUCT_NAME(object.getString("product_NAME"));
        product.setPRODUCT_PRICE(object.getDouble("product_PRICE"));
        product.setPRODUCT_DESCRIPTION(object.getString("product_DESCRIPTION"));
        product.setPRODUCT_STOCK(object.getDouble("product_STOCK"));
        // Using Product Category Object for bi-directional Mapping
        ProductCategory productcategory = productcategoryrepository.findOne(object.getLong("productcategory_ID"));
        product.setPRODUCTCATEGORY_ID(productcategory);
        productcategory.getProducts().add(product);
        // Ended bi-directional mapping.
        product.setPRODUCTIS_ACTIVE('Y');
        productrepository.saveAndFlush(product);
        return mapper.writeValueAsString(product);
    }

    // Updating a record
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable long id, @RequestBody String data)
            throws UnknownHostException, JsonProcessingException {
        // Getting ip address and name
        InetAddress inetAddress = InetAddress.getLocalHost();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        JSONObject object = new JSONObject(data);
        ObjectMapper mapper = new ObjectMapper();
        // Updation of product
        Product product = productrepository.findOne(id);
        if (object.has("product_NAME"))
            product.setPRODUCT_NAME(object.getString("product_NAME"));
        if (object.has("product_STOCK"))
            product.setPRODUCT_STOCK(object.getDouble("product_STOCK"));
        if (object.has("product_PRICE"))
            product.setPRODUCT_PRICE(object.getDouble("product_PRICE"));
        if (object.has("product_DESCRIPTION"))
            product.setPRODUCT_DESCRIPTION(object.getString("product_DESCRIPTION"));
        if (object.has("productis_ACTIVE"))
            product.setPRODUCTIS_ACTIVE('N');
        // Using Product Category Object for bi-directional Mapping
        if (object.has("productcategory_ID")) {
            ProductCategory productcategory = productcategoryrepository.findOne(object.getLong("productcategory_ID"));
            if (productcategory != null) {
                ProductCategory prevproductcategory = product.getPRODUCTCATEGORY_ID();
                prevproductcategory.getProducts().remove(product);
                // Product saved in previous Product Category Removed.
                product.setPRODUCTCATEGORY_ID(productcategory);
                productcategory.getProducts().add(product);
                // New category added using Bi-directional mapping.
            }
        }
        product.setPRODUCTMODIFIED_BY(inetAddress.getHostName());
        product.setPRODUCTMODIFIED_WORKSTATION(inetAddress.getHostAddress());
        product.setPRODUCTMODIFIED_WHEN(dateFormatter.format(date));
        // Saving in Database
        productrepository.saveAndFlush(product);
        return mapper.writeValueAsString(product);
    }

    // Deleting a record
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        Product product = productrepository.findOne(id);
        productrepository.delete(id);
        return product.getPRODUCT_NAME() + " has been deleted";
    }

    // Obtaining active record by search
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getBySearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("search"))
            return "Search string is missing";
        ArrayList<Product> productlist = (ArrayList<Product>) productrepository
                .findBySearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(productlist);
        return value;
    }

    // Obtaining all record by search including non-actives
    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    public String getAllBySearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("search"))
            return "Search string is missing";
        List<Product> productlist = productrepository.findAllBySearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(productlist);
        return value;
    }

//	Searching all records by advance search

    public String getByAdvacedSearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("name"))
            return "Search string is missing";
        List<Product> list = productrepository.findByAdvancedSearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    public String getAllByAdvacedSearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("name"))
            return "Search string is missing";
        List<Product> list = productrepository.findAllByAdvancedSearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    // posting image in local path
    @PostMapping("image")
    public String saveFile(@RequestParam("file") MultipartFile file) throws IOException {
        String directorypath = "E:\\Faltu Setup\\Tutorials\\Angular.JS Learning Path\\Youtube Tutorials\\Pratices(ANGULAR)\\Project\\src\\assets\\Images\\ItemIcons";
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy-hhmmss");
        Date date = new Date();
        String fileName = "";
        if (!file.isEmpty()) {
            try {
                String[] split = file.getOriginalFilename().split("\\.");
                String ext = split[split.length - 1];
                fileName = "File-" + dateFormat.format(date) + "." + ext;
                log.info(file.getName());
                log.info(file.getContentType());
                log.info(file.getOriginalFilename());
                log.info(fileName);
                if (Files.notExists(Paths.get(directorypath), LinkOption.NOFOLLOW_LINKS)) {
                    Files.createDirectory(Paths.get(directorypath));
                    log.debug("I am entered.");
                }
                Files.copy(file.getInputStream(), Paths.get(directorypath + "/" + fileName));
            } catch (IOException e) {
                return e.getMessage();
            }catch( RuntimeException e){
                return e.getMessage();
            }
        }
        return fileName;
    }
}
