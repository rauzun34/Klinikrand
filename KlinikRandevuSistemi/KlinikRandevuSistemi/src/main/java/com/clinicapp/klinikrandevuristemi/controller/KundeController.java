package com.clinicapp.klinikrandevuristemi.controller;

import com.clinicapp.klinikrandevuristemi.model.Kunde;
import com.clinicapp.klinikrandevuristemi.service.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping("/kunde")
@CrossOrigin(origins = "*")
public class KundeController {

    private KundenService kundenService;

    @Autowired
    public KundeController(KundenService kundenService) {
        this.kundenService = kundenService;
    }

    @RequestMapping(value= "/add", method = RequestMethod.GET)
    public String KundeHinzufugenPage(@ModelAttribute("kunde") Kunde kunde){
        return "kunde/add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String KundeHinzufugen(@ModelAttribute Kunde kunde , RedirectAttributes redirectAttributes){
        kundenService.saveKunde(kunde);
        redirectAttributes.addFlashAttribute("kunde",kunde);
        return kunde.toString();
    }

    @RequestMapping(value= "/update/{BurgerID}", method = RequestMethod.GET)
    public String KundeAnzeigenPage(@PathVariable("BurgerID") Long BurgerID, ModelMap modelMap, RedirectAttributes redirectAttributes){
        Optional<Kunde> optionalKunde = kundenService.findKundeByBurgerID(BurgerID);

        if(optionalKunde.isPresent()){
            Kunde kunde = optionalKunde.get();
            modelMap.addAttribute("kunde",kunde);
            return "kunde/update";
        }
        redirectAttributes.addFlashAttribute("NichtGefunden","Ups!!Etwas bei der Aktualisierung der Patient-Informationen Schiff gegangen.");
        return "redirect:/kunde/update";
    }

    @RequestMapping(value = "/update/{BurgerID} ", method = RequestMethod.POST)
    public String KundeAnzeigen(@ModelAttribute Kunde kunde , @PathVariable("BurgerID") Long BurgerID, ModelMap modelMap, RedirectAttributes redirectAttributes){
        kundenService.updateKunde(kunde);
        redirectAttributes.addFlashAttribute("succesfullyUpdatedKunde", "Die Patient-Informationen sind aktualisiert.");
        return "redirect:/kunde/update";
    }

}
