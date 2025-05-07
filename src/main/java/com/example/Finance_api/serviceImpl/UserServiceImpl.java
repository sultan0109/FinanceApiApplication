package com.example.Finance_api.serviceImpl;

import com.example.Finance_api.dto.ApiResponse;
import com.example.Finance_api.dto.UserDto;
import com.example.Finance_api.entity.UserInfo;
import com.example.Finance_api.repo.UserRepository;
import com.example.Finance_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public ApiResponse create(UserDto userDto) {
        if (userRepository.existsUserByUsername(userDto.getUsername())) {
            return new ApiResponse("User already exists", 409, null);
        }
        UserInfo user = new UserInfo(userDto.getUsername(), userDto.getPassword());
        UserInfo savedUser = userRepository.save(user);
        return new ApiResponse("User created successfully", 201, savedUser.getId());
    }

    @Override
    public UserInfo update(Long id, UserDto userDto) {
        UserInfo existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(userDto.getUsername());
        existingUser.setPassword(userDto.getPassword());

        return userRepository.save(existingUser);
    }

    @Override
    public List<UserInfo> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo get(Long id) {
        Optional<UserInfo> user = userRepository.findById(id);
        return user.orElse(null);
    }


}