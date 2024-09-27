package com.example.demo.controllers;

import com.example.demo.model.HHUser;
import com.example.demo.service.HHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;


@CrossOrigin
@RestController
//local:####/get
//local:####/hello

public class HHController {
    // Initialize repository here

    //public repository ... Initilizer

    public HHService hhService;


    //constructor
    @Autowired
    public HHController(HHService hhService) {
        this.hhService = hhService;
    }

    @PostMapping("/create")
    //post from frontend
    public String createUser(@RequestBody HHUser user) throws InterruptedException, ExecutionException {
        return hhService.createUser(user);
    }
    /*public String test2(@RequestBody int x){
        System.out.println(x);
        if (x == 80085)
            return "Boobies";
        return "German is pretty cool";
    }*/

    @GetMapping("/get")// pass to frontend
    public String getUser(@RequestParam String id) throws InterruptedException, ExecutionException {
        return hhService.getUser(id);
    }
    /*public String test (){
        try{
            return "Boobies";
        }catch (Exception e){
            throw new RuntimeException();
        }
    }*/

    //updates user
    @PutMapping("/update")
    public String updateUser(@RequestBody HHUser user) throws InterruptedException, ExecutionException {
        return hhService.updateUser(user);
    }

    //removes user
    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody String id) throws InterruptedException, ExecutionException {
        return hhService.deleteUser(id);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test works pog!");
    }



}
