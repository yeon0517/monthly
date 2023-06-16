package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminDto {
    private Long adminNumber;
    private String adminId;
    private String adminPassword;
    private String adminEmail;
}
