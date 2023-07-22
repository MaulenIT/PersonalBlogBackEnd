package com.example.pressRelize.repository;

import com.example.pressRelize.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByTimerSendMessageIsLessThan(Timestamp timestamp);
}
