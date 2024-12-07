//package com.example.realEstateCk.Model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class RealEstate {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String description;
//    private double price;
//    private String imageUrl;
//    private String formattedPrice;
//
//    // Getters, Setters và Constructor
//    public RealEstate() {}
//
//    public RealEstate(String name, String description, double price, String imageUrl) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.imageUrl = imageUrl;
//    }
//
//    // Các getter và setter
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getFormattedPrice() {
//        return formattedPrice;
//    }
//
//    public void setFormattedPrice(String formattedPrice) {
//        this.formattedPrice = formattedPrice;
//    }
//
//    @Override
//    public String toString() {
//        return "RealEstate{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                ", imageUrl='" + imageUrl + '\'' +
//                '}';
//    }
//}
