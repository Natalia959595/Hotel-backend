package pl.nataliazubrzycka.itSpa.user.dao

import javax.persistence.*

@Entity
@Table(name = "user")
data class User (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(name = "email", nullable = false, unique = true)
    var email: String,

    @Column(name = "password", nullable = false)
    var password: String

)