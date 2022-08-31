package com.bedirhankabatas.forum_app.repository;

import com.bedirhankabatas.forum_app.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUsersId(Long userId);
}
