package br.com.financial.dataprovider.launch

import br.com.financial.core.launch.Launch
import br.com.financial.core.user.User
import br.com.financial.dataprovider.launch.gateway.LaunchGateway
import br.com.financial.dataprovider.launch.model.LaunchData
import br.com.financial.dataprovider.launch.repository.LaunchRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 14:58
 */

@Service
class LaunchDataProvider implements LaunchGateway {

    @Autowired
    LaunchRepository launchRepository

    @Override
    Launch save(Launch launch) {
        launchRepository.save(launch.toData()).toDomain()
    }

    @Override
    void delete(Launch launch) {

    }

    @Override
    List<Launch> findAll(Launch launchFilter) {
        return null
    }

    @Override
    void updateStatus(Launch launch, String launchStatus) {

    }

    @Override
    void validate(Launch launch) {

    }

    @Override
    Launch findById(Long id) {
        Launch launch = null
        launchRepository.findById(id).ifPresent(launchData -> launch = launchData.toDomain())
        launch
    }

    @Override
    Long getBalanceByUser(Long id) {
        Long incoming = launchRepository.sumValuesUserByType(id, "RECEITA") ?: 0
        Long expense = launchRepository.sumValuesUserByType(id, "DESPESA") ?: 0

        incoming - expense
    }
}
