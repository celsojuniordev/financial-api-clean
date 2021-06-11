package br.com.financial.core.util

import groovy.transform.CompileStatic

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 14:50
 */

@CompileStatic
class MapUtils {

    static clearNullValues(obj) {
        if (obj instanceof Map)
            obj
                    .collectEntries { k, v -> [(k): clearNullValues(v)] }
                    .findAll { k, v -> v || v == false || v == 0 }

        else if (obj instanceof Collection)
            obj.collect { clearNullValues(it) }

        else
            obj
    }
}
