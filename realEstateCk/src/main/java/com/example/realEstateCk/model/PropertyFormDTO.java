package com.example.realEstateCk.model;

public class PropertyFormDTO {

    private Property property;
    private PropertyDetails propertyDetails;

    // Constructor không tham số
    public PropertyFormDTO() {
        this.property = new Property();
        this.propertyDetails = new PropertyDetails();
    }

    // Constructor có tham số
    public PropertyFormDTO(Property property, PropertyDetails propertyDetails) {
        this.property = property;
        this.propertyDetails = propertyDetails;
    }

    // Getter và Setter cho property
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    // Getter và Setter cho propertyDetails
    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    @Override
    public String toString() {
        return "PropertyFormDTO{" +
                "property=" + property +
                ", propertyDetails=" + propertyDetails +
                '}';
    }
}

