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
public class OrderListDto implements Serializable {
    private Long saleOrderId;
    private Long user;
    private Long product;
    private Integer number;
    private Date createdAt;
    private Date updatedAt;
}
