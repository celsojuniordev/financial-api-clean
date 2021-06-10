package br.com.financial.core.user

import br.com.financial.dataprovider.user.gateway.UserGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 00:34
 */

@Component
class UserUseCase {

    @Autowired
    UserGateway userGateway

    User authenticate(String email, String password) {
        userGateway.authenticate(email, password)
    }

    User save(User user) {
        userGateway.save(user)
    }
}
