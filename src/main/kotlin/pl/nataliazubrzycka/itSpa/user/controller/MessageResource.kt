package pl.nataliazubrzycka.itSpa.user.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
@RestController
class MessageResource {
    @GetMapping
    fun index(): List<Message> = listOf(
        Message("1","hello!"),
        Message("2","hola!"),
    )
}


data class Message(val id: String?, val text: String)