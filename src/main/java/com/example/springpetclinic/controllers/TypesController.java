package com.example.springpetclinic.controllers;

import com.example.springpetclinic.models.Types;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/types")
public class TypesController {

    @GetMapping
    public List<Types> getPetTypes() {return Arrays.asList(Types.values());
    }
}
