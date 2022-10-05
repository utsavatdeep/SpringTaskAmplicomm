package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
public class Address {
    String addressId; // pKey and auto-incremental value
    String address; // unique value
}
