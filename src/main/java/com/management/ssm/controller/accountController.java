package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Account;
import com.management.ssm.repository.accountRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class accountController {
    @Autowired
    private accountRepository accountrepository;

    @RequestMapping(method = RequestMethod.POST)
    public String insertAccount(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        Account account = new Account();
        if (!(object.has("account_TOTAL")))
            return "Enter details of account.";
        else
            account.setACCOUNT_TOTAL(object.getDouble("account_TOTAL"));
        if (object.has("account_DISCOUNT"))
            account.setACCOUNT_DISCOUNT(object.getDouble("account_DISCOUNT"));
        accountrepository.saveAndFlush(account);
        return mapper.writeValueAsString(account);
    }
}
