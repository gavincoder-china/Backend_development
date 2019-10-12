package com.gavin.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserOauth implements Serializable {
    private Long id;

    private Long userId;

    private Long oauthId;

    private static final long serialVersionUID = 1L;
}