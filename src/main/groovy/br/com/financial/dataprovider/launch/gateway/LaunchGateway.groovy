package br.com.financial.dataprovider.launch.gateway

import br.com.financial.core.launch.Launch
import br.com.financial.dataprovider.launch.model.LaunchData

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 15:13
 */
interface LaunchGateway {

    Launch save(Launch launch)

    void delete(Launch launch)

    List<Launch> findAll(Launch launchFilter)

    void updateStatus(Launch launch, String launchStatus)

    void validate(Launch launch)

    Launch findById(Long id)

    Long getBalanceByUser(Long id)

}