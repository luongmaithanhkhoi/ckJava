package com.example.realEstateCk.model;

public class CityPropertyDTO {
    private String cityName;
    private Long propertyCount;
    private String image;
    private Long locationId;

    // Constructor không tham số
    public CityPropertyDTO() {
    }

    public CityPropertyDTO(String cityName, Long propertyCount, String image, Long locationId) {
        this.cityName = cityName;
        this.propertyCount = propertyCount;
        this.image = image;
        this.locationId = locationId;
    }

    // Getter và Setter
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(Long propertyCount) {
        this.propertyCount = propertyCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
