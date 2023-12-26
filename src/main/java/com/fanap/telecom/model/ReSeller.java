package com.fanap.telecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "reseller")
public class ReSeller extends User {

    @Column(name = "code", unique = true)
    private String code;

    @Override
    public String toString() {

        return "Reseller [code=" + code + ", getId()=" + getUserId() + "," +
                " getUsername()=" + getUserName() + ", getName()=" + getCode() + "]";
    }
}
