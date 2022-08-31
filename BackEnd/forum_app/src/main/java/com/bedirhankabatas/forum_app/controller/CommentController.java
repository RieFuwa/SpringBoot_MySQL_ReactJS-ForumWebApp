package com.bedirhankabatas.forum_app.controller;

import com.bedirhankabatas.forum_app.entities.Comment;
import com.bedirhankabatas.forum_app.request.CommentCreateRequest;
import com.bedirhankabatas.forum_app.request.CommentUpdateRequest;
import com.bedirhankabatas.forum_app.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    @Autowired
    private final CommentService commentService;

    @GetMapping("/getAll")
    public List<Comment> getAllComment(@RequestParam Optional<Long> userId,@RequestParam Optional<Long> postId){
    return commentService.getAllComment(userId,postId);
    }

    @GetMapping("/getAll/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }

    @PostMapping("/create")
    public Comment createOneComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return commentService.createOneComment(commentCreateRequest);
    }

    @PutMapping("/update/{commentId}")
    public  Comment updateOneComment(@PathVariable("commentId") Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest){
        return commentService.updateOneComment(commentId, commentUpdateRequest);
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteOneComment(@PathVariable("commentId") Long commentId){
        commentService.deleteOneComment(commentId);
    }
}
