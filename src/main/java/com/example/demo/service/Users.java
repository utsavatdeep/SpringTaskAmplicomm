package com.example.demo.service;

import com.example.demo.dao.AddressDAOImpl;
import com.example.demo.dao.UserDataDAOImpl;
import com.example.demo.data.Address;
import com.example.demo.data.UserData;
import com.example.demo.data.UserJSONData;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Users {

    @Autowired
    UserDataDAOImpl userDataDAO;
    @Autowired
    AddressDAOImpl addressDAO;


    public boolean addAddress(UserJSONData userJSONData) {
        if(userDataDAO.isAddressExists(userJSONData.getUsername(), userJSONData.getAddressId())) {
            return false;
        }
        else {
            if(!addressDAO.isExists(userJSONData.getAddressId())) {
                addressDAO.insert(createAddress(userJSONData.getAddressId(), userJSONData.getAddress()));
            }
            userDataDAO.insert(createUserData(userJSONData.getUsername(),userJSONData.getAddressId()));
            return true;
        }
    }
    public boolean updateAddress(UserJSONData userJSONData) {
        if(!addressDAO.isExists(userJSONData.getAddressId())) {
            return false;
        }
        else {
            addressDAO.update(userJSONData.getAddressId(), userJSONData.getAddress());
            return true;
        }
    }
    public boolean deleteAddress(UserJSONData userJSONData) {
        if(! userDataDAO.isAddressExists(userJSONData.getUsername(), userJSONData.getAddressId()) ) {
            return false;
        }
        else {
            userDataDAO.deleteUserAddress(userJSONData.getUsername(), userJSONData.getAddressId());
            return true;
        }
    }

    public boolean isAddressIdAvailable(UserJSONData userJSONData) {
        if(addressDAO.isExists(userJSONData.getAddressId()))
            return false;
        else
            return true;
    }

    public String getAddress(UserJSONData userJSONData) {
        if(!addressDAO.isExists(userJSONData.getAddressId())) {
            return "false";
        }
        else {
            return addressDAO.select(userJSONData.getAddressId());
        }
    }

    private UserData createUserData(String username, String addressId) {
        UserData userData = new UserData();
        userData.setUserName(username);
        userData.setAddressId(addressId);
        return userData;
    }
    private Address createAddress(String addressId, String address) {
        Address addressObj = new Address();
        addressObj.setAddressId(addressId);
        addressObj.setAddress(address);
        return addressObj;
    }

}
