package com.cupcake_store.store.entities.dtos;

import com.cupcake_store.store.entities.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String phone;
    private String address;
    private UserType userType;
}
