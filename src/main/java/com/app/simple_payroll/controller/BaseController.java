package com.app.simple_payroll.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

  @GetMapping("/greet")
  public String greet() {
    return "user";
  }
}