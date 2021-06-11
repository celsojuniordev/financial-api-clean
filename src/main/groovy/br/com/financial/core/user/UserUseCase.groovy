package br.com.financial.core.user

import br.com.financial.core.exception.NotFoundException
import br.com.financial.core.util.StringUtils
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
        userGateway.authenticate(email, StringUtils.hashPassword(password))
    }

    User save(User user) {
        user.password = StringUtils.hashPassword(user.password)
        userGateway.save(user)
    }

    User findById(Long id) {
        User user  = userGateway.findById(id)
        if(!user){
            throw new NotFoundException("Usuário não encontrado")
        }
        user
    }
}
