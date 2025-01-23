package com.silvabrendon.dslist.services;

import com.silvabrendon.dslist.dtos.GameDTO;
import com.silvabrendon.dslist.dtos.GameMinDTO;
import com.silvabrendon.dslist.entities.Game;
import com.silvabrendon.dslist.projections.GameMinProjection;
import com.silvabrendon.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public GameDTO findById(@PathVariable Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository
                .findAll()
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGameList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(GameMinDTO::new).toList();
    }
}
