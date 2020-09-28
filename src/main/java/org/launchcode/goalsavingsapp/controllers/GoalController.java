package org.launchcode.goalsavingsapp.controllers;


import org.launchcode.goalsavingsapp.models.Goal;
import org.launchcode.goalsavingsapp.models.User;
import org.launchcode.goalsavingsapp.models.data.GoalRepository;
import org.launchcode.goalsavingsapp.models.dto.GoalFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("goal")
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping
    public String viewMyGoals(HttpServletRequest request, Model model) {

        List<Goal> goalList = new ArrayList<>();
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        for (Goal goal : goalRepository.findAll()) {
            if (goal.getUser() == user) {
                goalList.add(goal);
            }
        }
        model.addAttribute("title", "My Goals");
        model.addAttribute("goals", goalList);
        return "goals/index";
    }

    @GetMapping("create")
    public String displayCreateGoalsForm(Model model){

        model.addAttribute("title", "Create Goals");
        model.addAttribute(new GoalFormDTO());
        model.addAttribute("localDate", LocalDate.now());
        return "goals/create";
    }

    @PostMapping("create")
    public String processCreateGoalsForm(@ModelAttribute @Valid GoalFormDTO newGoalFormDTO, HttpServletRequest request, Errors errors){
        if (errors.hasErrors()) return "goals/create";

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        Goal newGoal = new Goal(newGoalFormDTO.getTitle(), newGoalFormDTO.getCost(), newGoalFormDTO.getAmountSaved(), newGoalFormDTO.getIsPublic(), user, newGoalFormDTO.getGoalDate());
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

//    @PostMapping("view/{goalId}")
//    public String processViewGoals(@ModelAttribute @Valid GoalFormDTO newGoalFormDTO, Errors errors, @PathVariable int goalId) {
//        if (errors.hasErrors()) return "goals/view/{goalId}";
//        Optional optGoal = goalRepository.findById(goalId);
//        if( optGoal.isPresent()) {
//            Goal goal = (Goal) optGoal.get();
//            goal.setTitle(newGoalFormDTO.getTitle());
//            goal.setCost(newGoalFormDTO.getCost());
//            goal.setAmountSaved(newGoalFormDTO.getAmountSaved());
//            goal.setPublic(newGoalFormDTO.getIsPublic());
//            goal.setIsCompleted();
//            goalRepository.save(goal);
//
//
//        }
//        return "redirect:";
//    }


    @RequestMapping(value="/saveGoal.html",method=RequestMethod.POST)

    public  @ResponseBody String  getSearchUserProfiles(@RequestBody Goal goal, HttpServletRequest request) {

        Optional optGoal = goalRepository.findById(goal.getId());
        if( optGoal.isPresent()) {
            Goal updatedGoal = (Goal) optGoal.get();
            updatedGoal.setTitle(goal.getTitle());
            updatedGoal.setCost(goal.getCost());
            updatedGoal.setAmountSaved(goal.getAmountSaved());
            updatedGoal.setPublic(goal.getIsPublic());
            updatedGoal.setIsCompleted();
            goalRepository.save(updatedGoal);
        }




        return "redirect:";
    }

    @GetMapping("public")
    public String viewPublicGoals(HttpServletRequest request, Model model) {

        List<Goal> goalList = new ArrayList<>();
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        for (Goal goal : goalRepository.findAll()) {
            if (goal.getIsPublic()) {
                goalList.add(goal);
            }
        }
        model.addAttribute("user", user);
        model.addAttribute("title", "Public Goals");
        model.addAttribute("goals", goalList);
        return "goals/public";
    }

}
