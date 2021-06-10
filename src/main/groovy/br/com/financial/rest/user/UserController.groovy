package br.com.financial.rest.user

import br.com.financial.core.user.UserUseCase
import br.com.financial.rest.user.model.UserHttp
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
 * Date: 09/06/2021
 * Time: 22:37
 */

@RestController
@RequestMapping("/v1/users")
class UserController {

    @Autowired
    UserUseCase businessUser


    @PostMapping
    ResponseEntity save(@RequestBody @Valid UserHttp userHttp) {

        try {
            ResponseEntity.status(HttpStatus.CREATED).body(businessUser.save(userHttp.toUser()).toUserHttp())
        } catch(Exception e) {
            ResponseEntity.badRequest().body(e.getMessage())
        }
    }
}
