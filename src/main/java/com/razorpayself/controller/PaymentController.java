package com.razorpayself.controller;


import com.razorpay.*;
import com.razorpayself.payload.OrderRequest;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    //http://localhost:8080/api/create-order

    @PostMapping("/create-order")
    public String createOrder(@RequestBody OrderRequest order) throws Exception{

        RazorpayClient razorpay = new RazorpayClient("rzp_test_gAn1lvdazA9j5c", "I2bWfYXhCWrTqZKQpNaq8ldY");//from the razorpay lib

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount",order.getAmount());
        orderRequest.put("currency","INR");
        orderRequest.put("receipt", "shrb123");  // hardcoded for now
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        orderRequest.put("notes",notes);

        Order orderResponse = razorpay.orders.create(orderRequest);
        System.out.println(orderResponse);

        return orderResponse.get("id").toString();
    }


}
