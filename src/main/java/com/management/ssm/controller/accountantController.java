package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Accountant;
import com.management.ssm.repository.accountantRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/accountant")
public class accountantController {
    @Autowired
    private accountantRepository accountantrepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllAccountant() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Accountant> accountant = accountantrepository.findAll();
        return mapper.writeValueAsString(accountant);
    }


    //To get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOne(@PathVariable Long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Accountant accountant = accountantrepository.findOne(id);
        return mapper.writeValueAsString(accountant);
    }


    //To get all active record
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllActiveAccountant() throws JsonProcessingException {
        List<Accountant> list = accountantrepository.findActive();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }


//		Getting active record by search

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getStaffBySearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("search"))
            return "Search string is missing";
        List<Accountant> list = accountantrepository.findBySearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

//		Getting all record by search including non-active ones

    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    public String getAllStaffBySearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("search"))
            return "Search string is missing";
        List<Accountant> list = accountantrepository.findAllBySearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insert(@RequestBody String data) throws JsonProcessingException {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYY HH:mm:ss");
        Date date = new Date();
        ObjectMapper mapper = new ObjectMapper();
        Accountant accountant = new Accountant();
        JSONObject object = new JSONObject(data);
        if (!object.has("ACCOUNTANT_NAME")) {
            return "Accountant Name Is Missing";
        }
        accountant.setACCOUNTANT_NAME(object.getString("ACCOUNTANT_NAME"));
        accountant.setACCOUNTANT_ADDRESS(object.getString("ACCOUNTANT_ADDRESS"));
        accountant.setACCOUNTANTCONTACT_NO(object.getString("ACCOUNTANTCONTACT_NO"));
        accountant.setACCOUNTANT_SALARY(object.getString("ACCOUNTANT_SALARY"));
        accountant.setACCOUNTANT_USERNAME(object.getString("ACCOUNTANT_USERNAME"));
        accountant.setACCOUNTANT_PASSWORD(object.getString("ACCOUNTANT_PASSWORD"));
        accountant.setACCOUNTANTIS_ACTIVE("Y");
        accountant.setACCOUTANTMODIFIED_BY("A");
        accountant.setACCOUNTANTMODIFIED_WHEN(format1.format(date));
        accountant.setACCOUNTANTMODIFIED_WORKSTATION("N");
        accountant = accountantrepository.saveAndFlush(accountant);
        return mapper.writeValueAsString(accountant);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String updateAccountant(@PathVariable Long id, @RequestBody String data) throws JsonProcessingException {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        Accountant accountant = accountantrepository.findOne(id);
        if (object.has("ACCOUNTANT_NAME"))
            accountant.setACCOUNTANT_NAME(object.getString("ACCOUNTANT_NAME"));
        if (object.has("ACCOUNTANTUSER_NAME"))
            accountant.setACCOUNTANT_USERNAME(object.getString("ACCOUNTANTUSER_NAME"));
        if (object.has("ACCOUNTANT_PASSWORD"))
            accountant.setACCOUNTANT_PASSWORD(object.getString("ACCOUNTANT_PASSWORD"));
        if (object.has("deactive"))
            accountant.setACCOUNTANTIS_ACTIVE("N");
        accountant.setACCOUNTANTMODIFIED_WHEN(dateformatter.format(date));
        accountant.setACCOUNTANTMODIFIED_WORKSTATION("Haier-PC");
        accountant.setACCOUTANTMODIFIED_BY("Ammara");
        accountantrepository.saveAndFlush(accountant);
        return mapper.writeValueAsString(accountant);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        Accountant accountant = accountantrepository.findOne(id);
        accountantrepository.delete(accountant);
        return "your record has been deleted!";
    }
}
