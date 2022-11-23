package pl.nataliazubrzycka.itSpa.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import pl.nataliazubrzycka.itSpa.user.dao.User


@Repository
interface UserRepository : JpaRepository<User, Long>{

    @Query("FROM User WHERE email = :firstName and password = :lastName")
    fun getByEmailAndPassword(@Param("firstName") firstName: String, @Param("lastName") lastName: String): User

}