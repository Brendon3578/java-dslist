package com.silvabrendon.dslist.services;

import com.silvabrendon.dslist.dtos.GameDTO;
import com.silvabrendon.dslist.dtos.GameListDTO;
import com.silvabrendon.dslist.entities.Game;
import com.silvabrendon.dslist.entities.GameList;
import com.silvabrendon.dslist.exceptions.GameListNotFoundException;
import com.silvabrendon.dslist.exceptions.GameNotFoundException;
import com.silvabrendon.dslist.exceptions.IllegalMoveException;
import com.silvabrendon.dslist.projections.GameMinProjection;
import com.silvabrendon.dslist.repositories.GameListRepository;
import com.silvabrendon.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public GameListDTO findById(@PathVariable Long listId) {
        GameList list = gameListRepository.findById(listId)
                .orElseThrow(() -> new GameListNotFoundException(listId));

        return new GameListDTO(list);
    }


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository
                .findAll()
                .stream()
                .map(GameListDTO::new)
                .toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        var list = gameListRepository.findById(listId)
                .orElseThrow(() -> new GameListNotFoundException(listId));


        var gameList = gameRepository.searchByList(list.getId());
        var listSize = gameList.size();

        if (sourceIndex < 0 || sourceIndex >= listSize || destinationIndex < 0 || destinationIndex > listSize)
            throw new IllegalMoveException();

        GameMinProjection obj = gameList.remove(sourceIndex);

        gameList.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);

        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, gameList.get(i).getId(), i);
        }
    }

}
