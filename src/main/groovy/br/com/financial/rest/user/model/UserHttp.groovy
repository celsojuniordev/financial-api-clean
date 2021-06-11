package br.com.financial.rest.user.model

import br.com.financial.core.user.User
import br.com.financial.core.util.MapUtils
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.Data
import lombok.Getter
import lombok.Setter

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 22:36
 */

@Data
class UserHttp {

    Long id

    @NotBlank(message = "Nome é obrigatório")
    String name

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email

    @NotNull(message = "Senha é obrigatório")
    @Size(min = 6, message = "Senha deve conter no minimo 6 caracteres")
    String password

    User toUser() {
        new User(id: this.id, name: this.name, email: this.email, password: this.password)
    }

    Map marshall() {
        Map data = [
                id: this.id,
                name: this.name,
                email: this.email
        ]

        MapUtils.clearNullValues(data) as Map
    }
}
