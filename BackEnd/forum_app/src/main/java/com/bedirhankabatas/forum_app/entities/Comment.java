package com.bedirhankabatas.forum_app.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment {

    @Id
    @SequenceGenerator(name = "comment_seq_gen",sequenceName = "comment_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comment_seq_gen")
    Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Users users;

    @Lob
    @Column(columnDefinition = "text")
    String text;

}
