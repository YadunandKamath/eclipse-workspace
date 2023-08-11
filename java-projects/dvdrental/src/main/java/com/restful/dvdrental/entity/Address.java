package com.restful.dvdrental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "address_id")
    int addressId;
    @Column(name = "address")
    String address;
    @Column(name = "address2")
    String address2;
    @Column(name = "district")
    String district;
    @Column(name = "city_id")
    short cityId;
    @Column(name = "postal_code")
    String postalCode;
    @Column(name = "phone")
    String phone;
    @Column(name = "last_update")
    Timestamp lastUpdate;
}
