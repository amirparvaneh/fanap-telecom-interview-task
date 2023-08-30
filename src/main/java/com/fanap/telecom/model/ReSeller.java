package com.fanap.telecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ReSeller")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReSeller extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reSellerId;

}
