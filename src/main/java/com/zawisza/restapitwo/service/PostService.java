package com.zawisza.restapitwo.service;

import com.zawisza.restapitwo.model.Post;
import com.zawisza.restapitwo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private static final int PAGE_SIZE = 20;
    public List<Post> getPosts(int page){
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));

    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}
