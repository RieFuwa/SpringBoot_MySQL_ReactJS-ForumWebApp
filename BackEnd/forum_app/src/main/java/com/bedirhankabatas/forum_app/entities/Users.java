package com.bedirhankabatas.forum_app.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="User")
@Data
public class Users {
     @Id
     @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_gen",initialValue = 100,allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
     Long id;

     String userName;
     String password;

}
