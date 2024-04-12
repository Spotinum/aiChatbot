package dit.hua.aiChatBot.repository;

import dit.hua.aiChatBot.entity.Patterns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatternsRepository extends JpaRepository<Patterns, Integer> {

}
