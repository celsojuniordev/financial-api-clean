package br.com.financial.rest.handlers

/**
 * Created by user: Celso
 * Date: 10/06/2021
 * Time: 23:09
 */
class ApiError  implements Serializable{

    Integer code
    String msg
    Date date

    ApiError(Integer code, String msg, Date date) {
        this.code = code
        this.msg = msg
        this.date = date
    }
}
