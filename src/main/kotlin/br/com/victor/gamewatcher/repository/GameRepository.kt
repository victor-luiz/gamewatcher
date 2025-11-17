package br.com.victor.gamewatcher.repository

import br.com.victor.gamewatcher.entity.Game
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<Game, Long> {
}