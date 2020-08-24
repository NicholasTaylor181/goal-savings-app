package org.launchcode.goalsavingsapp.controllers;


import org.launchcode.goalsavingsapp.models.Goal;
import org.launchcode.goalsavingsapp.models.data.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("goal")
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @GetMapping
    public String viewGoals(Model model) {
        model.addAttribute("goals", goalRepository.findAll());
        return "goals/index";
    }

    @GetMapping("create")
    public String displayCreateGoalsForm(Model model){
        model.addAttribute(new Goal());
        return "goals/create";
    }

    @PostMapping("create")
    public String processCreateGoalsForm(@ModelAttribute @Valid Goal newGoal, Errors errors){
        if (errors.hasErrors()) return "goals/create";
        goalRepository.save(newGoal);
        return "redirect:";
    }

}
