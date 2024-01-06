package com.orbitelco.inventory.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="product")
@Data
@ToString
public class Product {
  @Id
  // @Column(name="product_quantity_id")
  // @GeneratedValue(strategy = GenerationType.AUTO)
  // private long id;
  @Column(name="product_id")
  private String productId;
  @Column(name="name")
  private String name;
  @Column(name="brand")
  private String brand;
  @Column(name="category")
  private String category;
}
