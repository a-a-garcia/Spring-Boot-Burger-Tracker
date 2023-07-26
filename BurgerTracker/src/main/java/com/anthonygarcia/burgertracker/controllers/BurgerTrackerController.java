package com.anthonygarcia.burgertracker.controllers;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthonygarcia.burgertracker.models.Burger;
import com.anthonygarcia.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerTrackerController {
    private final BurgerService burgerService;
    public BurgerTrackerController(BurgerService burgerService){
        this.burgerService = burgerService;
    }
    
    @RequestMapping("/burgers")
    public String index(Model model, @ModelAttribute("burger") Burger burger) { 
    	List<Burger> allBurgers = burgerService.allBurgers();
    	model.addAttribute("allBurgers", allBurgers); //remember model takes two params -1) what it will be referred to in the jsp, 2) what it's called via Service.
    	return "index.jsp";
    }
    
    @PostMapping("/burgers/new")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		System.out.println("Validation errors:");
    		for (ObjectError error : result.getAllErrors()) {
    			System.out.println(error.getDefaultMessage());
    		}
    		List<Burger> allBurgers = burgerService.allBurgers();
    		model.addAttribute("allBurgers", allBurgers); 
    		return "index.jsp";
    	} else {
    		burgerService.createBurger(burger);
    		return "redirect:/burgers";
    		}
    	}
   }
//You can use this to print whats in bindingResult to see the validation errors:
//System.out.println("Validation errors:");
//for (ObjectError error : result.getAllErrors()) {
//	System.out.println(error.getDefaultMessage());