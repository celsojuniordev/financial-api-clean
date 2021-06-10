package br.com.financial.core.user

import br.com.financial.dataprovider.user.model.UserData
import lombok.Data

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 00:48
 */

@Data
class User {

    Long id

    String name

    String email

    String password

    UserData toUserData() {
        new UserData(id: this.id, name: this.name, email: this.email, password: this.password)
    }
}
