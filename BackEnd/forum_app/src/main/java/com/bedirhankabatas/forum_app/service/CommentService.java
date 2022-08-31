package com.bedirhankabatas.forum_app.service;

import com.bedirhankabatas.forum_app.entities.Comment;
import com.bedirhankabatas.forum_app.entities.Post;
import com.bedirhankabatas.forum_app.entities.Users;
import com.bedirhankabatas.forum_app.repository.CommentRepository;
import com.bedirhankabatas.forum_app.request.CommentCreateRequest;
import com.bedirhankabatas.forum_app.request.CommentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private  UserService userService;
    @Autowired
    private PostService postService;

    public List<Comment> getAllComment(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUsersIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUsersId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        }else
            return commentRepository.findAll();
    }

    public Comment getOneCommentById(Long commentId) {
            return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        Users users = userService.getOneUserById(commentCreateRequest.getUserId());
        Post post = postService.getOnePostById(commentCreateRequest.getPostId());
        if(users!=null && post!= null){
            Comment commentToSave = new Comment();
            commentToSave.setId(commentCreateRequest.getId());
            commentToSave.setPost(post);
            commentToSave.setUsers(users);
            commentToSave.setText(commentCreateRequest.getText());
            return commentRepository.save(commentToSave);
        }else
            return  null;
    }

    public Comment updateOneComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
    Optional<Comment> comment = commentRepository.findById(commentId);
    if (comment.isPresent()){
        Comment commentToUpdate=comment.get();
        commentToUpdate.setText(commentUpdateRequest.getText());
        return commentRepository.save(commentToUpdate);
    }else
        return null;
    }

    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
