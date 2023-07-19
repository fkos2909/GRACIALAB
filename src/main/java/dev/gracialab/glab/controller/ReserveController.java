package dev.gracialab.glab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.gracialab.glab.model.Reserve;
import dev.gracialab.glab.model.User;
import dev.gracialab.glab.service.api.ReserveServiceAPI;
import dev.gracialab.glab.service.api.UserServiceAPI;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ReserveController {

    @Autowired
    private ReserveServiceAPI reserveServiceAPI;

    @Autowired
    private UserServiceAPI userServiceAPI;


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("reserveList", reserveServiceAPI.getAll());              
        model.addAttribute("userList", userServiceAPI.getAll());          
        return "index";
    }

    @GetMapping("/reserve/{id}/{user_id}")
    @DateTimeFormat(pattern = "hh:mm:ss")
    public String formReserve(@PathVariable("id") Long id, @PathVariable("user_id") Long user_id, Model model) {
        if (id != null && id != 0){
            model.addAttribute("reserve", reserveServiceAPI.get(id));
            if(user_id != 0){
                model.addAttribute("user", userServiceAPI.get(user_id));
            }
        }else{
            model.addAttribute("reserve", new Reserve());
            model.addAttribute("user", new User());

        }
        return "saveReserve";
    }

    @PostMapping("/saveReserve")
    public String saveReserve(Reserve reserve, User user, Model model) {
        reserveServiceAPI.save(reserve); 
        // if(user.getMail() == "fatima.ospina@gmail.com"){
        //     Reserve re = new Reserve(reserve.getId(), reserve.getDate(), reserve.getHour(), reserve.getState(), reserve.getReserve_type(), reserve.getNumber_of_people(), reserve.getNote());
        //     // re.setUser_id(user);
        //     reserveServiceAPI.save(re).setUser_id(userServiceAPI.get(null));
        // }else{
        //     Reserve re = new Reserve(reserve.getId(), reserve.getDate(), reserve.getHour(), reserve.getState(), reserve.getReserve_type(), reserve.getNumber_of_people(), reserve.getNote(), user);
        //     reserveServiceAPI.save(re);
        //     userServiceAPI.save(user);
        // }
        
        // userServiceAPI.save(user);

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
