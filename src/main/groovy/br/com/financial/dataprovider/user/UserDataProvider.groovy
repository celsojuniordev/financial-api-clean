package br.com.financial.dataprovider.user

import br.com.financial.core.user.User
import br.com.financial.dataprovider.user.gateway.UserGateway
import br.com.financial.dataprovider.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 00:41
 */

@Service
class UserDataProvider implements UserGateway {

    @Autowired
    UserRepository userRepository

    @Override
    User authenticate(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password).toDomain()
        user
    }

    @Override
    User save(User user) {
        userRepository.save(user.toUserData()).toDomain()
    }

    @Override
    Optional<User> findById(Long id) {
        userRepository.findById(id) as Optional<User>
    }
}
