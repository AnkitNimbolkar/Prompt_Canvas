//package com.aiphoto.backend.controller;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
//public class GenerateController {
//
//    @PostMapping("/generate")
//    public Map<String, String> generate(@RequestBody Map<String, Object> body) {
//        System.out.println("Received request: " + body);
//
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Hello from backend!");
//        return response;
//    }
//}
