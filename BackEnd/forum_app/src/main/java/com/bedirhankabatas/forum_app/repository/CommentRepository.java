package com.bedirhankabatas.forum_app.repository;

import com.bedirhankabatas.forum_app.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByUsersIdAndPostId(Long userId, Long postId);

    List<Comment> findByUsersId(Long userId);
    List<Comment> findByPostId(Long postId);
}
