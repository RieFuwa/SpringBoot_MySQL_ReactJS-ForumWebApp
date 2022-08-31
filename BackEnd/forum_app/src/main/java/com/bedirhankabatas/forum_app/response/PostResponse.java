package com.bedirhankabatas.forum_app.response;

import com.bedirhankabatas.forum_app.entities.Post;
import lombok.Data;

@Data
public class PostResponse {
    Long id;
    Long userId;
    String userName;
    String title;
    String text;
    public PostResponse(Post entity){
        this.id = entity.getId();
        this.userId = entity.getUsers().getId();
        this.userName=entity.getUsers().getUserName();
        this.title=entity.getTitle();
        this.text=entity.getText();

    }
}
