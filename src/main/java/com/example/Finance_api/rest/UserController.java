package com.example.Finance_api.rest;

import com.example.Finance_api.dto.ApiResponse;
import com.example.Finance_api.dto.UserDto;
import com.example.Finance_api.entity.User;
import com.example.Finance_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ApiResponse create(@RequestBody UserDto dto) {
        return userService.create(dto);
    }

    @GetMapping
    public List<User> all() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Long id) {
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody UserDto dto) {
        return userService.update(id, dto);
    }
}