package com.civil.project.rest;

import com.civil.project.entity.MargNaisAr;
import com.civil.project.service.MarginalesArService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marginales-ar")
@CrossOrigin
@RequiredArgsConstructor
public class MarginalesArRest {

    private final MarginalesArService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public MargNaisAr addMarginaleAr(@RequestBody MargNaisAr margNaisAr) {
        return service.addMarg(margNaisAr);
    }



}
