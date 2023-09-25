package com.example.backendspringboottechiteasycontrollerles10.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "wall_brackets")
public class WallBracket {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String size;
    private Boolean adjustable;
    private Double price;

    @ManyToMany (mappedBy = "wallBracketsList")
    private List<Television> televisionsList;

    public WallBracket(Long id, String name, String size, Boolean adjustable, Double price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.adjustable = adjustable;
        this.price = price;
    }
    public WallBracket() {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
