package com.example.realEstateCk.model;

import jakarta.persistence.*;

@Entity
@Table(name = "property_images")
public class PropertyImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Property property;  // Thêm thuộc tính này để ánh xạ với property trong Property

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
