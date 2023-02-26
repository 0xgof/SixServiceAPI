package com.example.sixservice.cucumberglue;

import java.util.ArrayList;

import com.example.sixservice.services.UserService;
import com.example.sixservice.services.SecurityService;
import com.example.sixservice.services.OrderService;
import com.example.sixservice.services.TradeService;
import com.example.sixservice.models.UserModel;
import com.example.sixservice.models.SecurityModel;
import com.example.sixservice.models.OrderModel;
import com.example.sixservice.models.TradeModel;

import io.cucumber.java.en.Given; 
import io.cucumber.java.en.Then; 
import io.cucumber.java.en.When; 
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CucumberMySteps extends CucumberTestContextConfiguration { 
 
    @LocalServerPort
    String port;
    ResponseEntity<String> lastResponse;
 
    @Given("There is a user {string}") 
    public void givenUser(String user) throws JsonProcessingException { 
        String user_name = user;
        System.out.println("Attempting to add user: " + user_name + " into the database");
        // Create an instance of the ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();

        // Create an instance of the HttpHeaders class and set the Content-Type header to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an instance of the User class and serialize it to JSON
        UserModel userModel = new UserModel();
        userModel.setUsername(user);
        String json = objectMapper.writeValueAsString(userModel);

        // Create an instance of the HttpEntity class and set the body to the JSON string and headers to the HttpHeaders object
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        try {
            new RestTemplate().exchange("http://localhost:8080/user", HttpMethod.POST, requestEntity, String.class);
        } catch (HttpClientErrorException httpClientErrorException) {
            httpClientErrorException.printStackTrace();
        }
    }

    @Given("There is a security {string}") 
    public void givenSecurity(String security) throws JsonProcessingException { 
        String security_name = security;
        System.out.println("Attempting to add security: " + security_name + " into the database");
        // Create an instance of the ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();

        // Create an instance of the HttpHeaders class and set the Content-Type header to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an instance of the User class and serialize it to JSON
        SecurityModel securityModel = new SecurityModel();
        securityModel.setSecurityName(security);
        String json = objectMapper.writeValueAsString(securityModel);

        // Create an instance of the HttpEntity class and set the body to the JSON string and headers to the HttpHeaders object
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        try {
            new RestTemplate().exchange("http://localhost:8080/security", HttpMethod.POST, requestEntity, String.class);
        } catch (HttpClientErrorException httpClientErrorException) {
            httpClientErrorException.printStackTrace();
        }
    }

    @When("User {string} puts a buy order for security {string} with a price of {float} and quantity of {float}")
    public void User_puts_a_buy_order_for_security_with_a_price_of_and_quantity_of(String s, String s2, float f, float f2) throws IOException {
        String security_name = s2;
        System.out.println("Attempting to post a buy order for: " + security_name);

        String url_user = "http://localhost:8080/user/query?username="+s;
        String url_security = "http://localhost:8080/security/query?name="+s2;
        URL obj_user = new URL(url_user);
        URL obj_security = new URL(url_security);
        HttpURLConnection con_user = (HttpURLConnection) obj_user.openConnection();
        HttpURLConnection con_security = (HttpURLConnection) obj_security.openConnection();

        // optional - set request header
        con_user.setRequestMethod("GET");
        con_security.setRequestMethod("GET");

        int responseCode_user = con_user.getResponseCode();
        int responseCode_security = con_security.getResponseCode();
        System.out.println("Sending GET request to URL: " + url_user);
        System.out.println("Response code: " + responseCode_user);
        System.out.println("Sending GET request to URL: " + url_security);
        System.out.println("Response code: " + responseCode_security);
        

        // create object mapper to parse JSON response
        ObjectMapper objectMapper = new ObjectMapper();

        // read response into JSON tree
        JsonNode users = objectMapper.readTree(con_user.getInputStream());
        JsonNode securities = objectMapper.readTree(con_security.getInputStream());

        // get first user's id
        int firstSecurityId= securities.get(0).get("id").asInt();
        int firstUserId = users.get(0).get("id").asInt();
        System.out.println("First security ID: " + firstSecurityId);
        System.out.println("First user ID: " + firstUserId);

        // Create an instance of the ObjectMapper class
        ObjectMapper objectMapper_order = new ObjectMapper();

        // Create an instance of the HttpHeaders class and set the Content-Type header to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Long securityId = Long.valueOf(firstSecurityId);
        Long userId = Long.valueOf(firstUserId);

        // Create an instance of the Order class and serialize it to JSON
        OrderModel orderModel = new OrderModel();
        orderModel.setSecurityId(securityId);
        orderModel.setUserId(userId);
        orderModel.setQuantity(f2);
        orderModel.setPrice(f);
        orderModel.setType("buy");
        String json = objectMapper_order.writeValueAsString(orderModel);

        // Create an instance of the HttpEntity class and set the body to the JSON string and headers to the HttpHeaders object
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        try {
            new RestTemplate().exchange("http://localhost:8080/order", HttpMethod.POST, requestEntity, String.class);
        } catch (HttpClientErrorException httpClientErrorException) {
            httpClientErrorException.printStackTrace();
        }
    }

    @When("User {string} puts a sell order for security {string} with a price of {float} and quantity of {float}")
    public void User_puts_a_sell_order_for_security_with_a_price_of_and_quantity_of(String s, String s2, float f, float f2) throws IOException {
        String security_name = s2;
        System.out.println("Attempting to post a buy order for: " + security_name);

        String url_user = "http://localhost:8080/user/query?username="+s;
        String url_security = "http://localhost:8080/security/query?name="+s2;
        URL obj_user = new URL(url_user);
        URL obj_security = new URL(url_security);
        HttpURLConnection con_user = (HttpURLConnection) obj_user.openConnection();
        HttpURLConnection con_security = (HttpURLConnection) obj_security.openConnection();

        // optional - set request header
        con_user.setRequestMethod("GET");
        con_security.setRequestMethod("GET");

        int responseCode_user = con_user.getResponseCode();
        int responseCode_security = con_security.getResponseCode();
        System.out.println("Sending GET request to URL: " + url_user);
        System.out.println("Response code: " + responseCode_user);
        System.out.println("Sending GET request to URL: " + url_security);
        System.out.println("Response code: " + responseCode_security);
        

        // create object mapper to parse JSON response
        ObjectMapper objectMapper = new ObjectMapper();

        // read response into JSON tree
        JsonNode users = objectMapper.readTree(con_user.getInputStream());
        JsonNode securities = objectMapper.readTree(con_security.getInputStream());

        // get first user's id
        int firstSecurityId= securities.get(0).get("id").asInt();
        int firstUserId = users.get(0).get("id").asInt();
        System.out.println("First security ID: " + firstSecurityId);
        System.out.println("First user ID: " + firstUserId);

        // Create an instance of the ObjectMapper class
        ObjectMapper objectMapper_order = new ObjectMapper();

        // Create an instance of the HttpHeaders class and set the Content-Type header to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Long securityId = Long.valueOf(firstSecurityId);
        Long userId = Long.valueOf(firstUserId);

        // Create an instance of the Order class and serialize it to JSON
        OrderModel orderModel = new OrderModel();
        orderModel.setSecurityId(securityId);
        orderModel.setUserId(userId);
        orderModel.setQuantity(f2);
        orderModel.setPrice(f);
        orderModel.setType("sell");
        String json = objectMapper_order.writeValueAsString(orderModel);

        // Create an instance of the HttpEntity class and set the body to the JSON string and headers to the HttpHeaders object
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        try {
            new RestTemplate().exchange("http://localhost:8080/order", HttpMethod.POST, requestEntity, String.class);
        } catch (HttpClientErrorException httpClientErrorException) {
            httpClientErrorException.printStackTrace();
        }
    }

    @Then("A trade occurs with the price of {double} and quantity of {double}")
    public void A_trade_occurs_with_the_price_of_and_quantity_of(Double f, Double f2) throws IOException {
        String url_trade = "http://localhost:8080/trade";
        URL obj_trade = new URL(url_trade);
        HttpURLConnection con_trade = (HttpURLConnection) obj_trade.openConnection();
        con_trade.setRequestMethod("GET");
        int responseCode_trade = con_trade.getResponseCode();
        System.out.println("Sending GET request to URL: " + url_trade);
        System.out.println("Response code: " + responseCode_trade);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode trades = objectMapper.readTree(con_trade.getInputStream());

        String url_order = "http://localhost:8080/order";
        URL obj_order = new URL(url_order);
        HttpURLConnection con_order = (HttpURLConnection) obj_order.openConnection();
        con_order.setRequestMethod("GET");
        int responseCode_order = con_order.getResponseCode();
        System.out.println("Sending GET request to URL: " + url_order);
        System.out.println("Response code: " + responseCode_order);
        JsonNode orders = objectMapper.readTree(con_order.getInputStream());
        System.out.println(orders.toString());

        for (JsonNode trade : trades) {
            double price = trade.get("price").asDouble();
            double quantity = trade.get("quantity").asDouble();
            
            if (price == f && quantity == f2) {
                // found the trade with the desired price and quantity
                int id = trade.get("id").asInt();
                int sellOrderId = trade.get("sellOrderId").asInt();
                int buyOrderId = trade.get("buyOrderId").asInt();
                
                for (JsonNode order : orders){
                    String order_type = order.get("type").asText();
                    if (order_type == "sell"){
                        Assertions.assertEquals(order.get("id").asInt() , sellOrderId);
                    }
                    if (order_type == "buy"){
                        Assertions.assertEquals(order.get("id").asInt() , buyOrderId);
                    }
                }
                System.out.println("Found trade with id " + id + ", sellOrderId " + sellOrderId + ", buyOrderId " + buyOrderId + ", price " + price + ", quantity " + quantity);
            }
        }
    }
}