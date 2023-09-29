package se.systementor.stengameserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.systementor.stengameserver.models.Game;
import se.systementor.stengameserver.repositoies.GameRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {

    @Autowired
    GameRepository gameRepository;
    private static ArrayList<Game> games = new ArrayList<Game>();

    public void save(String winner, String yourSelection, String mySelection) {
        var game = new Game();
        game.setCreated(LocalDateTime.now());
        game.setMySelection(mySelection);
        game.setYourSelection(yourSelection);
        game.setWinner(winner);
        //game.setId(games.size()+1);
        //games.add(game);
        gameRepository.save(game);
    }

    public Map<String, Integer> getStatistics() {
        Map<String, Integer> statistics = new HashMap<>();

        // Get all games
        List<Game> games = gameRepository.findAll();

        // Calculate statistics based on the list of games
        int youWins = 0;
        int computerWins = 0;
        int ties = 0;

        for (Game game : games) {
            String winner = game.getWinner();
            if ("You".equals(winner)) {
                youWins++;
            } else if ("Computer".equals(winner)) {
                computerWins++;
            } else if ("Tie".equals(winner)) {
                ties++;
            }
        }

        statistics.put("YouWins", youWins);
        statistics.put("ComputerWins", computerWins);
        statistics.put("Ties", ties);

        return statistics;
    }
}
