package com.indiafrominside.population.populationAPI.controller;

import com.indiafrominside.population.populationAPI.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PopulationController {

    @Autowired
    private PopulationService populationService;

    @GetMapping("/population")
    public int getPopulation(@RequestParam("city") String city) throws IOException {
        System.out.println(populationService.getPopulation(city));
        return populationService.getPopulation(city);
    }
}
