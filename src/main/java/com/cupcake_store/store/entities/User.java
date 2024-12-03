package com.cupcake_store.store.entities;

import com.cupcake_store.store.entities.dtos.UserDTO;
import com.cupcake_store.store.entities.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    public UserDTO toUserDTO() {
        return UserDTO.builder()
                .id(this.id)
                .username(this.username)
                .email(this.email)
                .phone(this.phone)
                .address(this.address)
                .userType(this.userType)
                .build();
    }
}
