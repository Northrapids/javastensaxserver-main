package se.systementor.stengameserver.repositoies;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.systementor.stengameserver.models.Game;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository <Game, Integer> {

    @Override
    List<Game> findAll();
}
