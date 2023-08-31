package com.fanap.telecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ReSeller reSeller;
    @ManyToOne
    @JoinColumn(name = "sale_order_id")
    private SaleOrder saleOrder;
}