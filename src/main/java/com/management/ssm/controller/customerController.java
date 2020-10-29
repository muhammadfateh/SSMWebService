package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Customer;
import com.management.ssm.model.CustomerProduct;
import com.management.ssm.model.Product;
import com.management.ssm.repository.customerRepository;
import com.management.ssm.repository.productRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class customerController {

    @Autowired
    private customerRepository customerrepository;

    @Autowired
    private productRepository productrepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllCustomer() throws JsonProcessingException {
        List<Customer> list = customerrepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(list);
        return value;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getCustomerById(@PathVariable long id) throws JsonProcessingException {
        Customer customer = customerrepository.findOne(id);
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(customer);
        return value;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertCustomer(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = new Customer();
        JSONObject object = new JSONObject(data);
        if (!(object.has("customer_NAME")
                && object.has("customercontact_NO")
                && object.has("customer_PASSWORD")))
            return "Please Enter the Data of Customer";

        customer.setCUSTOMER_NAME(object.getString("customer_NAME"));
        customer.setCUSTOMERCONTACT_NO(object.getString("customercontact_NO"));
        customer.setCUSTOMERIS_ACTIVE("Y");
        customer.setCUSTOMER_PASSWORD(object.getString("customer_PASSWORD"));
        customerrepository.saveAndFlush(customer);
        return mapper.writeValueAsString(customer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String updateCustomer(@PathVariable Long id, @RequestBody String data) throws UnknownHostException, JsonProcessingException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        Customer customer = customerrepository.findOne(id);
        if (object.has("customer_NAME"))
            customer.setCUSTOMER_NAME(object.getString("customer_NAME"));
        if (object.has("customercontact_NO"))
            customer.setCUSTOMERCONTACT_NO(object.getString("customercontact_NO"));
        if (object.has("customer_PASSWORD"))
            customer.setCUSTOMER_PASSWORD(object.getString("customer_PASSWORD"));
        if (object.has("deactive"))
            customer.setCUSTOMERIS_ACTIVE("N");
        customer.setCUSTOMERMODIFIED_BY(inetAddress.getHostName());
        customer.setCUSTOMERMODIFIED_WHEN(dateformatter.format(date));
        customer.setCUSTOMERMODIFIED_WORKSTATION(inetAddress.getHostAddress());
        customerrepository.saveAndFlush(customer);
        return mapper.writeValueAsString(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        Customer customer = customerrepository.findOne(id);
        customerrepository.delete(id);
        return customer.getCUSTOMER_NAME() + " Customer Data has been deleted Successfully !";
    }

    //Review Service is here.
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public String insertReview(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        //Usable Objects.
        CustomerProduct review = new CustomerProduct();
        if (!(object.has("cp_REVIEW")
        ) && object.has("cpproduct_ID")
                && object.has("cpcustomer_ID"))
            return "Enter details of description.";
        else {
            Product product = productrepository.findOne(object.getLong("cpproduct_ID"));
            Customer customer = customerrepository.findOne(object.getLong("cpcustomer_ID"));
            //Got objects for Bi-directional mapping.
            review.setCP_Date(dateFormatter.format(date));
            review.setCP_REVIEW(object.getString("cp_REVIEW"));
            review.setCPPRODUCT_ID(product);
            review.setCPCUSTOMER_ID(customer);

            customer.getCustomerreviews().add(review);
            //product.getProductreviews().add(review);

            productrepository.saveAndFlush(product);
            customerrepository.saveAndFlush(customer);
            //Bi-directional mapping done.
        }
        return mapper.writeValueAsString(review);
    }

    @RequestMapping(value = "/review", method = RequestMethod.PUT)
    public String updateReview(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        CustomerProduct review = new CustomerProduct();
        //Usable Objects.
        if (!(object.has("cp_REVIEW")
        ) && object.has("cpproduct_ID")
                && object.has("cpcustomer_ID"))
            return "Enter full details for updation.";
        else {
            Product product = productrepository.findOne(object.getLong("cpproduct_ID"));
            Customer customer = customerrepository.findOne(object.getLong("cpcustomer_ID"));
            review.setCPPRODUCT_ID(product);
            review.setCPCUSTOMER_ID(customer);
            //Getting previous save review from Customer Reviews Set.
            for (CustomerProduct prevreview :
                    customer.getCustomerreviews()) {
                if (review.equals(prevreview)) {
                    review = prevreview;
                }
            }
            //Making changes in current review.
            review.setCP_Date(dateFormatter.format(date));
            review.setCP_REVIEW(object.getString("cp_REVIEW"));

            productrepository.saveAndFlush(product);
            customerrepository.saveAndFlush(customer);
            //Bi-directional mapping done.
        }
        return mapper.writeValueAsString(review);
    }

    @RequestMapping(value = "/review", method = RequestMethod.DELETE)
    public String deleteReview(@RequestBody String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject(data);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        Date date = new Date();
        CustomerProduct review = new CustomerProduct();
        //Usable Objects.
        if (!object.has("cpproduct_ID")
                && object.has("cpcustomer_ID"))
            return "Enter full details for deletion.";
        else {
            Product product = productrepository.findOne(object.getLong("cpproduct_ID"));
            Customer customer = customerrepository.findOne(object.getLong("cpcustomer_ID"));
            review.setCPPRODUCT_ID(product);
            review.setCPCUSTOMER_ID(customer);
            //Getting previous save review from Customer Reviews Set.
            for (CustomerProduct prevreview :
                    customer.getCustomerreviews()) {
                if (review.equals(prevreview)) {
                    review = prevreview;
                    customer.removeReview(review);
                    product.removeReview(review);
                }
            }
            productrepository.saveAndFlush(product);
            customerrepository.saveAndFlush(customer);
            //Bi-directional mapping done.
        }
        return mapper.writeValueAsString(review.getCP_REVIEW() + "is removed successfully.");
    }
}