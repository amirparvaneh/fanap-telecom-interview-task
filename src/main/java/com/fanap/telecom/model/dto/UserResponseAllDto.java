package com.fanap.telecom.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserResponseAllDto implements Serializable {
    private Long userId;
    private String userName;
}
