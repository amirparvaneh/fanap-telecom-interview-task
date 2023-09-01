package com.fanap.telecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "commission")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commissionId;
    @Column(name = "amount")
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "reseller_id")
    private ReSeller resellerId;
    @ManyToOne
    @JoinColumn(name = "sale_order_id")
    private SaleOrder saleOrderId;
}
