package com.ivoronline.springboot_filter_urlspecific.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/NotFiltered")
  public String notFiltered() {
    System.out.println("CONTROLLER: Hello from NOT Filtered Endpoint");
    return "Hello from NOT Filtered Endpoint";
  }

  @ResponseBody
  @RequestMapping("/Filtered")
  public String filtered() {
    System.out.println("CONTROLLER: Hello from Filtered Endpoint");
    return "Hello from Filtered Endpoint";
  }

}
