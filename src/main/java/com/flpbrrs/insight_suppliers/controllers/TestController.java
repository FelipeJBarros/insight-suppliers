package com.flpbrrs.insight_suppliers.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping()
    public ResponseEntity<String> HelloSuppliers() {
        return ResponseEntity.ok().body("Hello, new supplier!");
    }
}
