package com.fanap.telecom.model.dto;

import com.fanap.telecom.model.ReSeller;
import com.fanap.telecom.model.SaleOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommissionRequestDto implements Serializable {
    private ReSeller resellerId;
    private SaleOrder saleOrderId;
    private BigDecimal amount;
    private Date createdAt;
    private Date updateAt;
}
