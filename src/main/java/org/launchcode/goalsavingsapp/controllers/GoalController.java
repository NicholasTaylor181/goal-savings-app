package org.launchcode.goalsavingsapp.controllers;


import org.launchcode.goalsavingsapp.models.Goal;
import org.launchcode.goalsavingsapp.models.data.GoalRepository;
import org.launchcode.goalsavingsapp.models.dto.GoalFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("goal")
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @GetMapping
    public String viewGoals(Model model) {
        model.addAttribute("title", "My Goals");
        model.addAttribute("goals", goalRepository.findAll());
        return "goals/index";
    }

    @GetMapping("create")
    public String displayCreateGoalsForm(Model model){
        model.addAttribute("title", "Create Goals");
        model.addAttribute(new GoalFormDTO());
        return "goals/create";
    }

    @PostMapping("create")
    public String processCreateGoalsForm(@ModelAttribute @Valid GoalFormDTO newGoalFormDTO, Errors errors){
        if (errors.hasErrors()) return "goals/create";
        Goal newGoal = new Goal(newGoalFormDTO.getTitle(), newGoalFormDTO.getCost(), newGoalFormDTO.getAmountSaved(), newGoalFormDTO.getIsPublic());
        goalRepository.save(newGoal);
        return "redirect:";
    }

    @GetMapping("view/{goalId}")
    public String viewGoals(Model model, @PathVariable int goalId) {

        Optional optGoal =goalRepository.findById(goalId);
        if( optGoal.isPresent()) {
            Goal goal = (Goal)optGoal.get();
            model.addAttribute("goal", goal);
            model.addAttribute("title", "View Goal");
            model.addAttribute(new GoalFormDTO());
            return "goals/view";
        } else {
            return "redirect:/";
        }

    }

    @PostMapping("view/{goalId}")
    public String processViewGoals(@ModelAttribute @Valid GoalFormDTO newGoalFormDTO, Errors errors, @PathVariable int goalId) {
        if (errors.hasErrors()) return "goals/view/{goalId}";
        Optional optGoal = goalRepository.findById(goalId);
        if( optGoal.isPresent()) {
            Goal goal = (Goal) optGoal.get();
            goal.setTitle(newGoalFormDTO.getTitle());
            goal.setCost(newGoalFormDTO.getCost());
            goal.setAmountSaved(newGoalFormDTO.getAmountSaved());
            goal.setPublic(newGoalFormDTO.getIsPublic());
            goal.setIsCompleted();
            goalRepository.save(goal);


        }
        return "redirect:";
    }

    @PostMapping("save/{myData}")
    public void processEditTable(@PathVariable String myData) {
        //goal.setTitle();

    }

}
