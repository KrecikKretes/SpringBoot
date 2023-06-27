package com.zawisza.restapitwo.service;

import com.zawisza.restapitwo.model.Comment;
import com.zawisza.restapitwo.model.Post;
import com.zawisza.restapitwo.repository.CommentRepository;
import com.zawisza.restapitwo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private static final int PAGE_SIZE = 20;
    public List<Post> getPosts(int page, Sort.Direction sort){
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort,"id")));

    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        //Wyciagnij posty ze stron
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort,"id")));
        //Wyciagnij id z postow
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .toList();
        //Znajdz komentarze z id
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        //Dla kazdego posta ustaw komentarz (o ile ma)
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }
}
