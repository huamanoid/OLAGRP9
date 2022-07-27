package com.khana.khazana.controller;

import com.khana.khazana.model.BanUserResponse;
import com.khana.khazana.model.ProfileRequest;
import com.khana.khazana.model.ShowAllCustomerResponse;
import com.khana.khazana.model.Users;
import com.khana.khazana.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @GetMapping(value = "/showAllCustomer")
    public ResponseEntity<ShowAllCustomerResponse> DisplayAllUsers(){
        return new ResponseEntity<>(adminService.AllCustomer(), HttpStatus.OK);
    }

    @GetMapping(value = "/showAllRestaurant")
    public ResponseEntity<ShowAllCustomerResponse> DisplayAllRestaurants(){
        return new ResponseEntity<>(adminService.AllRestaurant(), HttpStatus.OK);
    }

//    @GetMapping(value = "/showOrders/userId={}")
//    public ResponseEntity<ShowAllCustomerResponse> DisplayOrders(){
//        return new ResponseEntity<>(adminService.AllOrders(), HttpStatus.OK)
//    }

    @GetMapping(value = "/manageUser/{userId}")
    public ResponseEntity<BanUserResponse> BanUser(@PathVariable long userId){
        return new ResponseEntity<>(adminService.banUser(userId), HttpStatus.OK);
    }
}
