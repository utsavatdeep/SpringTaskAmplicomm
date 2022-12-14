package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "username", "addressId", "address" })
public class UserJSONData {
    private String username;
    private String addressId;
    private String address;
}
