package com.restaurants;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Restaurant {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  private Integer userId;

  private String restaurantName;

  private String address;

  private String description;

  private String openingHours;

  private String image;

}
