package com.silvabrendon.dslist.dtos;

import com.silvabrendon.dslist.entities.GameList;
import com.silvabrendon.dslist.projections.GameMinProjection;

public record GameListDTO(Long id, String name) {

    public GameListDTO(GameList gameList) {
        this(
            gameList.getId(),
            gameList.getName()
        );
    }
}
