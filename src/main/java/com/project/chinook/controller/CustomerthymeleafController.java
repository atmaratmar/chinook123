package com.project.chinook.controller;

import com.project.chinook.data_access.CustomerthymeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerthymeleafController {
    private final CustomerthymeRepo customerthymeRepo;

    public CustomerthymeleafController(CustomerthymeRepo customerRepository) {
        this.customerthymeRepo = customerRepository;
    }
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getAllCustomers(Model model,String keyword){
        model.addAttribute("Artist", customerthymeRepo.getRandomArtists());
        model.addAttribute("Trck", customerthymeRepo.getRandomTrack());
        model.addAttribute("Genre", customerthymeRepo.getRandomGenre());
        model.addAttribute("Trcko", customerthymeRepo.getTrackByNameSearch(keyword));

        return "view-customers";

    }
}

