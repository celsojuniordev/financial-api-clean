package br.com.financial.dataprovider.user.repository

import br.com.financial.dataprovider.user.model.UserData
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by user: Celso
 * Date: 09/06/2021
 * Time: 00:34
 */

interface UserRepository extends JpaRepository<UserData, Long> {

    UserData findByEmailAndPassword(String email, String password)

}