package com.civil.project.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"{_:^(?!api).*$}","/error"})
public class FrontEndController {

    @GetMapping({"","/","/*"})
    public String getIndex() {
        return "index";
    }
}
