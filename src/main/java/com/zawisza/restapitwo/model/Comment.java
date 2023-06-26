package com.zawisza.restapitwo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Comment {
    @Id
    private int id;
    private String content;
    private LocalDateTime created;


}
