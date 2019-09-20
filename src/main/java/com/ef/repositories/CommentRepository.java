package com.ef.repositories;

import com.ef.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Ariel Morel
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("Select c FROM comment c WHERE  c.ip= :ip")
    List<Comment> findByIp(@Param("ip") String ip);
}
