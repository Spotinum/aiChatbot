package dit.hua.aiChatBot.controllers;

import dit.hua.aiChatBot.entity.Intents;
import dit.hua.aiChatBot.service.IntentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tag")
public class tagController {

    @Autowired
    private IntentsService intentsService;

    @GetMapping("/new")
    public String tag(Model model){
        Intents intents = new Intents();
        model.addAttribute("intents",intents);
        return "addTag";
    }

    @PostMapping("/new")
    public String saveTag(Intents intents, Model model){
        //save tag
        intentsService.saveIntents(intents);
        return "redirect:/";
    }

}
