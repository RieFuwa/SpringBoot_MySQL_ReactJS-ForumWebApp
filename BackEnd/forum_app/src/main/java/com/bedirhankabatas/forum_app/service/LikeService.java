package com.bedirhankabatas.forum_app.service;

import com.bedirhankabatas.forum_app.entities.Comment;
import com.bedirhankabatas.forum_app.entities.Like;
import com.bedirhankabatas.forum_app.entities.Post;
import com.bedirhankabatas.forum_app.entities.Users;
import com.bedirhankabatas.forum_app.repository.CommentRepository;
import com.bedirhankabatas.forum_app.repository.LikeRepository;
import com.bedirhankabatas.forum_app.request.LikeCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private  UserService userService;
    @Autowired
    private PostService postService;
    public List<Like> getAllLike(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()){
            return likeRepository.findByUsersIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return likeRepository.findByUsersId(userId.get());
        } else if (postId.isPresent()) {
            return likeRepository.findByPostId(postId.get());
        }else
            return likeRepository.findAll();
    }


    public Like getLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public Like createLike(LikeCreateRequest likeCreateRequest) {
       return null;
    }

    public void deleteLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
