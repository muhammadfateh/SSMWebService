package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.enums.IsActive;
import com.management.ssm.enums.Status;
import com.management.ssm.model.*;
import com.management.ssm.repository.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class orderController {

    @Autowired
    private orderRepository orderrepository;
    @Autowired
    private accountRepository accountrepository;
    @Autowired
    private orderStatusRepository orderstatusrepository;
    @Autowired
    private productRepository productrepository;
    @Autowired
    private customerRepository customerrepository;
    //Controller classes for execution
    private accountController accountcontroller;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllOrder() throws JsonProcessingException {
        List<Order> list = orderrepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOrderById(@PathVariable long id) throws JsonProcessingException {
        Order order = orderrepository.findOne(id);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(order);
        return value;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertOrder(@RequestBody String data) throws JsonProcessingException {
        //Usable Elements
        double totalprice = 0;
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        JSONObject object = new JSONObject(data);
        //New objects instantiation
        Date date = new Date();
        Order order = new Order();
        Account account = new Account();
        if (!(object.has("orderstatus_ID")
                && object.has("ordercustomer_ID")
        ))
            return "Please Enter the Detailes of Order";

        //Entering the array of all sale transactions.
        if (!(object.has("order_SALES")))
            return "Please enter at leat one sale transaction in order.";
        JSONArray array = object.getJSONArray("order_SALES");
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            Sale sale = new Sale();
            sale.setSALE_QUANTITY(obj.getDouble("sale_QUANTITY"));
            sale.setSALEIS_ACTIVE("Y");
            sale.setSALEPRODUCT_ID(productrepository.findOne(obj.getLong("saleproduct_ID")));
            totalprice += sale.getSALEPRODUCT_ID().getPRODUCT_PRICE() * sale.getSALE_QUANTITY();
            sale.setSALEORDER_ID(order);
            order.getSales().add(sale);
        }
        order.setORDER_DATE(dateFormatter.format(date));
        order.setORDER_STATUS(Status.PENDING.ordinal());
//		//Populating the account object and inserting it
        account.setACCOUNT_TOTAL(totalprice);
        if (object.has("order_DISCOUNT"))
            account.setACCOUNT_DISCOUNT(object.getDouble("order_DISCOUNT"));
        //accountrepository.saveAndFlush(account);
        account.setOrder(order);
        order.setORDERACCOUNT_ID(account);
        //order.setORDERACCOUNT_ID(accountrepository.findOne(object.getLong("orderaccount_ID")));
        order.setORDERIS_ACTIVE(IsActive.ACTIVE.ordinal());
        orderrepository.saveAndFlush(order);
        return mapper.writeValueAsString(order);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String updateOrder(@PathVariable Long id, @RequestBody String data) throws JsonProcessingException, UnknownHostException {
        //Getting ip address and name
        InetAddress inetAddress = InetAddress.getLocalHost();
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        Order order = orderrepository.findOne(id);
        order.setORDER_DATE(dateformatter.format(date));
        //Bi-directional Binding is dealed here.
        if (object.has("orderaccount_ID"))
            order.setORDERACCOUNT_ID(accountrepository.findOne(object.getLong("orderaccount_ID")));
        if (object.has("orderstatus_ID")) {
            Status status = Status.valueOf(object.getString("orderstatus_ID"));
            order.setORDER_STATUS(status.ordinal());
            //New Order Status added.
        }
        //Bi-directional Binding ended here.
        if (object.has("order_DEACTIVATE"))
            order.setORDERIS_ACTIVE(IsActive.NO_ACTIVE.ordinal());
        order.setORDERMODIFIED_BY(inetAddress.getHostName());
        order.setORDERMODIFIED_WHEN(dateformatter.format(date));
        order.setORDERMODIFIED_WORKSTATION(inetAddress.getHostAddress());
        orderrepository.saveAndFlush(order);
        return mapper.writeValueAsString(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        Order order = orderrepository.findOne(id);
        orderrepository.delete(id);
        return order.getORDER_DATE() + " Dated Selected Ordered Product Data has been deleted Successfully !";
    }

}
