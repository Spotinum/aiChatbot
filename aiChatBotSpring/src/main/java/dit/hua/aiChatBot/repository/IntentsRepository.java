package dit.hua.aiChatBot.repository;

import dit.hua.aiChatBot.entity.Intents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentsRepository extends JpaRepository<Intents, Integer> {

}
