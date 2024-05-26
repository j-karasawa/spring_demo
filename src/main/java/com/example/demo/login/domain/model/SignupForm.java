package com.example.demo.login.domain.model;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupForm {
    
    @NotBlank(groups = ValidGroup1.class)
    @Email(groups = ValidGroup2.class)
    private String userId;

    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 4, max = 10, groups = ValidGroup2.class)
    @Pattern(regexp = "^[a-zA-z0-9]+$", groups = ValidGroup3.class)
    private String password;

    @NotBlank(groups = ValidGroup1.class)
    private String userName;

    @NotNull(groups = ValidGroup1.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Min(value = 20, groups = ValidGroup2.class)
    @Max(value = 100, groups = ValidGroup2.class)
    private int age;

    @AssertFalse(groups = ValidGroup2.class)
    private boolean marriage;
}
