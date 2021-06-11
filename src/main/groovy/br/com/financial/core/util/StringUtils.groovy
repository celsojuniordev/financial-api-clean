package br.com.financial.core.util

import org.apache.commons.codec.digest.DigestUtils

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 00:37
 */
class StringUtils {

    static String hashPassword(String text) {
        String hash = DigestUtils.sha256Hex(text)
        hash
    }
}
