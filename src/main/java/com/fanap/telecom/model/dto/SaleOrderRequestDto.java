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
public class SaleOrderRequestDto implements Serializable {

    private Product product;
    private User user;
    private Integer number;
    private Date createdAt;
    private Date updatedAt;
}
