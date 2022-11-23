package pl.nataliazubrzycka.itSpa.user.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import pl.nataliazubrzycka.itSpa.user.dao.User
import pl.nataliazubrzycka.itSpa.user.exeption.UserNotFoundException
import pl.nataliazubrzycka.itSpa.user.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUsersById(userId: Long): User = userRepository.findById(userId)
        .orElseThrow { UserNotFoundException(HttpStatus.NOT_FOUND, "No matching user was found") }

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUserById(userId: Long, user: User): User {
         if (userRepository.existsById(userId)) {
            var updateClient = userRepository.getById(userId)
            return userRepository.save(
               updateClient
            )
        } else throw UserNotFoundException(HttpStatus.NOT_FOUND, "No matching client was found")
    }

    fun deleteUserById(userId: Long) {
        return if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId)
        } else throw UserNotFoundException(HttpStatus.NOT_FOUND, "No matching client was found")
    }

    fun checkCredentials(user : User): Boolean{
        try{
        userRepository.getByEmailAndPassword(user.email,user.password)
        }
        catch (e: Exception){
            return false;
        }
        return true;
    }
}