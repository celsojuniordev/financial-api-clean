package br.com.financial.dataprovider.launch.model

import br.com.financial.core.launch.Launch
import br.com.financial.dataprovider.Timestampable
import br.com.financial.dataprovider.user.model.UserData
import br.com.financial.rest.launch.model.LaunchHttp
import lombok.Data

import javax.persistence.*

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 14:58
 */

@Entity
@Data
@Table(name = "launch")
class LaunchData extends Timestampable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String description

    Integer month

    Integer year

    @ManyToOne(fetch = FetchType.EAGER)
    UserData user

    Long value

    String type

    String status

    Launch toDomain() {
        new Launch(id       : this.id,
                description : this.description,
                month       : this.month,
                year        : this.year,
                user        : this.user.toDomain(),
                value       : this.value,
                type        : this.type,
                status      : this.status,
                dateCreated : this.dateCreated
        )
    }
}
