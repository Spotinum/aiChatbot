package dit.hua.aiChatBot.controllers;

import dit.hua.aiChatBot.service.IntentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homeController {

    @Autowired
    private IntentsService intentsService;

    @GetMapping("")
    public String home(Model model){
        model.addAttribute("intents",intentsService.findAllIntents());
        return "home";
    }



}
