package com.tc.springboot.controller;
import com.tc.springboot.Dto.UserLoginRequestDto;
import com.tc.springboot.Dto.UserResponseDto;
import com.tc.springboot.Dto.UserSaveRequestDto;
import com.tc.springboot.Dto.UserUpdateRequestDto;
import com.tc.springboot.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/v1/user/join")
    public int save(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }

    @PutMapping("/v1/user/modify/{tc_id}")
    public int update(@PathVariable String tc_id, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(tc_id,requestDto);
    }

    @GetMapping("/v1/user/detail/{tc_id}")
    public UserResponseDto findById(@PathVariable String tc_id){
        return userService.findById(tc_id);
    }
    @GetMapping("/v1/user/login/{tc_id}")
    public String login(@RequestBody UserLoginRequestDto requestDto){
        return userService.findPasswordById(requestDto);
    }

}
