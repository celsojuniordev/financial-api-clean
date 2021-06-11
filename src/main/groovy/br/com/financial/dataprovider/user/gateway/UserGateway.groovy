package br.com.financial.dataprovider.user.gateway

import br.com.financial.core.user.User

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 00:34
 */

interface UserGateway {

    User authenticate(String email, String senha)

    User save(User user)

    User findById(Long id)
}
