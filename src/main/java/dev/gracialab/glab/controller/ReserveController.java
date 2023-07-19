package dev.gracialab.glab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.gracialab.glab.model.Reserve;
import dev.gracialab.glab.service.api.ReserveServiceAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ReserveController {

    @Autowired
    private ReserveServiceAPI reserveServiceAPI;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("reserveList", reserveServiceAPI.getAll());
        return "index";
    }

    @GetMapping("/reserve/{id}")
    @DateTimeFormat(pattern = "hh:mm:ss")
    public String formReserve(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0){
            model.addAttribute("reserve", reserveServiceAPI.get(id));
            // model.addAttribute("user", userServiceAPI.get(id));
        }else{
            model.addAttribute("reserve", new Reserve());
        }
        return "saveReserve";
    }

    @PostMapping("/saveReserve")
    public String saveReserve(Reserve reserve, Model model) {
        reserveServiceAPI.save(reserve);
        return "redirect:/";
    }

    @GetMapping("/reserve-delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        reserveServiceAPI.delete(id);
        return "redirect:/";
    }

    // @RequestMapping("/api/message")
    // @GetMapping("/hello")
    // public String hello() {
    //     return "Hello, World!";
    // }
    
}
