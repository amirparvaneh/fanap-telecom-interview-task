package com.fanap.telecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sale_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleOrder extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleOrderId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "sale_number")
    private Integer number;
    @OneToOne()
    @JoinColumn(name = "commission_id")
    private Commission commissionId;

}
