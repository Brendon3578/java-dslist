package com.silvabrendon.dslist.dtos;

import com.silvabrendon.dslist.entities.Game;
import org.springframework.beans.BeanUtils;

public record GameDTO(
        Long id,
        String title,
        Integer year,
        String genre,
        String platforms,
        Double score,
        String imgUrl,
        String shortDescription,
        String longDescription
) {
    public GameDTO(Game game) {
        this(
                game.getId(),
                game.getTitle(),
                game.getYear(),
                game.getGenre(),
                game.getPlatforms(),
                game.getScore(),
                game.getImgUrl(),
                game.getShortDescription(),
                game.getLongDescription()
        );
    }

    public GameMinDTO toGameMinDto() {
        return new GameMinDTO(id, title, year, imgUrl, shortDescription);
    }
}
