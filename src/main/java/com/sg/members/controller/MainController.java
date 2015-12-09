package com.sg.members.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	
	 @RequestMapping("/")
     public String getHomePage() {
         return "home";
     }

//	 @RequestMapping("/error")
//     public String getErrorPage() {
//         return "error";
//     } 
	 
	 
}
