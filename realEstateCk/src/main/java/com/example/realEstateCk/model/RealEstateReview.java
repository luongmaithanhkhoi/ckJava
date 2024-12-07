//package com.example.realEstateCk.Model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class RealEstateReview {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "real_estate_id", nullable = false)
//    private RealEstate realEstate;
//
//    private String reviewerName;
//    private String comment;
//    private int rating;
//    private LocalDateTime reviewDate;
//
//    // Getters, Setters, Constructors
//
//    public RealEstateReview() {
//    }
//
//    public RealEstateReview(RealEstate realEstate, String reviewerName, String comment, int rating, LocalDateTime reviewDate) {
//        this.realEstate = realEstate;
//        this.reviewerName = reviewerName;
//        this.comment = comment;
//        this.rating = rating;
//        this.reviewDate = reviewDate;
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
//    public String getReviewerName() {
//        return reviewerName;
//    }
//
//    public void setReviewerName(String reviewerName) {
//        this.reviewerName = reviewerName;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public LocalDateTime getReviewDate() {
//        return reviewDate;
//    }
//
//    public void setReviewDate(LocalDateTime reviewDate) {
//        this.reviewDate = reviewDate;
//    }
//
//    @Override
//    public String toString() {
//        return "RealEstateReview{" +
//                "id=" + id +
//                ", realEstate=" + realEstate +
//                ", reviewerName='" + reviewerName + '\'' +
//                ", comment='" + comment + '\'' +
//                ", rating=" + rating +
//                ", reviewDate=" + reviewDate +
//                '}';
//    }
//}
