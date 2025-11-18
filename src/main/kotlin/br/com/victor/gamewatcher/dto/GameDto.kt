package br.com.victor.gamewatcher.dto

import br.com.victor.gamewatcher.entity.Game
import br.com.victor.gamewatcher.enums.EnumBroadcastChannel
import java.time.LocalDateTime

data class CreateGameDto(
    val homeTeamId: Long,
    val awayTeamId: Long,
    val gameTime: LocalDateTime,
    val broadcastChannel: EnumBroadcastChannel,
    val championship: String
)

data class GameResponseDto(
    val id: Long,
    val homeTeam: TeamResponseDto,
    val awayTeam: TeamResponseDto,
    val gameTime: LocalDateTime,
    val broadcastChannel: EnumBroadcastChannel,
    val championship: String
)

data class GameSummaryDto(
    val id: Long,
    val gameTime: LocalDateTime,
    val broadcastChannel: EnumBroadcastChannel,
    val championship: String,
    val homeTeamName: String,
    val awayTeamName: String
)

fun Game.toResponse(): GameResponseDto = GameResponseDto(
    id = this.id!!,
    homeTeam = this.homeTeam.toResponse(),
    awayTeam = this.awayTeam.toResponse(),
    gameTime = this.gameTime,
    broadcastChannel = this.broadcastChannel,
    championship = this.championship
)

fun Game.toSummaryResponse(): GameSummaryDto = GameSummaryDto(
    id = this.id!!,
    gameTime = this.gameTime,
    broadcastChannel = this.broadcastChannel,
    championship = this.championship,
    homeTeamName = this.homeTeam.name,
    awayTeamName = this.awayTeam.name
)
