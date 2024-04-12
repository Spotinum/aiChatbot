package dit.hua.aiChatBot.service;


import dit.hua.aiChatBot.entity.Intents;
import dit.hua.aiChatBot.repository.IntentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IntentsService {

    @Autowired
    private IntentsRepository intentsRepository;

    @Transactional
    public void saveIntents(Intents intents){
        intentsRepository.save(intents);
    }

    @Transactional
    public Iterable<Intents> findAllIntents(){
        return intentsRepository.findAll();
    }

    @Transactional
    public Intents findIntentById(Integer id){
        return intentsRepository.findById(id).get();
    }
}
