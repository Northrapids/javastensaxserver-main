package se.systementor.stengameserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getYourSelection() {
        return yourSelection;
    }

    public void setYourSelection(String yourSelection) {
        this.yourSelection = yourSelection;
    }

    public String getMySelection() {
        return mySelection;
    }

    public void setMySelection(String mySelection) {
        this.mySelection = mySelection;
    }

    LocalDateTime created;
    String winner;
    String yourSelection;
    String mySelection;
}
