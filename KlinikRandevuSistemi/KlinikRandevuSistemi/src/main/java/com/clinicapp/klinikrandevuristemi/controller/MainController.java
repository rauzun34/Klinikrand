package com.clinicapp.klinikrandevuristemi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.clinicapp.klinikrandevuristemi.model.*;
import com.clinicapp.klinikrandevuristemi.service.*;

@Controller
public class MainController {

    private KundenService kundenService;
    private TerminService terminService;
    private ArztService arztService;
    private ZimmerService zimmerService;

    @Autowired
    public MainController(KundenService kundenService, TerminService terminService, ArztService arztService, ZimmerService zimmerService) {
        this.kundenService = kundenService;
        this.terminService = terminService;
        this.arztService = arztService;
        this.zimmerService = zimmerService;
    }

    @RequestMapping(value = {"/","/index","/index.html"})
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
