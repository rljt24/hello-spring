package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Ricky
 */
@Controller
public class HelloController {
    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

//     Handles request of the form /hello?name=LaunchCode
//    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
//    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language, Model model){
        if (name == null){
            name = "World";
        }
        String greeting = createMessage(name, language);
        model.addAttribute("greeting", greeting);
        return "Hello";
    }

    public static String createMessage(String n, String l){
        String greeting = "";
        if(l.equals("english")){
            greeting = "Hello";
        } else if (l.equals("french")){
            greeting = "Bonjour";
        } else if (l.equals("german")) {
            greeting = "Hallo";
        } else if (l.equals("spanish")) {
            greeting = "Hola";
        } else if (l.equals("japanese")) {
            greeting = "Kon'nichiwa";
        }
        return greeting + " " + n;
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("JJ");
        names.add("Mike");
        names.add("Nick");
        names.add("Ricky");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
