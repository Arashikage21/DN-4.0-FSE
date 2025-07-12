package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import org.springframework.stereotype.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Service
public class CountryServiceImp implements CountryService {

    private final List<Country> countryList;

    public CountryServiceImp() {
        // Load the Spring XML and retrieve the List<Country>
        try (var ctx = new ClassPathXmlApplicationContext("country.xml")) {
            //noinspection unchecked
            this.countryList = (List<Country>) ctx.getBean("countryList", List.class);
        }
    }

    @Override
    public Country getCountry(String code) {
        // Case-insensitive search
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
