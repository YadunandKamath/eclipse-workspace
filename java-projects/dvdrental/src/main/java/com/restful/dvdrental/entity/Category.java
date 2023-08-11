package com.restful.dvdrental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "category_id")
    int categoryId;
    @Column(name = "name")
    String categoryName;
    @Column(name = "last_update")
    Timestamp lastUpdate;

}
