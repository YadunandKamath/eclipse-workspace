package com.restful.dvdrental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "city_id")
    int cityId;
    @Column(name = "city")
    String city;
    @Column(name = "country_id")
    short countryId;
    @Column(name = "last_update")
    Timestamp lastUpdate;
}
