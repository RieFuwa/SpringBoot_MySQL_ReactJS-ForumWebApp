package com.bedirhankabatas.forum_app.repository;

import com.bedirhankabatas.forum_app.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
