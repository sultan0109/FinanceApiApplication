package com.example.Finance_api.service;

import com.example.Finance_api.dto.ApiResponse;
import com.example.Finance_api.dto.UserDto;
import com.example.Finance_api.entity.User;

import java.util.List;

public interface UserService {
    ApiResponse create(UserDto user);
    List<User> getAll();
    User get(Long id);
    User update(Long id, UserDto user);
}