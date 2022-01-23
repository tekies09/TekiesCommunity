package com.tc.springboot.controller;
import com.tc.springboot.Dto.UserSaveRequestDto;
import com.tc.springboot.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/v1/user/join")
    public int save(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }
}
