package br.com.victor.gamewatcher.service.impl

import br.com.victor.gamewatcher.dto.CreateGameDto
import br.com.victor.gamewatcher.dto.GameResponseDto
import br.com.victor.gamewatcher.dto.toResponse
import br.com.victor.gamewatcher.entity.Game
import br.com.victor.gamewatcher.repository.GameRepository
import br.com.victor.gamewatcher.service.GameService
import br.com.victor.gamewatcher.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class GameServiceImpl(
    private val gameRepository: GameRepository,
    private val teamService: TeamService
) : GameService {
    override fun create(dto: CreateGameDto): GameResponseDto {
        val homeTeam = teamService.getEntityById(dto.homeTeamId)
        val awayTeam = teamService.getEntityById(dto.awayTeamId)

        val game = Game(
            gameTime = dto.gameTime,
            broadcastChannel = dto.broadcastChannel,
            championship = dto.championship,
            homeTeam = homeTeam,
            awayTeam = awayTeam
        )

        return gameRepository.save(game).toResponse()
    }

    override fun getAll(): List<GameResponseDto> {
        return gameRepository.findAll().map { it.toResponse() }
    }

    override fun getById(id: Long): GameResponseDto {
        val game = gameRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Time não existe") }
        return game.toResponse()    }

    override fun update(
        id: Long,
        dto: CreateGameDto
    ): GameResponseDto {
        val existingGame = gameRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo para edição não encontrado") }

        val homeTeam = if (existingGame.homeTeam.id == dto.homeTeamId) existingGame.homeTeam
        else teamService.getEntityById(dto.homeTeamId)

        val awayTeam = if (existingGame.awayTeam.id == dto.awayTeamId) existingGame.awayTeam
        else teamService.getEntityById(dto.awayTeamId)

        existingGame.apply {
            this.gameTime = dto.gameTime
            this.broadcastChannel = dto.broadcastChannel
            this.championship = dto.championship
            this.homeTeam = homeTeam
            this.awayTeam = awayTeam
        }

        return gameRepository.save(existingGame).toResponse()    }

    override fun delete(id: Long) {
        if (!gameRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo para exclusão não encontrado")
        }
        gameRepository.deleteById(id)
    }
}