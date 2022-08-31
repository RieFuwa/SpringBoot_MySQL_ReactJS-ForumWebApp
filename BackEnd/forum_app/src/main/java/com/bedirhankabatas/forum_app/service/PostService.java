package com.bedirhankabatas.forum_app.service;


import com.bedirhankabatas.forum_app.entities.Post;
import com.bedirhankabatas.forum_app.entities.Users;
import com.bedirhankabatas.forum_app.repository.PostRepository;
import com.bedirhankabatas.forum_app.request.PostCreateRequest;
import com.bedirhankabatas.forum_app.request.PostUpdateRequest;
import com.bedirhankabatas.forum_app.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    public List<PostResponse> getAllPost(Optional<Long> userId) {
        List<Post> list;
        if(userId.isPresent()){
            list =  postRepository.findByUsersId(userId.get());
        }
            list =  postRepository.findAll();
            return list.stream().map(p -> new PostResponse(p)).collect(Collectors.toList());
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }
    public Post createPost(PostCreateRequest postCreateRequest) {
        Users users=  userService.getOneUserById(postCreateRequest.getUserId());
        if(users==null)
            return  null;
        Post toSave = new Post();
        toSave.setId(postCreateRequest.getId());
        toSave.setText(postCreateRequest.getText());
        toSave.setTitle(postCreateRequest.getTitle());
        toSave.setUsers(users);
        return postRepository.save(toSave);
    }


    public Post updateOneByPostId(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate= post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }


    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
