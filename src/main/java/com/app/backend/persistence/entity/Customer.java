package com.app.backend.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String email;

  private String phone;

  private Boolean status = Boolean.TRUE;

  @OneToMany
  @JoinColumn(name = "customerId", referencedColumnName = "id", insertable = false, updatable = false)
  private List<CustomerAddress> customerAddressList;

  public Customer() {
  }

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public List<CustomerAddress> getCustomerAddressList() {
    return customerAddressList;
  }

  public void setCustomerAddressList(
      List<CustomerAddress> customerAddressList) {
    this.customerAddressList = customerAddressList;
  }
}
