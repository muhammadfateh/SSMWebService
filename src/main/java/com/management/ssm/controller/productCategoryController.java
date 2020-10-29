package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.ProductCategory;
import com.management.ssm.repository.productCategoryRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/productcategory")
public class productCategoryController {
    @Autowired
    private productCategoryRepository producttyperepository;

    //	Getting all records
    @RequestMapping(method = RequestMethod.GET)
    public String getAllProductTypes() throws JsonProcessingException {
        List<ProductCategory> productlist = producttyperepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(productlist);
        return value;
    }

    //	Getting all records
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProductTypeAsString(@PathVariable long id) throws JsonProcessingException {
        ProductCategory productlist = producttyperepository.findOne(id);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(productlist);
        return value;
    }

    //	Entering a record
    @RequestMapping(method = RequestMethod.POST)
    public String insertProduct(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ProductCategory pro = new ProductCategory();
        JSONObject object = new JSONObject(data);
        if (!object.has("productcategory_NAME"))
            return "Please enter product type name";
        // Entering data into object of a product
        pro.setPRODUCTCATERGORY_NAME(object.getString("productcategory_NAME"));
        if (object.has("productcategoryparent_ID") && object.getLong("productcategoryparent_ID") != 0)
            pro.setPRODUCTCATEGORYPARENT_ID(producttyperepository.findOne(object.getLong("productcategoryparent_ID")));
        pro.setPRODUCTCATERGORY_ACTIVE('Y');
        producttyperepository.saveAndFlush(pro);
        return mapper.writeValueAsString(pro);
    }

    //	Updating a record
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable long id, @RequestBody String data) throws UnknownHostException, JsonProcessingException {
        //Getting ip address, name and setting date
        InetAddress inetAddress = InetAddress.getLocalHost();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        JSONObject object = new JSONObject(data);
        ObjectMapper mapper = new ObjectMapper();
        //Updation of producttype
        ProductCategory producttype = producttyperepository.findOne(id);
        if (object.has("productcategory_NAME"))
            producttype.setPRODUCTCATERGORY_NAME(object.getString("productcategory_NAME"));
        if (object.has("deactive"))
            producttype.setPRODUCTCATERGORY_ACTIVE('N');
        producttype.setPRODUCTCATERGORYMODIFIED_BY(inetAddress.getHostName());
        producttype.setPRODUCTCATERGORYMODIFIED_WORKSTATION(inetAddress.getHostAddress());
        producttype.setPRODUCTCATERGORYMODIFIED_WHEN(dateFormatter.format(date));
        //Saving in Database
        producttyperepository.saveAndFlush(producttype);
        return mapper.writeValueAsString(producttype);
    }

    //	Deleting a record
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        ProductCategory producttype = producttyperepository.findOne(id);
        producttyperepository.delete(id);
        return "\"" + producttype.getPRODUCTCATERGORY_NAME() + "\" has been deleted";
    }

}
