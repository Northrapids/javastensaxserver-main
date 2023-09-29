package se.systementor.stengameserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.systementor.stengameserver.DTO.GameResult;
import se.systementor.stengameserver.services.StatisticsService;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

// ex http://localhost:5000/api/play?yourSelection=STONE
//SCISSOR
// BAG
@RestController
@CrossOrigin
public class GameController {


    @Autowired
    StatisticsService statisticsService;

    private static Random rand = new Random();
    @GetMapping("/api/play")
    public GameResult play(@RequestParam String yourSelection){
        String winner = "Tie";
        String mySelection = randomizeSelection();
        if(yourSelection.equals("STONE") && mySelection.equals("SCISSOR"))winner = "You";
        if(yourSelection.equals("SCISSOR") && mySelection.equals("BAG")) winner = "You";
        if(yourSelection.equals("BAG") && mySelection.equals("STONE"))winner = "You";
        if(mySelection.equals("STONE") && yourSelection.equals("SCISSOR"))winner = "Computer";
        if(mySelection.equals("SCISSOR") && yourSelection.equals("BAG"))winner = "Computer";
        if(mySelection.equals("BAG") && yourSelection.equals("STONE"))winner = "Computer";

        var gameResult = new GameResult();
        gameResult.setWinner(winner);
        gameResult.setYourSelection(yourSelection);
        gameResult.setComputerSelection(mySelection);
        gameResult.setCoolnessFactor(99);

        statisticsService.save(winner,yourSelection,mySelection);

        return gameResult;
    }

    private String randomizeSelection() {
        var index = rand.nextInt(3);
        if(index == 0) return "STONE";
        if(index == 1) return "SCISSOR";
        return "BAG";
    }



    @GetMapping("/api/stats")
    public ResponseEntity<Map<String, Integer>> getStatistics() {
        Map<String, Integer> statistics = statisticsService.getStatistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
