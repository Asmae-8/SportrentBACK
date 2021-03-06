package com.example.demo.controller;

import lombok.Data;
import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {
    private User user=new User();
    private List<OrderProduct> products=new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User client) {
        this.user = user;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }
}

@Data
class OrderProduct{
    private Long id;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

