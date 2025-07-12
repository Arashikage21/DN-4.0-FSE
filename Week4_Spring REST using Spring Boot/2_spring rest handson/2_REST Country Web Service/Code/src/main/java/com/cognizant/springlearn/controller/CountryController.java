package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @RequestMapping("/country")
    public Country getCountryIndia() {
        var ctx = new ClassPathXmlApplicationContext("country.xml");
        Country c = ctx.getBean("country", Country.class);
        ctx.close();
        return c;
    }
}
