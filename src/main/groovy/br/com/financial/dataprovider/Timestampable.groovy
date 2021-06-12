package br.com.financial.dataprovider

import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 15:24
 */
@MappedSuperclass
abstract class Timestampable {

    Date dateCreated

    @PrePersist
    protected void prePersist() {
        dateCreated = new Date()
    }
}