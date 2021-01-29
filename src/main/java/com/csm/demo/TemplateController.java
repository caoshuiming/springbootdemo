package com.csm.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("username", "csm");
        return "index";
    }
}
