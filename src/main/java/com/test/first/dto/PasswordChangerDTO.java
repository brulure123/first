package com.test.first.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@NotNull
@Data
@ToString
public class PasswordChangerDTO {

    private Long idUser;
    private String newPassword;
    private String oldPassword;

}
