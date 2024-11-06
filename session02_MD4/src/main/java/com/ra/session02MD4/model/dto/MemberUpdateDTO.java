package com.ra.session02MD4.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class MemberUpdateDTO {
    @NotBlank(message = "Tên không được để trống")
    @Size(min =2,max = 50,message = "Tên phải có độ dài từ 2 đến 50 ký tự")
    String fullName;

    @Email(message = "email không hợp lệ")

    String email;

    @NotNull(message = "Ngày sinh không được để trống")
    LocalDate dateOfBirth;

}
