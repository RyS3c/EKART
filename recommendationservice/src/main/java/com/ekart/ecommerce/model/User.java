package com.ekart.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "user_name")
    private String userName;

    @OneToMany (mappedBy = "user")
    @JsonIgnore
    private List<Recom> recomendations;

    public User() {

    }

    public User(String userName, List<Recom> recomendations) {
        this.userName = userName;
        this.recomendations = recomendations;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Recom> getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(List<Recom> recomendations) {
        this.recomendations = recomendations;
    }
}
