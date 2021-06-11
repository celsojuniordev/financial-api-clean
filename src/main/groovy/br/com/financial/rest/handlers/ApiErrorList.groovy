package br.com.financial.rest.handlers

/**
 * Created by user: Celso
 * Date: 10/06/2021
 * Time: 23:09
 */
class ApiErrorList extends ApiError {

    List erros

    ApiErrorList(Integer code, String msg, Date date, List erros){
        super(code, msg, date)
        this.erros = erros
    }
}
