package com.vn.dvn.spring.furniture_store_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Jacksonized
@Table(name = "carts")
public class Carts {

    @Id
    @Column(name = "cartId")
    @GeneratedValue(strategy = GenerationType.UUID)
    String cartId;

    @Column(name = "userId")
    String userId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products product;

    @Column(name = "qty")
    int quantity;

}
