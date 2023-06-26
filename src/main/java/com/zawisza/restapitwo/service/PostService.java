package com.zawisza.restapitwo.service;

import com.zawisza.restapitwo.model.Post;
import com.zawisza.restapitwo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public List<Post> getPosts(){
        return postRepository.findAll();

    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}
