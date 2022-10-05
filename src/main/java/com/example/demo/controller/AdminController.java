package com.example.demo.controller;

import com.example.demo.data.UserJSONData;
import com.example.demo.service.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private Users users;
    @PostMapping("/addNewUserAddress")
    public String addNewUserAddress(@RequestBody UserJSONData userData) {
        if(!users.addAddress(userData)) {
            return "403 ERROR: Address-id associated with same username exists in database.";
        }
        return "200: User created successfully";
    }

    @PostMapping("/deleteUserAddress")
    public String deleteUserAddress(@RequestBody UserJSONData userData) {
        if(!users.deleteAddress(userData)) {
            return "403 ERROR: Address-id associated with same username doesn't exist in database.";
        }
        return "200: Address associated with username deleted successfully";
    }

    @PostMapping("/updateAddress")
    public String updateAddress(@RequestBody UserJSONData userData) {
        if(!users.updateAddress(userData)) {
            return "403 ERROR: This address doesn't exist in database.";
        }
        return "200: Address updated for all users associated with this addressId";
    }
    @GetMapping("/isAddressIdAvailable")
    public String isAddressIdAvailable(@RequestBody UserJSONData userData) {
        if(users.isAddressIdAvailable(userData)) {
            return "TRUE: Your address id doesn't exist in database. Hence, it is available for fresh use.";
        }
        else {
            return "FALSE: Your address id exists in database. Call GET API '/getAddress to fetch address";
        }
    }
    @GetMapping("/getAddress")
    public String getAddress(@RequestBody UserJSONData userData) {
        String address = users.getAddress(userData);
        if(address.equalsIgnoreCase("false")) {
            return "404 ERROR: Address with given addressId not found!!";
        }
        else {
            return address;
        }
    }
}
