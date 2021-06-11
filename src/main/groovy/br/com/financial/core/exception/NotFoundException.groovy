package br.com.financial.core.exception

/**
 * Created by user: Celso
 * Date: 10/06/2021
 * Time: 23:14
 */
class NotFoundException extends RuntimeException{

    NotFoundException(String msg){
        super(msg)
    }
}
