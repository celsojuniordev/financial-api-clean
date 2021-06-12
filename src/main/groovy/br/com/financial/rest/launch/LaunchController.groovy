package br.com.financial.rest.launch

import br.com.financial.core.launch.LaunchUseCase
import br.com.financial.rest.launch.model.LaunchHttp
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @PutMapping("/{id}")
    ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid LaunchHttp launchHttp) {
        ResponseEntity.ok(launchUseCase.update(id, launchHttp.toDomain()).toHttp().marshall())
    }

    @GetMapping
    ResponseEntity find(@RequestParam(value = "description", required = false) String description,
                        @RequestParam(value = "month", required = false) Integer month,
                        @RequestParam(value = "year", required = false) Integer year,
                        @RequestParam("userId") Long userId) {
        ResponseEntity.ok(launchUseCase.findAll(description, month, year, userId).collect { it.toHttp().marshall() })
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable("id") Long id) {
        launchUseCase.delete(id)
        ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable Long id) {
        ResponseEntity.ok(launchUseCase.findById(id).toHttp().marshall())
    }
}
