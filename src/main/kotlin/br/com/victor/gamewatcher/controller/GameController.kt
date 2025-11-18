package br.com.victor.gamewatcher.controller

import br.com.victor.gamewatcher.dto.CreateGameDto
import br.com.victor.gamewatcher.dto.GameResponseDto
import br.com.victor.gamewatcher.service.GameService
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
@RequestMapping("/games")
@Tag(name = "Jogos", description = "Gerenciamento de partidas e transmissões")
class GameController(
    private val service: GameService
) {
    @PostMapping
    @Operation(summary = "Cadastrar Jogo", description = "Cria uma nova partida vinculando dois times existentes.")
    fun create(@RequestBody dto: CreateGameDto): ResponseEntity<GameResponseDto> {
        val response = service.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping
    @Operation(summary = "Listar Jogos", description = "Retorna todas as partidas cadastradas com detalhes dos times e canal.")
    fun getAll(): ResponseEntity<List<GameResponseDto>> {
        return ResponseEntity.ok(service.getAll())
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Jogo", description = "Retorna detalhes de uma partida específica pelo ID.")
    fun getById(@PathVariable id: Long): ResponseEntity<GameResponseDto> {
        return ResponseEntity.ok(service.getById(id))
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Jogo", description = "Atualiza horários, canais ou times de uma partida.")
    fun update(@PathVariable id: Long, @RequestBody dto: CreateGameDto): ResponseEntity<GameResponseDto> {
        return ResponseEntity.ok(service.update(id, dto))
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Jogo", description = "Exclui uma partida do sistema.")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}