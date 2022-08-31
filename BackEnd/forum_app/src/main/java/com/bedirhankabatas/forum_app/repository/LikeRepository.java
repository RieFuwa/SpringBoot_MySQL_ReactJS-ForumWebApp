package com.bedirhankabatas.forum_app.repository;

import com.bedirhankabatas.forum_app.entities.Comment;
import com.bedirhankabatas.forum_app.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {

    List<Like> findByUsersIdAndPostId(Long userId, Long postId);

    List<Like> findByUsersId(Long userId);
    List<Like> findByPostId(Long postId);
}
