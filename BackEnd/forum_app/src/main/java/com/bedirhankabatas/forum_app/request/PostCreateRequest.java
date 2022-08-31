package com.bedirhankabatas.forum_app.request;

import lombok.Data;

@Data
public class PostCreateRequest {
    Long id;
    String text;
    String title;
    Long userId;
}
