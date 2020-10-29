package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.enums.Status;
import com.management.ssm.model.Cart;
import com.management.ssm.model.CartItem;
import com.management.ssm.repository.cartItemRepository;
import com.management.ssm.repository.cartRepository;
import com.management.ssm.repository.customerRepository;
import com.management.ssm.repository.productRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cartitem")
public class cartItemController {
    @Autowired
    private cartItemRepository cartitemrepository;

    @DeleteMapping(name = "{id}")
    public String deleteCartItem(@RequestParam long id) throws JsonProcessingException {
        CartItem item = cartitemrepository.findOne(id);
        ObjectMapper mapper = new ObjectMapper();

        cartitemrepository.delete(id);
        return mapper.writeValueAsString(item);
    }
}
