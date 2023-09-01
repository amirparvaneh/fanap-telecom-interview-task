package com.fanap.telecom.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseAllDto implements Serializable {
    private Long userId;
    private String userName;
    private Date createdAt;
    private Date updatedAt;
}
