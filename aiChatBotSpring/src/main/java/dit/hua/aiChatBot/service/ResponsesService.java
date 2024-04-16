package dit.hua.aiChatBot.service;


import dit.hua.aiChatBot.entity.Patterns;
import dit.hua.aiChatBot.entity.Responses;
import dit.hua.aiChatBot.repository.ResponsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponsesService {

    @Autowired
    private ResponsesRepository responsesRepository;

    @Transactional
    public void saveResponses(Responses responses){
        responsesRepository.save(responses);
    }

    @Transactional
    public void removeResponse(Integer responseId){
        responsesRepository.deleteById(responseId);
    }

    @Transactional
    public Iterable<Responses> findResponsesOfIntent(Integer intentId){
        List<Responses> responses = responsesRepository.findAll();
        List<Responses> responsesOfIntent = new ArrayList<>();
        for (Responses response : responses){
            if (response.getIntents().getId().equals(intentId)){
                responsesOfIntent.add(response);
            }
        }
        return responsesOfIntent;
    }
}
