package br.com.victor.gamewatcher.dto

import br.com.victor.gamewatcher.entity.Team

data class CreateTeamDto(
    val name: String,
    val acronym: String,
)

data class TeamResponseDto(
    val id: Long,
    val name: String,
    val acronym: String,
    val games: List<GameSummaryDto>
)

fun Team.toResponse(): TeamResponseDto = TeamResponseDto(
    id = this.id!!,
    name = this.name,
    acronym = this.acronym,
    games = this.games.map { it.toSummaryResponse() }
)


