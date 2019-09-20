package com.ef.repositories;

import com.ef.entities.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
/**
 * @author Ariel Morel
 */
@Repository
public interface  LogRepository extends JpaRepository<LogModel, Long> {
    List<LogModel> findByIp(String ip);

    /**
     * @param startDate
     * @param endDate
     * @param thresHold
     * @return list of LogModel from the parameters received
     */
    @Query(value = "SELECT new com.ef.entities.LogModel(" +
            "l.ip, " +
            "count(l.ip) as count)" +
            "FROM log l " +
            "WHERE l.logDate " +
            "BETWEEN  ?1 and ?2 " +
            "GROUP BY l.ip " +
            "HAVING count(l.ip) > ?3")
    List<LogModel> findByRequestThresHold(Date startDate, Date endDate, Long thresHold);

    /**
     * truncate the log table
     */
    @Transactional
    @Modifying
    @Query(value="TRUNCATE table log",nativeQuery = true)
     void truncateTable();
}
