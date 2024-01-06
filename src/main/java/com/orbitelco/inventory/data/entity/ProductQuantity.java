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
@Table(name="product_quantity")
@Data
@ToString
public class ProductQuantity {
  @Id
  // @Column(name="product_quantity_id")
  // @GeneratedValue(strategy = GenerationType.AUTO)
  // private long id;
  @Column(name="product_id")
  private String productId;
  @Column(name="quantity")
  private long quantity;
}
