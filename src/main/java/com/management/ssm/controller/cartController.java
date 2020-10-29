package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.enums.Status;
import com.management.ssm.model.Cart;
import com.management.ssm.model.CartItem;
import com.management.ssm.model.Order;
import com.management.ssm.repository.cartItemRepository;
import com.management.ssm.repository.cartRepository;
import com.management.ssm.repository.customerRepository;
import com.management.ssm.repository.productRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/cart")
public class cartController {

    @Autowired
    private cartRepository cartrepository;

    @Autowired
    private cartItemRepository cartitemrepository;

    @Autowired
    private productRepository productrepository;

    @Autowired
    private customerRepository customerrepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllOrder() throws JsonProcessingException {
        List<Cart> list = cartrepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOrderById(@PathVariable long id) throws JsonProcessingException {
        Cart cart = cartrepository.findOne(id);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(cart);
        return value;
    }

    @PostMapping
    public String generateCart(@RequestBody String data) throws JsonProcessingException {
        Cart cart = new Cart();
        double subtotal = 0;
        JSONObject object = new JSONObject(data);
        ObjectMapper mapper = new ObjectMapper();
//        Usable Elements

        if (!object.has("cartItems")) {
            return "Please Enter atleast one item.";
        }
        if (!object.has("cartcustomer_ID")) {
            return "Please Enter customer id.";
        }
        if (object.has("cart_STATUS"))
            cart.setCART_STATUS(Status.valueOf(object.getString("cart_STATUS")).ordinal());
        else
            cart.setCART_STATUS(Status.PENDING.ordinal());

        JSONArray cartitems = object.getJSONArray("cartItems");
        for (int i = 0; i < cartitems.length(); i++) {
            JSONObject itemobject = cartitems.getJSONObject(i);
            CartItem cartitem = new CartItem();

            cartitem.setCARTITEM_QUANTITY(itemobject.getDouble("cartitem_QUANTITY"));
            cartitem.setCARTITEMPRODUCT_ID(productrepository.findOne(itemobject.getLong("cartitemproduct_ID")));
            cartitem.setCARTITEMCART_ID(cart);
//            adding each single cart item in cart
            cart.getCartItems().add(cartitem);
//            getting subtotal by adding price of each item
            subtotal += cartitem.getCARTITEMPRODUCT_ID().getPRODUCT_PRICE() * cartitem.getCARTITEM_QUANTITY();
        }
        cart.setCARTSUB_TOTAL(subtotal);
        cart.setCARTCUSTOMER_ID(customerrepository.findOne(object.getLong("cartcustomer_ID")));

        cartrepository.saveAndFlush(cart);

        return mapper.writeValueAsString(cart);
    }

    @PutMapping(value = "{id}")
    public String updateCart(@PathVariable long id, @RequestBody String data) throws JsonProcessingException {
        Cart cart = cartrepository.findOne(id);
        double subtotal = 0;
        JSONObject object = new JSONObject(data);
        ObjectMapper mapper = new ObjectMapper();
//        Usable Elements
        if (object.has("cart_STATUS"))
            cart.setCART_STATUS(Status.valueOf(object.getString("cart_STATUS")).ordinal());
        else
            cart.setCART_STATUS(Status.PENDING.ordinal());
        if (object.has("cartItems")) {
            cart.setCartItems(new HashSet<CartItem>());
            JSONArray cartitems = object.getJSONArray("cartItems");
            for (int i = 0; i < cartitems.length(); i++) {
                JSONObject itemobject = cartitems.getJSONObject(i);
                CartItem cartitem = new CartItem();


                cartitem.setCARTITEM_QUANTITY(itemobject.getDouble("cartitem_QUANTITY"));
                cartitem.setCARTITEMPRODUCT_ID(productrepository.findOne(itemobject.getLong("cartitemproduct_ID")));
                cartitem.setCARTITEMCART_ID(cart);
//            adding each single cart item in cart
                cart.getCartItems().add(cartitem);
//            getting subtotal by adding price of each item
                subtotal += cartitem.getCARTITEMPRODUCT_ID().getPRODUCT_PRICE() * cartitem.getCARTITEM_QUANTITY();
            }
        }
        cart.setCARTSUB_TOTAL(subtotal);

        cartrepository.saveAndFlush(cart);

        return mapper.writeValueAsString(cart);
    }

    @DeleteMapping(value = "deleteitem/{cartid}/{cartitemid}")
    public String deleteCartItem(@PathVariable long cartid, @PathVariable long cartitemid) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CartItem cartitem = cartitemrepository.findOne(cartitemid);
        Cart cart = cartrepository.findOne(cartid);

        cart.getCartItems().remove(cartitem);

        cartrepository.saveAndFlush(cart);
        return mapper.writeValueAsString(cart);
    }

    @PutMapping(value = "additem/{cartid}")
    public String insertSingleItemInCart(@PathVariable long cartid, @RequestBody String data) throws JsonProcessingException {
        JSONObject object = new JSONObject(data);
        ObjectMapper mapper = new ObjectMapper();
        CartItem item = new CartItem();

        Cart cart = cartrepository.findOne(cartid);
        if (object.has("cartitem")) {
            item.setCARTITEMCART_ID(cart);
            item.setCARTITEMPRODUCT_ID(productrepository.findOne(object.getLong("cartitemproduct_ID")));
            item.setCARTITEM_QUANTITY(object.getDouble("cartitem_QUANTITY"));
            cart.getCartItems().add(item);
        }
        return mapper.writeValueAsString(cart);
    }
}
