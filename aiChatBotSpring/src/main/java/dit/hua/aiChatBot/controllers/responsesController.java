package dit.hua.aiChatBot.controllers;

import dit.hua.aiChatBot.entity.Patterns;
import dit.hua.aiChatBot.entity.Responses;
import dit.hua.aiChatBot.service.IntentsService;
import dit.hua.aiChatBot.service.ResponsesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/responses")
public class responsesController {
    @Autowired
    private ResponsesService responsesService;

    @Autowired
    private IntentsService intentsService;


    @GetMapping("/list/{id}")
    private String listResponses(Model model, @PathVariable Integer id){
        Iterable<Responses> responses = responsesService.findResponsesOfIntent(id);
        model.addAttribute("responses", responses);
        model.addAttribute("intentId", id);
        return "responses";
    }

    @GetMapping("/new/{id}")
    private String addPattern(Model model, @PathVariable Integer id){
        Responses responses = new Responses();
        model.addAttribute("response", responses);
        model.addAttribute("intentId", id);
        return "addResponse";
    }

    @PostMapping("/new/{id}")
    private String savePattern(Responses response, @PathVariable Integer id){
        response.setIntents(intentsService.findIntentById(id));
        responsesService.saveResponses(response);
        return "redirect:/responses/list/" + id;
    }

    @GetMapping("/remove/{Resposeid}/{Intentid}")
    private String removeResponse(@PathVariable Integer Resposeid, @PathVariable Integer Intentid){
        responsesService.removeResponse(Resposeid);
        return "redirect:/responses/list/" + Intentid;
    }
}
