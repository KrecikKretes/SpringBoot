package com.zawisza.restapitwo.repository;

import com.zawisza.restapitwo.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //@Query("select p from Post p where title = :title")
    List<Post> findAllByTitle(String title);
    //JPA pozwala na tworzenie zapytań dzięki nazwie metody. Jest są to zapytanai z where

    //@Query("Select p From Post p" +
    //    " left join fetch p.comment")
    //Pobiera wszystkie rekordy z bazy i dopiero program tnie
    @Query("Select p From Post p")
    List<Post> findAllPosts(Pageable page);
}
