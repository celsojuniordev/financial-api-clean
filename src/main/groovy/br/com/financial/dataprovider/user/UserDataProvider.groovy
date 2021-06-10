package br.com.financial.dataprovider.user


import br.com.financial.dataprovider.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 00:41
 */

@Service
class UserDataProvider implements br.com.financial.dataprovider.user.gateway.UserGateway {

    @Autowired
    UserRepository userRepository

    @Override
    br.com.financial.core.user.User authenticate(String email, String password) {
        br.com.financial.core.user.User user = userRepository.findByEmailAndPassword(email, password).toDomain()
        user
    }

    @Override
    br.com.financial.core.user.User save(br.com.financial.core.user.User user) {
        userRepository.save(user.toUserData()).toDomain()
    }

    @Override
    Optional<br.com.financial.core.user.User> findById(Long id) {
        userRepository.findById(id) as Optional<br.com.financial.core.user.User>
    }
}
