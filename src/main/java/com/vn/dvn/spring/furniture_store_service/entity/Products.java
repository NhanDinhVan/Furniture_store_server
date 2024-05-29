package com.vn.dvn.spring.furniture_store_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
     String id;

    @Column(name = "name", length = 255)
     String name;

    @Column(name = "description")
     String description;

    @Column(name = "price")
     Float price;

    @Column(name = "state", length = 50)
     String state;

    @Column(name = "quantity", length = 11)
     int quantity;

    @Column(name = "sold", length = 11)
     int sold;

    @Column(name = "image_path")
    String imagePath;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brands brand;

    @Column(name = "view", length = 11)
     int view;

    @Column(name = "discount")
     Float discount;

    @CreationTimestamp
    @Column(name = "creation_time")
     Timestamp creation_time;

    @UpdateTimestamp
    @Column(name = "updation_time")
    Timestamp updationtime;
}
