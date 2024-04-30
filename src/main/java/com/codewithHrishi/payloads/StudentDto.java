package com.codewithHrishi.payloads;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private int id;

    @NotEmpty
    @Size(min = 5, message = "Please enter at least 5 characters for a valid name")
    private String name;

    @NotNull
    @Min(value = 1000000000, message = "Please enter a valid contact number")
    @Max(value = 9999999999L, message = "Please enter a valid contact number")
    private long contact;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 100, message = "Please enter a password between 1 and 100 characters")
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String username;
}
