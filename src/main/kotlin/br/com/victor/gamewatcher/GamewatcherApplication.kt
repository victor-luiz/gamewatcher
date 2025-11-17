package br.com.victor.gamewatcher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GamewatcherApplication

fun main(args: Array<String>) {
	runApplication<GamewatcherApplication>(*args)
}
