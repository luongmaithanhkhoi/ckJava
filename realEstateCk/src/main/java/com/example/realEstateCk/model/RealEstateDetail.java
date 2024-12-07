//package com.example.realEstateCk.Model;
//
//import jakarta.persistence.*;
//
//@Entity
//public class RealEstateDetail {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "real_estate_id", nullable = false)
//    private RealEstate realEstate;
//
//    private String lotArea;
//    private int bedRooms;
//    private int bathRooms;
//    private boolean luggage;
//    private int garage;
//    private String floorArea;
//    private int yearBuilt;
//    private boolean water;
//    private int stories;
//    private String roofing;
//
//    // Getters, Setters, Constructors
//
//    public RealEstateDetail() {
//    }
//
//    public RealEstateDetail(RealEstate realEstate, String lotArea, int bedRooms, int bathRooms, boolean luggage, int garage, String floorArea, int yearBuilt, boolean water, int stories, String roofing) {
//        this.realEstate = realEstate;
//        this.lotArea = lotArea;
//        this.bedRooms = bedRooms;
//        this.bathRooms = bathRooms;
//        this.luggage = luggage;
//        this.garage = garage;
//        this.floorArea = floorArea;
//        this.yearBuilt = yearBuilt;
//        this.water = water;
//        this.stories = stories;
//        this.roofing = roofing;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public RealEstate getRealEstate() {
//        return realEstate;
//    }
//
//    public void setRealEstate(RealEstate realEstate) {
//        this.realEstate = realEstate;
//    }
//
//    public String getLotArea() {
//        return lotArea;
//    }
//
//    public void setLotArea(String lotArea) {
//        this.lotArea = lotArea;
//    }
//
//    public int getBedRooms() {
//        return bedRooms;
//    }
//
//    public void setBedRooms(int bedRooms) {
//        this.bedRooms = bedRooms;
//    }
//
//    public int getBathRooms() {
//        return bathRooms;
//    }
//
//    public void setBathRooms(int bathRooms) {
//        this.bathRooms = bathRooms;
//    }
//
//    public boolean isLuggage() {
//        return luggage;
//    }
//
//    public void setLuggage(boolean luggage) {
//        this.luggage = luggage;
//    }
//
//    public int getGarage() {
//        return garage;
//    }
//
//    public void setGarage(int garage) {
//        this.garage = garage;
//    }
//
//    public String getFloorArea() {
//        return floorArea;
//    }
//
//    public void setFloorArea(String floorArea) {
//        this.floorArea = floorArea;
//    }
//
//    public int getYearBuilt() {
//        return yearBuilt;
//    }
//
//    public void setYearBuilt(int yearBuilt) {
//        this.yearBuilt = yearBuilt;
//    }
//
//    public boolean isWater() {
//        return water;
//    }
//
//    public void setWater(boolean water) {
//        this.water = water;
//    }
//
//    public int getStories() {
//        return stories;
//    }
//
//    public void setStories(int stories) {
//        this.stories = stories;
//    }
//
//    public String getRoofing() {
//        return roofing;
//    }
//
//    public void setRoofing(String roofing) {
//        this.roofing = roofing;
//    }
//
//    @Override
//    public String toString() {
//        return "RealEstateDetail{" +
//                "id=" + id +
//                ", realEstate=" + realEstate +
//                ", lotArea='" + lotArea + '\'' +
//                ", bedRooms=" + bedRooms +
//                ", bathRooms=" + bathRooms +
//                ", luggage=" + luggage +
//                ", garage=" + garage +
//                ", floorArea='" + floorArea + '\'' +
//                ", yearBuilt=" + yearBuilt +
//                ", water=" + water +
//                ", stories=" + stories +
//                ", roofing='" + roofing + '\'' +
//                '}';
//    }
//}
