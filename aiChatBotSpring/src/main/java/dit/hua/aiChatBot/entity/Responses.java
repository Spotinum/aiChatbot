package dit.hua.aiChatBot.entity;

import jakarta.persistence.*;

@Entity
public class Responses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;


    @Column
    private String response;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="intent_id")
    private Intents intents;

    public Responses(Integer id, String response, Intents intents) {
        this.id = id;
        this.response = response;
        this.intents = intents;
    }

    public Responses() {

    }

    public Integer getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }

    public Intents getIntents() {
        return intents;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setIntents(Intents intents) {
        this.intents = intents;
    }


}
