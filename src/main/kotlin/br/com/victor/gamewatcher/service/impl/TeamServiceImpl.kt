package br.com.victor.gamewatcher.service.impl

import br.com.victor.gamewatcher.dto.CreateTeamDto
import br.com.victor.gamewatcher.dto.TeamResponseDto
import br.com.victor.gamewatcher.dto.toResponse
import br.com.victor.gamewatcher.entity.Team
import br.com.victor.gamewatcher.repository.TeamRepository
import br.com.victor.gamewatcher.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TeamServiceImpl(
    private val repository: TeamRepository
) : TeamService {
    override fun create(dto: CreateTeamDto): TeamResponseDto {
        val entity = Team(
            name = dto.name,
            acronym = dto.acronym
        )
        return repository.save(entity).toResponse()
    }

    override fun getAll(): List<TeamResponseDto> {
        return repository.findAll().map { it.toResponse() }
    }

    override fun getById(id: Long): TeamResponseDto {
        val team = repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Tme não existe") }
        return team.toResponse()
    }

    override fun update(
        id: Long,
        dto: CreateTeamDto
    ): TeamResponseDto {
        val existingTeam = repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Time para edição não encontrado") }

        existingTeam.name = dto.name
        existingTeam.acronym = dto.acronym

        return repository.save(existingTeam).toResponse()
    }

    override fun delete(id: Long) {
        if (!repository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Time para exlcusão não encontrado")
        }
        repository.deleteById(id)    }
}