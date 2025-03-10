package com.example.adventuresAPI;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ADVENTURES")
public class Adventure {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "NUM_PHOTOS")
    private Integer numPhotos;

    @Column(name = "BLOG_COMPLETED")
    private Boolean blogCompleted;

    // getters and setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Integer getNumPhotos() {
        return numPhotos;
    }

    public void setNumPhotos(Integer numPhotos) {
        this.numPhotos = numPhotos;
    }

    public Boolean getBlogCompleted() {
        return blogCompleted;
    }

    public void setBlogCompleted(Boolean blogCompleted) {
        this.blogCompleted = blogCompleted;
    }

    // toString method
}