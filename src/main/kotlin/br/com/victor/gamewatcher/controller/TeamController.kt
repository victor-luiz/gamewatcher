package br.com.victor.gamewatcher.controller

import br.com.victor.gamewatcher.dto.CreateTeamDto
import br.com.victor.gamewatcher.dto.TeamResponseDto
import br.com.victor.gamewatcher.service.TeamService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/teams")
@Tag(name = "Times", description = "Endpoints para gerenciamento dos times de futebol")
class TeamController(
    private val service: TeamService
) {

    @PostMapping
    @Operation(summary = "Cria um novo time", description = "Cadastra um time com nome e sigla no banco de dados")
    fun create(@RequestBody dto: CreateTeamDto): ResponseEntity<TeamResponseDto> {
        val response = service.create(dto)

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping
    @Operation(summary = "Listar todos os times", description = "Retorna uma lista contendo todos os times cadastrados.")
    fun getAll(): ResponseEntity<List<TeamResponseDto>> {
        return ResponseEntity.ok(service.getAll())
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar time por ID", description = "Retorna os detalhes de um único time baseado no ID fornecido.")
    fun getById(@PathVariable id: Long): ResponseEntity<TeamResponseDto> {
        return ResponseEntity.ok(service.getById(id))
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar time", description = "Atualiza os dados (nome e sigla) de um time existente.")
    fun update(@PathVariable id: Long, @RequestBody dto: CreateTeamDto): ResponseEntity<TeamResponseDto> {
        return ResponseEntity.ok(service.update(id, dto))
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar time", description = "Remove permanentemente um time do banco de dados.")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}