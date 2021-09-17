package com.project.chinook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class CustomersController {

    @GetMapping
    String getAllCustomers(Model model){
        SqliteHelper helper = new SqliteHelper();


            model.addAttribute("something", helper.selectAllCustomers() );



        return "allCustomers";
    }
}
