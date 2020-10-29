package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Administrator;
import com.management.ssm.repository.administratorRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/administrator")

public class administratorController {
    @Autowired
    private administratorRepository administratorrepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAdministrator() throws JsonProcessingException {
        ArrayList<Administrator> administratorlist = (ArrayList<Administrator>) administratorrepository.findActive();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(administratorlist);
        return value;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllAdministrator() throws JsonProcessingException {
        ArrayList<Administrator> administratorlist = (ArrayList<Administrator>) administratorrepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(administratorlist);
        return value;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertAdministrator(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Administrator admin = new Administrator();
        JSONObject object = new JSONObject(data);
        if (!(object.has("name") && object.has("password") && object.has("adminUserName")))
            return "Please enter all information";
        admin.setADMIN_NAME(object.getString("name"));
        admin.setADMIN_PASSWORD(object.getString("password"));
        admin.setADMINUSER_NAME(object.getString("adminUserName"));
        admin.setADMINIS_ACTIVE('Y');
        administratorrepository.saveAndFlush(admin);
        return mapper.writeValueAsString(admin);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String updateAdministrator(@PathVariable long id, @RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        Administrator administrator = administratorrepository.findOne(id);
        if (object.has("name"))
            administrator.setADMIN_NAME(object.getString("name"));
        if (object.has("username"))
            administrator.setADMINUSER_NAME(object.getString("username"));
        if (object.has("password"))
            administrator.setADMIN_PASSWORD(object.getString("password"));
        if (object.has("deactive"))
            administrator.setADMINIS_ACTIVE('N');
//		administrator.setADMINMODIFIED_BY();
        ObjectMapper mapper = new ObjectMapper();
        administratorrepository.saveAndFlush(administrator);
        return mapper.writeValueAsString(administrator);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        Administrator administrator = administratorrepository.findOne(id);
        administratorrepository.delete(administrator);
        return administrator.getADMIN_NAME() + "has been deleted!";
    }

    //Search methods are here..
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getBySearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("search"))
            return "Search string is missing";
        List<Administrator> productlist = administratorrepository.findBySearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(productlist);
        return value;
    }

    @RequestMapping(value = "/searchall", method = RequestMethod.GET)
    public String getAllBySearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("search"))
            return "Search string is missing";
        List<Administrator> productlist = administratorrepository.findAllBySearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(productlist);
        return value;
    }
}