package kabak.controller;

import kabak.entity.Users;
import kabak.service.ServiceUsersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    private ServiceUsersImpl serviceUsersImpl;

    @Autowired
    public MainController(ServiceUsersImpl serviceUsersImpl){ this.serviceUsersImpl = serviceUsersImpl ;}

    @GetMapping("/index")
    public String gohome(){
        return "start";
    }

    @GetMapping("/create")
    public String gocreate(){
        return "create";
    }


    @GetMapping("/showall")
    public ModelAndView goshowall(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Users> usersList = serviceUsersImpl.showAll();
            modelAndView.addObject("UsersList", usersList);
            modelAndView.setViewName("showall");
            return modelAndView;
        } catch (Exception error) {
            modelAndView.addObject("error", error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
    }

    @PostMapping("/show")
    public ModelAndView show(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        try{
            Users user = serviceUsersImpl.show(name);
            if(user == null){
                String error = " пользователь не найден";
                modelAndView.addObject("error", error);
                modelAndView.setViewName("errorPage");
                return modelAndView;
            }
            modelAndView.addObject("User",user);
            modelAndView.setViewName("user");
            return modelAndView;
        }
            catch (Exception error){
                modelAndView.addObject("error", error);
                modelAndView.setViewName("errorPage");
            return modelAndView;
        }
    }

    @PostMapping("/error")
    public ModelAndView error(@RequestParam("error") String error){
        ModelAndView modelAndView = new ModelAndView();
        try{
            modelAndView.addObject("error",error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
        catch (Exception errorr){
            modelAndView.addObject("error", errorr);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
    }


    @PostMapping("/editpage")
    public ModelAndView editpage(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        try{
            Users user = serviceUsersImpl.show(name);
            if(user == null){
                String error = " пользователь не найден";
                modelAndView.addObject("error", error);
                modelAndView.setViewName("errorPage");
                return modelAndView;
            }
            modelAndView.addObject("User",user);
            modelAndView.setViewName("editpage");
            return modelAndView;
        }
        catch (Exception error){
            modelAndView.addObject("error", error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@RequestParam("iduser") Integer iduser,
                             @RequestParam("name") String name,
                             @RequestParam("address") String address,
                             @RequestParam("comments") String comments,
                             @RequestParam("firstname") String firstname,
                             @RequestParam("lastname") String lastname,
                             @RequestParam("position") String position,
                             @RequestParam("email") String[] email,
                             @RequestParam("telephonnumber") String[] telephonnumber){
        ModelAndView modelAndView = new ModelAndView();
        try{
            serviceUsersImpl.edit(iduser,name,address,comments,firstname,lastname,position,email,telephonnumber);
            modelAndView.setViewName("start");
            return modelAndView;
        }
        catch (Exception error){
            modelAndView.addObject("error", error);
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
    }

    @PostMapping("/create")
    public String create(@RequestParam("name") String name,
                         @RequestParam("address") String address,
                         @RequestParam("comments") String comments,
                         @RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname,
                         @RequestParam("position") String position,
                         @RequestParam("email") String email,
                         @RequestParam("telephonnumber") String telephonnumber){

        try {
            Users user = (Users) serviceUsersImpl.create(name, address, comments, firstname, lastname, position,email,telephonnumber );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "start";
    }
}

