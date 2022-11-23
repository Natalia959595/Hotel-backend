package pl.nataliazubrzycka.itSpa.user.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pl.nataliazubrzycka.itSpa.user.dao.User
import pl.nataliazubrzycka.itSpa.user.service.UserService

@RestController
@CrossOrigin()
class UserController(private val userService: UserService) {

    @PostMapping("/user/register")
    fun createUser(@RequestBody payload: User): User = userService.createUser(payload)

    @PostMapping("/user/login")
    fun loginUser(@RequestBody payload: User): ResponseEntity<User> {
        if(!userService.checkCredentials(payload)) {
            payload.email = ""
            payload.password = ""
            return ResponseEntity.status(400).body(payload);
        }
        return ResponseEntity.status(200).body(payload);
    }

    @DeleteMapping("/client/{id}")
    fun deleteUserById(@PathVariable("id") userId: Long): Unit =
        userService.deleteUserById(userId)
}