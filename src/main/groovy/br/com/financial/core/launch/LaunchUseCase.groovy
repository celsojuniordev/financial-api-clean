package br.com.financial.core.launch

import br.com.financial.core.exception.NotFoundException
import br.com.financial.core.exception.UnprocessableEntityException
import br.com.financial.core.user.User
import br.com.financial.dataprovider.launch.gateway.LaunchGateway
import br.com.financial.dataprovider.user.gateway.UserGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 15:51
 */

@Component
class LaunchUseCase {

    @Autowired
    LaunchGateway launchGateway

    @Autowired
    UserGateway userGateway

    Launch save(Launch launch) {
        launchValidations(launch, "create")

        launch.status = Launch.LaunchStatus.PENDENTE
        launchGateway.save(launch)
    }

    Map getBalanceByUser(Long id) {
        [value: launchGateway.getBalanceByUser(id)]
    }

    Launch update(Long id, Launch launch) {
        Launch oldLaunch = launchGateway.findById(id)
        launchValidations(oldLaunch, "update")

        launch.id = oldLaunch.id
        launch.dateCreated = oldLaunch.dateCreated
        launchGateway.save(launch)
    }

    private void launchValidations(Launch launch, action) {
        if(!launch && action == "update"){
            throw new NotFoundException("Lançamento não encontrado")
        }

        if (!launch.user.id || !userGateway.findById(launch.user.id)) {
            throw new NotFoundException("Usuário não encontrado")
        }
    }
}
