package com.example.monthly.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String gender;

}