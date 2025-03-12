package com.app.backend.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String description;

  private BigDecimal price;

  private String cardImage;

  private Boolean status = Boolean.TRUE;

  private String detailImage;

  private BigDecimal rating;

  @OneToMany
  @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
  private List<ProductCategory> productCategoryList;

  @OneToMany
  @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
  private List<ProductGallery> productGalleryList;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getCardImage() {
    return cardImage;
  }

  public void setCardImage(String cardImage) {
    this.cardImage = cardImage;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public String getDetailImage() {
    return detailImage;
  }

  public void setDetailImage(String detailImage) {
    this.detailImage = detailImage;
  }

  public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }

  public List<ProductCategory> getProductCategoryList() {
    return productCategoryList;
  }

  public void setProductCategoryList(List<ProductCategory> productCategoryList) {
    this.productCategoryList = productCategoryList;
  }

  public List<ProductGallery> getProductGalleryList() {
    return productGalleryList;
  }

  public void setProductGalleryList(
      List<ProductGallery> productGalleryList) {
    this.productGalleryList = productGalleryList;
  }
}
