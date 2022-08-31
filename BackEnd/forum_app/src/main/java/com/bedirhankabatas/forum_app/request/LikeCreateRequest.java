package com.bedirhankabatas.forum_app.request;

import lombok.Data;

@Data
public class LikeCreateRequest {
    Long id;
    Long userId;
    Long postId;
}
