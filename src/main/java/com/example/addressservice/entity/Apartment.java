package com.example.addressservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apartments")

public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "area")
    private float area;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house_id;
}
