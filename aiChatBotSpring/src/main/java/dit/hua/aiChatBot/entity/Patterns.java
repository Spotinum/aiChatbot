package dit.hua.aiChatBot.entity;

import jakarta.persistence.*;

@Entity
public class Patterns {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;


    @Column
    private String pattern;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="intent_id")
    private Intents intents;

    public Patterns(Integer id, String pattern, Intents intents) {
        this.id = id;
        this.pattern = pattern;
        this.intents = intents;
    }

    public Patterns() {

    }

    public Integer getId() {
        return id;
    }

    public String getPattern() {
        return pattern;
    }

    public Intents getIntents() {
        return intents;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setIntents(Intents intents) {
        this.intents = intents;
    }


}
