package com.bedirhankabatas.forum_app.controller;

import com.bedirhankabatas.forum_app.entities.Post;
import com.bedirhankabatas.forum_app.repository.PostRepository;
import com.bedirhankabatas.forum_app.request.PostCreateRequest;
import com.bedirhankabatas.forum_app.request.PostUpdateRequest;
import com.bedirhankabatas.forum_app.response.PostResponse;
import com.bedirhankabatas.forum_app.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private final PostService postService;

    @GetMapping()
    public List<PostResponse> getAllPost(@RequestParam Optional<Long> userId){
    return postService.getAllPost(userId);
    }

    @GetMapping("/getAll/{postId}")
    public Post getOnePostById(@PathVariable("postId") Long postId){
        return postService.getOnePostById(postId);
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody PostCreateRequest postCreateRequest){
        return postService.createPost(postCreateRequest);
    }

    @PutMapping("/update/{postId}")
    public Post updatePost(@PathVariable("postId")  Long postId, @RequestBody PostUpdateRequest updatePost){
        return postService.updateOneByPostId(postId,updatePost);
    }

    @DeleteMapping("/delete/{postId}")
    public  void deleteOnePost(@PathVariable("postId") Long postId){
        postService.deleteOnePostById(postId);
    }

}
