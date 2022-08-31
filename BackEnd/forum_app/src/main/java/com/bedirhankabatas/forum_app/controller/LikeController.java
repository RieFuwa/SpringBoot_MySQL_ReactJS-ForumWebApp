package com.bedirhankabatas.forum_app.controller;

import com.bedirhankabatas.forum_app.entities.Comment;
import com.bedirhankabatas.forum_app.entities.Like;
import com.bedirhankabatas.forum_app.request.LikeCreateRequest;
import com.bedirhankabatas.forum_app.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {

    @Autowired
    public final LikeService likeService;

    @GetMapping("/getAll")
    public List<Like> getAllLike(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return likeService.getAllLike(userId,postId);
    }

    @GetMapping("/{likeId}")
    public Like getLikeById(@PathVariable("likeId") Long likeId){
        return likeService.getLikeById(likeId);
    }

    @PostMapping("/create")
    public Like createLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return likeService.createLike(likeCreateRequest);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable("likeId") Long likeId){
        likeService.deleteLikeById(likeId);
    }

}
