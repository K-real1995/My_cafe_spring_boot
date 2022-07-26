package com.kirillsoklakov.spring.boot.application.controller;

import com.kirillsoklakov.spring.boot.application.model.Visitor;
import com.kirillsoklakov.spring.boot.application.service.CafeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CafeController {

    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }


    @GetMapping("/coffee")
    public String getCoffeePage(){
        return "coffee";
    }

    @GetMapping("/tea")
    public String getTeaPage(){
        return "tea";
    }

    @GetMapping("/about-us")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new Visitor());
        return "aboutus";
    }

    @PostMapping("/about-us")
    public String register(@ModelAttribute Visitor visitor){
        System.out.println("Добавление отзыва " + visitor);
        Visitor newVisitor = cafeService.createFeedback(
                visitor.getName(),
                visitor.getEmail(),
                visitor.getRate(),
                visitor.getFeedback());
        return newVisitor == null ? "Error" : "redirect:/";
    }
}
