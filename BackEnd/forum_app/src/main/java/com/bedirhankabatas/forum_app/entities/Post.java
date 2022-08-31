package com.bedirhankabatas.forum_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    @SequenceGenerator(name = "post_seq_gen",sequenceName = "post_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_seq_gen")
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiğinde tüm postları silinir.
    Users users;

    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
