package com.restful.dvdrental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "country_id")
    int countryId;
    @Column(name = "country")
    String country;
    @Column(name = "last_update")
    Timestamp lastUpdate;
}
