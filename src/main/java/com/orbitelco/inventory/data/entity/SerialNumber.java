package com.orbitelco.inventory.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="serial_number")   
@Data
@ToString 
public class SerialNumber {
    @EmbeddedId
    private SerialNumberKey id;
    // @Id
    // @Column(name="serial_number_id")
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private long id;
    @Column(name="product_id")
    private String productId;
    @Column(name="serial_number")
    private String serialNumber;
}
