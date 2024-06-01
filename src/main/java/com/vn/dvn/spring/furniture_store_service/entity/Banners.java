package com.vn.dvn.spring.furniture_store_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name= "banner")
@Jacksonized
public class Banners {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "banner_id")
    String bannerId;

    @Column(name = "image_path", length = 255, unique = true)
    String imagePath;

}
