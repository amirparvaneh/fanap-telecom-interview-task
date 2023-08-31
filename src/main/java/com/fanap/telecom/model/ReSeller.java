package com.fanap.telecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ReSeller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReSeller extends User {

    @Column(name = "code",unique = true)
    private String code;
}
