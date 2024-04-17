package dit.hua.aiChatBot.rest;

import dit.hua.aiChatBot.entity.Intents;
import dit.hua.aiChatBot.entity.Patterns;
import dit.hua.aiChatBot.entity.Responses;
import dit.hua.aiChatBot.service.IntentsService;
import dit.hua.aiChatBot.service.PatternsService;
import dit.hua.aiChatBot.service.ResponsesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class chatbotRestController {

    @Autowired
    private ResponsesService responsesService;

    @Autowired
    private IntentsService intentsService;

    @Autowired
    private PatternsService patternsService;


    @PostMapping("/chat")
    public ResponseEntity<String> chatBotAnswer(@RequestBody String message){
        System.out.println("Message: " + message);
        message = message.replace("+", " ");
        System.out.println("Message: " + chatBotThinking(message));
        return ResponseEntity.ok(chatBotThinking(message));
    }


    private String chatBotThinking(String message){

        List<Intents> intents = (List<Intents>) intentsService.findAllIntents();
        String[] givenWords = message.split("[\\s,.!?%]+");
        Integer mostCommonCount = 0;
        Integer intentIndex = 0;

        //Iterate through the intents array
        for (int i = 0; i < intents.size(); i++) {
            //Get the patterns array
            List<Patterns> patternsOfIntent = (List<Patterns>) patternsService.findPatternsOfIntent(intents.get(i).getId());

            //Iterate through the patterns array
            for (int j = 0; j < patternsOfIntent.size(); j++) {
                String pattern = patternsOfIntent.get(j).getPattern();
                //Split the pattern into individual words
                String[] words = pattern.split("[\\s,.!?%]+");
                Integer count = 0;
                for (String word : words) {
                    for(String given : givenWords){
                        //Check if the given word is present in the pattern
                        if(word.toLowerCase().equals(given.toLowerCase())){
                            count++;
                        }
                    }
                }
                //if the word appeared in this intents Pattern then it should be correct
                if(count > mostCommonCount){
                    mostCommonCount = count;
                    intentIndex = i;
                }
            }
        }


        //Get the responses array
        List<Responses> responsesOfIntent = (List<Responses>) responsesService.findResponsesOfIntent(intents.get(intentIndex).getId());
        if (mostCommonCount == 0){
            //get a random response from the intent with tag Noanswer
            responsesOfIntent = (List<Responses>) responsesService.findResponsesOfIntent(252);
        }
        //Get a random response
        int randomIndex = (int) (Math.random() * responsesOfIntent.size());
        String response = responsesOfIntent.get(randomIndex).getResponse();
        return response;
    }
}
