package com.example.footballfield.entity

import com.example.footballfield.enums.Role
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime


@Entity
@Table(name = "users")
data class User @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val createDate: LocalDateTime? = LocalDateTime.now(),
    @UpdateTimestamp
    val updateDate: LocalDateTime? = null,
    @Column(unique = true)
    val username: String? = null,
    val password: String? = null,
    @Enumerated(EnumType.STRING)
    val role: Role? = null,

){


}
