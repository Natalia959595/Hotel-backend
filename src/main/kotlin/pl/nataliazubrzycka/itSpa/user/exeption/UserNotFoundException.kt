package pl.nataliazubrzycka.itSpa.user.exeption

import org.springframework.http.HttpStatus

class UserNotFoundException(val statusCode: HttpStatus, val reason: String) : Exception()