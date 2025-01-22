package com.silvabrendon.dslist.repositories;

import com.silvabrendon.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}