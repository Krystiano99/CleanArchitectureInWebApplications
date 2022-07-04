package com.umcs.barbershop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {




    @RequestMapping("/")
    String home() {
        return "Hello Worrfgld!";
    }

}


