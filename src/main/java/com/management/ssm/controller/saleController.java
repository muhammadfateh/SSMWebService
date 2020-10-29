package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Sale;
import com.management.ssm.repository.productRepository;
import com.management.ssm.repository.saleRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/sale")
public class saleController {

    @Autowired
    private saleRepository salerepository;
    @Autowired
    private productRepository productrepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllSale() throws JsonProcessingException {
        List<Sale> list = salerepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertSale(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Sale sale = new Sale();
        JSONObject object = new JSONObject(data);
        if (!(object.has("saleproduct_ID")
                && object.has("sale_QUANTITY")))
            return "Please Enter the Detailes of Sale Product";

        sale.setSALEPRODUCT_ID(productrepository.findOne(object.getLong("saleproduct_ID")));
        sale.setSALE_QUANTITY(object.getDouble("sale_QUANTITY"));
        sale.setSALEIS_ACTIVE("Y");
        salerepository.saveAndFlush(sale);
        return mapper.writeValueAsString(sale);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String updateSale(@PathVariable Long id, @RequestBody String data) throws JsonProcessingException {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        Sale sale = salerepository.findOne(id);
        if (object.has("saleproduct_ID"))
            sale.setSALEPRODUCT_ID(productrepository.findOne(object.getLong("saleproduct_ID")));
        if (object.has("sale_QUANTITY"))
            sale.setSALE_QUANTITY(object.getDouble("sale_QUANTITY"));
        if (object.has("sale_DEACTIVE"))
            sale.setSALEIS_ACTIVE("N");
        sale.setSALEMODIFIED_BY("Hamza");
        sale.setSALEMODIFIED_WHEN(dateformatter.format(date));
        sale.setSALEMODIFIED_WORKSTATION("Dell");
        salerepository.saveAndFlush(sale);
        return mapper.writeValueAsString(sale);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        Sale sale = salerepository.findOne(id);
        salerepository.delete(id);
        return sale.getSALEPRODUCT_ID() + " Sale Data has been deleted Successfully !";
    }
}