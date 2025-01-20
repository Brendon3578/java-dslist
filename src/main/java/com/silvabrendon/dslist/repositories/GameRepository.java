package com.silvabrendon.dslist.repositories;

import com.silvabrendon.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
