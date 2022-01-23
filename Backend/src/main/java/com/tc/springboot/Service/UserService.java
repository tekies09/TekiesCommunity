package com.tc.springboot.Service;

import com.tc.springboot.Dto.UserSaveRequestDto;
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
}
