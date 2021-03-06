package br.com.financial.rest.launch.model

import br.com.financial.core.launch.Launch
import br.com.financial.core.user.User
import br.com.financial.core.util.MapUtils
import br.com.financial.dataprovider.user.model.UserData
import br.com.financial.rest.user.model.UserHttp
import lombok.Data

import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 15:41
 */

@Data
class LaunchHttp {

    Long id

    @NotBlank(message = "Descrição é obrigatório")
    String description

    @NotNull(message = "Mês é obrigatório")
    @Min(value = 1L, message = "Mês inválido")
    @Max(value = 12L, message = "Mês inválido")
    Integer month

    @NotNull(message = "Ano é obrigatório")
    @Min(value = 1990L, message = "Ano inválido")
    @Max(value = 2099L, message = "Ano inválido")
    Integer year

    @NotNull(message = "Usuário é obrigatório")
    UserHttp user

    @NotNull(message = "Valor é obrigatório")
    Long value

    @NotBlank(message = "Tipo é obrigatório")
    String type

    String status

    Date dateCreated

    Launch toDomain() {
        new Launch(id: this.id,
                description: this.description,
                month: this.month,
                year: this.year,
                user: this.user.toUser(),
                value: this.value,
                type: this.type,
                status: this.status)
    }

    Map marshall() {
        Map data = [
                id          : this.id,
                description : this.description,
                month       : this.month,
                year        : this.year,
                user        : [id: this.user.toUser().id, name: this.user.toUser().name],
                value       : this.value,
                type        : this.type,
                status      : this.status,
                dateCreated : this.dateCreated
        ]

        MapUtils.clearNullValues(data) as Map
    }
}
