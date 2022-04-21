package com.some.playground.dao;

import com.some.playground.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    Player getPlayerById(String id);
}
