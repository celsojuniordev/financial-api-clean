package br.com.financial.rest.launch

import br.com.financial.core.launch.LaunchUseCase
import br.com.financial.rest.launch.model.LaunchHttp
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 15:41
 */

@RestController
@RequestMapping("/v1/launchs")
class LaunchController {

    @Autowired
    LaunchUseCase launchUseCase

    @PostMapping
    ResponseEntity save(@RequestBody @Valid LaunchHttp launchHttp) {
        ResponseEntity.status(HttpStatus.CREATED).body(launchUseCase.save(launchHttp.toDomain()).toHttp().marshall())
    }
}