package br.com.financial.dataprovider.launch.repository

import br.com.financial.dataprovider.launch.model.LaunchData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Created by user: Celso
 * Date: 11/06/2021
 * Time: 15:12
 */

interface LaunchRepository extends JpaRepository<LaunchData, Long> {

    @Query(value = """SELECT SUM(l.value) 
                    FROM LaunchData l JOIN l.user u 
                    WHERE u.id = :userId
                    AND l.type = :type 
                    GROUP BY u""")
    Long getBalanceByUser(@Param("userId") Long userId, @Param("type") String type)
}