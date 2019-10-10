package com.gavin.seckill.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserOauth implements Serializable {
    private Long id;

    private Long userId;

    private Long oauthId;

    private static final long serialVersionUID = 1L;
}