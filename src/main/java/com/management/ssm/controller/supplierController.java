package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Supplier;
import com.management.ssm.repository.supplierRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/supplier")
public class supplierController {
    @Autowired
    private supplierRepository suppliererpository;

    @RequestMapping(method = RequestMethod.GET)
    public String get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(suppliererpository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(suppliererpository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertSupplier(@RequestBody String data) throws JsonProcessingException {
        Supplier supplier = new Supplier();
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        if (!(object.has("name")) && object.has("contact") && object.has("email")) {
            return "Enter required Information";
        }
        supplier.setSUPPLIER_NAME(object.getString("name"));
        supplier.setSUPPLIERCONTACT_NO(object.getString("contact"));
        supplier.setSUPPLIER_EMAIL(object.getString("email"));
        supplier.setSUPPLIERMODIFIED_BY("N");
        supplier.setSUPPLIERMODIFIED_WORKSTATION("N");
        supplier.setSUPPLIERIS_ACTIVE('Y');
        supplier.setSUPPLIERMODIFIED_WHEN("N");
        suppliererpository.saveAndFlush(supplier);
        return mapper.writeValueAsString(supplier);
    }

    //	Updating a record
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateSupplier(@PathVariable long id, @RequestBody String data) throws UnknownHostException, JsonProcessingException {
        //Getting ip address and name
        InetAddress inetAddress = InetAddress.getLocalHost();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        JSONObject object = new JSONObject(data);
        ObjectMapper mapper = new ObjectMapper();
        //Updation of supplier
        Supplier supplier = suppliererpository.getOne(id);
        if (object.has("name"))
            supplier.setSUPPLIER_NAME(object.getString("name"));
        if (object.has("contact"))
            supplier.setSUPPLIERCONTACT_NO(object.getString("contact"));
        if (object.has("email"))
            supplier.setSUPPLIER_EMAIL(object.getString("email"));
        if (object.has("deactive"))
            supplier.setSUPPLIERIS_ACTIVE('N');
        supplier.setSUPPLIERMODIFIED_BY(inetAddress.getHostName());
        supplier.setSUPPLIERMODIFIED_WORKSTATION(inetAddress.getHostAddress());
        supplier.setSUPPLIERMODIFIED_WHEN(dateFormatter.format(date));
        //Saving in Database
        suppliererpository.saveAndFlush(supplier);
        return supplier.getSUPPLIER_NAME() + " has been updated.";
    }

    //	Deleting a record
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        Supplier supplier = suppliererpository.findOne(id);
        suppliererpository.delete(id);
        return supplier.getSUPPLIER_NAME() + " has been deleted";
    }
}
