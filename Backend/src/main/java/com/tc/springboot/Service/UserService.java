package com.tc.springboot.Service;

import com.tc.springboot.Dto.UserLoginRequestDto;
import com.tc.springboot.Dto.UserResponseDto;
import com.tc.springboot.Dto.UserSaveRequestDto;
import com.tc.springboot.Dto.UserUpdateRequestDto;
import com.tc.springboot.entity.User;
import com.tc.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public int save (UserSaveRequestDto requestDto){
        return userRepository.save(requestDto.toEntity()).getTc_num();
    }

    public int update(String tc_id, UserUpdateRequestDto requestDto){
        User entity = userRepository.findUserBytc_id(tc_id);
        entity.update(requestDto.getTc_password(), requestDto.getTc_email());
        return entity.getTc_num();
    }
    public UserResponseDto findById(String tc_id){
        User entity = userRepository.findUserBytc_id(tc_id);
        return new UserResponseDto(entity);
    }

    public String findPasswordById (UserLoginRequestDto requestDto){
        User entity = userRepository.findtc_passwordBytc_id(requestDto.getTc_id());
        if(entity==null || entity.getTc_password()!= requestDto.getTc_password()){
            return "loginFail";
        }
        return "loginSuccess";
    }
}
