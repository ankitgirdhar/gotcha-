package com.gotcha.game.repositories;

import com.gotcha.game.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    Optional<Player> findByEmail(String name);
}
