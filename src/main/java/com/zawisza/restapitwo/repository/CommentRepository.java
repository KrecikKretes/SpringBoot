package com.zawisza.restapitwo.repository;

import com.zawisza.restapitwo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostIdIn(List<Long> ids);
}
