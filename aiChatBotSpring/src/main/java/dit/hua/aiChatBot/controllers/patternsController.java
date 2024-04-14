package dit.hua.aiChatBot.controllers;


import dit.hua.aiChatBot.entity.Patterns;
import dit.hua.aiChatBot.service.IntentsService;
import dit.hua.aiChatBot.service.PatternsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patterns")
public class patternsController {

    @Autowired
    private PatternsService patternsService;

    @Autowired
    private IntentsService intentsService;


    @GetMapping("/list/{id}")
    private String listPatterns(Model model, @PathVariable Integer id){
        Iterable<Patterns> patterns = patternsService.findPatternsOfIntent(id);
        model.addAttribute("patterns", patterns);
        model.addAttribute("intentId", id);
        return "patterns";
    }

    @GetMapping("/new/{id}")
    private String addPattern(Model model, @PathVariable Integer id){
        Patterns pattern = new Patterns();
        model.addAttribute("pattern", pattern);
        model.addAttribute("intentId", id);
        return "addPattern";
    }

    @PostMapping("/new/{id}")
    private String savePattern(Patterns pattern, @PathVariable Integer id){
        pattern.setIntents(intentsService.findIntentById(id));
        patternsService.savePatterns(pattern);
        return "redirect:/patterns/list/" + id;
    }


    @GetMapping("/remove/{Patternid}/{Intentid}")
    private String removePattern(@PathVariable Integer Patternid, @PathVariable Integer Intentid){
        patternsService.removePattern(Patternid);
        return "redirect:/patterns/list/" + Intentid;
    }
}

