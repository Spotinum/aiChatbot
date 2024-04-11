package dit.hua.aiChatBot.entity;

import jakarta.persistence.*;

@Entity
public class Intents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;


    @Column
    private String tag;


    public Intents(Integer id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public Intents() {

    }

    public Integer getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
