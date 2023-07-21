package dev.gracialab.glab.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.gracialab.glab.model.Reserve;
import dev.gracialab.glab.model.User;
import dev.gracialab.glab.service.api.ReserveServiceAPI;
import dev.gracialab.glab.service.api.UserServiceAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ReserveController {

    @Autowired
    private ReserveServiceAPI reserveServiceAPI;

    @Autowired
    private UserServiceAPI userServiceAPI;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:/rest";
    }

    @RequestMapping("/rest")
    public String indexRest(Model model) {
        return "indexRest";
    }

    @RequestMapping("/rest/admin")
    public String RestList(Model model) {
        model.addAttribute("reserveList", reserveServiceAPI.getAll());        
        return "innerPageReserveList";
    }

    @GetMapping("/reserveIndex/{id}/{user_id}")
    public String formReserveT(@PathVariable("id") Long id, @PathVariable("user_id") Long user_id, Model model) {
        if (id != null && id != 0){
            model.addAttribute("reserve", reserveServiceAPI.get(id));
            if(user_id != 0){
                model.addAttribute("user", userServiceAPI.get(user_id));
            }
        }else{
            model.addAttribute("reserve", new Reserve());
            model.addAttribute("user", new User());

        }
        return "innerPage";
    }

    @PostMapping("/reserveIndex/saveReserve")
    public String saveReserve(@ModelAttribute("user_id.mail") String mail, Reserve reserve, User user, Model model) {
        List<User> users = userServiceAPI.search(mail);

        if(reserve.getId() != null ){
            reserveServiceAPI.save(reserve);
            return "redirect:/rest/admin";
        }else{
            if(users.isEmpty()){
                reserveServiceAPI.save(reserve);
            }else{
                Reserve reserva = new Reserve(reserve.getDate(), reserve.getHour(), false, reserve.getReserve_type(), reserve.getNumber_of_people(), reserve.getNote());
                reserva.setUser_id(userServiceAPI.get(users.get(0).getId()));
                reserveServiceAPI.save(reserva);
                
            }
        }

        return "redirect:/rest";
    }

    @GetMapping("/reserve-confirm/{id}")
    public String confirm(@PathVariable Long id, Model model){
        reserveServiceAPI.confirm(id);
        return "redirect:/rest/admin";
    }
    

}
