package br.com.financial.core.launch

import br.com.financial.core.user.User
import br.com.financial.dataprovider.launch.model.LaunchData
import br.com.financial.rest.launch.model.LaunchHttp
import lombok.Data

import javax.persistence.EnumType
import javax.persistence.Enumerated

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 15:16
 */

@Data
class Launch {

    Long id

    String description

    Integer month

    Integer year

    User user

    Long value

    Date dateCreated

    @Enumerated(EnumType.STRING)
    LaunchType type

    @Enumerated(EnumType.STRING)
    LaunchStatus status

    enum LaunchStatus {
        PENDENTE,
        CANCELADO,
        EFETIVADO
    }

    enum LaunchType {
        RECEITA,
        DESPESA
    }

    LaunchData toData() {
        new LaunchData(id       : this.id,
                description : this.description,
                month       : this.month,
                year        : this.year,
                user        : this.user.toUserData(),
                value       : this.value,
                type        : this.type,
                status      : this.status,
                dateCreated: this.dateCreated
        )
    }

    LaunchHttp toHttp() {
        new LaunchHttp(id       : this.id,
                description : this.description,
                month       : this.month,
                year        : this.year,
                user        : this.user.toUserHttp(),
                value       : this.value,
                type        : this.type,
                status      : this.status,
                dateCreated : this.dateCreated
        )
    }
}
