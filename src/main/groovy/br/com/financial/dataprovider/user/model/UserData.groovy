package br.com.financial.dataprovider.user.model

import br.com.financial.core.user.User
import br.com.financial.dataprovider.Timestampable
import lombok.Data

import javax.persistence.*

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 00:34
 */

@Entity
@Data
@Table(name = "user")
class UserData extends Timestampable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    String email

    String password

    User toDomain() {
        new User(id: this.id, name: this.name, email: this.email, password: this.password)
    }
}
