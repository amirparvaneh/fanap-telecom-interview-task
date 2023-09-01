package com.fanap.telecom.model.dto;

import com.fanap.telecom.model.Product;
import com.fanap.telecom.model.User;
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
    private User user;
    private Product product;
    private Integer number;
    private Date createdAt;
    private Date updatedAt;
}
