package com.sir.soir.sir2022.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

        @RequestMapping("/")
        public String hello() {
            return "Hello SIR SOIR!";
        }
}
