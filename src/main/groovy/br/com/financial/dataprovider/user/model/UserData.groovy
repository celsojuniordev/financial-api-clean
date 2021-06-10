package br.com.financial.dataprovider.user.model


import lombok.Data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 00:34
 */

@Entity
@Data
@Table(name = "user")
class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    String email

    String password

    br.com.financial.core.user.User toDomain() {
        new br.com.financial.core.user.User(id: this.id, name: this.name, email: this.email, password: this.password)
    }
}
