package com.example.Finance_api.service;

import com.example.Finance_api.dto.ApiResponse;
import com.example.Finance_api.dto.UserDto;
import com.example.Finance_api.entity.UserInfo;

import java.util.List;

public interface UserService {
    ApiResponse create(UserDto user);
    List<UserInfo> getAll();
    UserInfo get(Long id);
    UserInfo update(Long id, UserDto user);
}