package com.sergio.bookstore.backend.user.dto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
private String status;
    private boolean isAuthenticated;
    private String methodType;
    private String username;
    private String token;
    private List<Authorities> authorities;
}
