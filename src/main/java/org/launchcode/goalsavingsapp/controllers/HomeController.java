package org.launchcode.goalsavingsapp.controllers;

import org.launchcode.goalsavingsapp.models.data.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private GoalRepository goalRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Goals");
        model.addAttribute("goal", goalRepository.findAll());

        return "index";
    }




}
