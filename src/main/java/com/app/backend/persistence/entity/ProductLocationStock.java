package com.app.backend.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//  TODO: QUE NO SEA UNA LISTA EN EL LOCATION, QUE SE BUSQUE, POR QUE EN LA BUSQUEDA DE UN PRODUCTO
//   DEBERÍAS ESCOGER UN LOCATION Y COMO YA TIENES EL PRODUCTO, BUSCA DEFRENTE EL STOCK.
@Entity
public class ProductLocationStock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long productId;

  private Long locationId;

  private Integer quantity;

  public ProductLocationStock() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

}
