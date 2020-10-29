package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Log;
import com.management.ssm.repository.customerRepository;
import com.management.ssm.repository.logRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/log")
public class logController {
    @Autowired
    private logRepository logrepository;
    @Autowired
    private customerRepository customerrepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllCustomer() throws JsonProcessingException {
        List<Log> list = logrepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getCustomerById(@PathVariable long id) throws JsonProcessingException {
        Log log = logrepository.findOne(id);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(log);
        return value;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertCustomer(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Log log = new Log();
        JSONObject object = new JSONObject(data);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        //Usable objects defined above
        if (!object.has("logcustomer_ID"))
            return "Incomplete information provided.";
        log.setLOGCUSTOMER_ID(customerrepository.findOne(object.getLong("logcustomer_ID")));
        log.setLOG_dATE(dateFormatter.format(date));
        logrepository.saveAndFlush(log);
        return mapper.writeValueAsString(log);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Log log = logrepository.findOne(id);
        customerrepository.delete(id);
        return mapper.writeValueAsString(log);
    }
}
