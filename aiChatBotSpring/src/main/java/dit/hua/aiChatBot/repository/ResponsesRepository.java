package dit.hua.aiChatBot.repository;


import dit.hua.aiChatBot.entity.Responses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsesRepository extends JpaRepository<Responses, Integer>{
}
