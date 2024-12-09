package com.example.realEstateCk.model;


import jakarta.persistence.*;

@Entity
@Table(name = "property_details")
public class PropertyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pcontent", nullable = false, columnDefinition = "LONGTEXT")
    private String pcontent;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "bhk", nullable = false)
    private String bhk;

    @Column(name = "stype", nullable = false)
    private String stype;

    @Column(name = "bedroom", nullable = false)
    private int bedroom;

    @Column(name = "bathroom", nullable = false)
    private int bathroom;

    @Column(name = "balcony", nullable = false)
    private String balcony;

    @Column(name = "kitchen", nullable = false)
    private int kitchen;

    @Column(name = "hall", nullable = false)
    private int hall;

    @Column(name = "floor", nullable = false)
    private String floor;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "totalfloor", nullable = false)
    private String totalfloor;

    @Column(name = "namecontract", nullable = false)
    private String namecontract;
    @Column(name = "phonecontract", nullable = false)
    private String phonecontract;
    @Column(name = "emailcontract", nullable = false)
    private String emailcontract;
    @Column(name = "methodpost", nullable = false)
    private String methodpost;
    @Column(name = "time", nullable = false)
    private int time;

    @ManyToOne
    @JoinColumn(name = "properties_id", referencedColumnName = "id", nullable = false)
    private Property properties;

    // Getters and Setters
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getMethodpost() {
        return methodpost;
    }

    public void setMethodpost(String methodpost) {
        this.methodpost = methodpost;
    }

    public String getPhonecontract() {
        return phonecontract;
    }

    public void setPhonecontract(String phonecontract) {
        this.phonecontract = phonecontract;
    }

    public String getEmailcontract() {
        return emailcontract;
    }

    public void setEmailcontract(String emailcontract) {
        this.emailcontract = emailcontract;
    }

    public String getNamecontract() {
        return namecontract;
    }

    public void setNamecontract(String namecontract) {
        this.namecontract = namecontract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBhk() {
        return bhk;
    }

    public void setBhk(String bhk) {
        this.bhk = bhk;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTotalfloor() {
        return totalfloor;
    }

    public void setTotalfloor(String totalfloor) {
        this.totalfloor = totalfloor;
    }

    public Property getProperties() {
        return properties;
    }

    public void setProperties(Property properties) {
        this.properties = properties;
    }
}