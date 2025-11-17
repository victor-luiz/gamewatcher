package br.com.victor.gamewatcher.repository

import br.com.victor.gamewatcher.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository : JpaRepository<Team, Long> {
}