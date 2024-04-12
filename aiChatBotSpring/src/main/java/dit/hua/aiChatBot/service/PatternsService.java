package dit.hua.aiChatBot.service;


import dit.hua.aiChatBot.entity.Patterns;
import dit.hua.aiChatBot.repository.PatternsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatternsService {

    @Autowired
    private PatternsRepository patternsRepository;


    @Transactional
    public void savePatterns(Patterns patterns){
        patternsRepository.save(patterns);
    }

    @Transactional
    public Iterable<Patterns> findPatternsOfIntent(Integer intentId){
        List<Patterns> patterns = patternsRepository.findAll();
        List<Patterns> patternsOfIntent = new ArrayList<>();
        for (Patterns pattern : patterns){
            if (pattern.getIntents().getId().equals(intentId)){
                patternsOfIntent.add(pattern);
            }
        }
        return patternsOfIntent;
    }

}
