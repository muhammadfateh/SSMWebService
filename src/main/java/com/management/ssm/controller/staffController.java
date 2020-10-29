package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Staff;
import com.management.ssm.repository.staffRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/staffid")
public class staffController {

    @Autowired
    public staffRepository staffrepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllStaff() throws JsonProcessingException {
        List<Staff> list = staffrepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    //To get all active record
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllActiveStaff() throws JsonProcessingException {
        List<Staff> list = staffrepository.findActive();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

//	Get a single record by id

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getSpecificStaff(@PathVariable long id) throws JsonProcessingException {
        Staff staff = staffrepository.findOne(id);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(staff);
        return value;
    }

//	Getting active record by search

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getStaffBySearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("search"))
            return "Search string is missing";
        List<Staff> list = staffrepository.findBySearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

//	Getting all record by search including non-active ones

    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    public String getAllStaffBySearch(@RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        if (!object.has("search"))
            return "Search string is missing";
        List<Staff> list = staffrepository.findAllBySearch(object.getString("search"));
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertStaff(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Staff staff = new Staff();
        JSONObject object = new JSONObject(data);
        if (!(object.has("Name") && object.has("Address") && object.has("Contact") && object.has("Salary")))
            return "Enter the Data";

        staff.setSTAFF_NAME(object.getString("Name"));
        staff.setSTAFFCONTACT_NO(object.getString("Contact"));
        staff.setSTAFF_ADDRESS(object.getString("Address"));
        staff.setSTAFF_SALARY(object.getString("Salary"));
        staff.setSTAFFIS_ACTIVE("Y");
        staff.setSTAFFMODIFIED_BY("N");
        staff.setSTAFFMODIFIED_WHEN("N");
        staff.setSTAFFMODIFIED_WORKSTATION("N");
        staffrepository.saveAndFlush(staff);
        return mapper.writeValueAsString(staff);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String updateStaff(@PathVariable Long id, @RequestBody String data) throws JsonProcessingException {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        Staff staff = staffrepository.findOne(id);
        if (object.has("Name"))
            staff.setSTAFF_NAME(object.getString("Name"));
        if (object.has("Contact"))
            staff.setSTAFFCONTACT_NO(object.getString("Contact"));
        if (object.has("Address"))
            staff.setSTAFF_ADDRESS(object.getString("Address"));
        if (object.has("Salary"))
            staff.setSTAFF_SALARY(object.getString("Salary"));
        if (object.has("N"))
            staff.setSTAFFIS_ACTIVE("N");
        staff.setSTAFFMODIFIED_BY("Ammara");
        staff.setSTAFFMODIFIED_WHEN(dateformatter.format(date));
        staff.setSTAFFMODIFIED_WORKSTATION("HAIER-PC");
        staffrepository.saveAndFlush(staff);
        return mapper.writeValueAsString(staff);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        Staff staff = staffrepository.findOne(id);
        staffrepository.delete(id);
        return staff.getSTAFF_NAME() + "Data deleted";
    }
}
