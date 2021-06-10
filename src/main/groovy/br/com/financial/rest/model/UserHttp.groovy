package br.com.financial.rest.model


import lombok.Data

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 22:36
 */

@Data
class UserHttp {

    Long id

    String name

    String email

    String password

    br.com.financial.core.user.User toUser() {
        new br.com.financial.core.user.User(id: this.id, name: this.name, email: this.email, password: this.password)
    }
}
