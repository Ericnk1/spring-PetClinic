package com.example.springpetclinic.controllers;

import com.example.springpetclinic.models.IsVaccinated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/isVaccinated")
public class IsVaccinatedController {

    @GetMapping
    public List<IsVaccinated> getIsVaccinated() {return Arrays.asList(IsVaccinated.values());
    }
}
