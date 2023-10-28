package PARD.thridSeminar.service;

import PARD.thridSeminar.dto.ResponseDto;
import PARD.thridSeminar.dto.SignUpDto;
import PARD.thridSeminar.repository.UserRepository;
import PARD.thridSeminar.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseDto<UserEntity> signUp(SignUpDto dto) {
        UserEntity user = new UserEntity(dto);
        String userEmail = dto.getUserEmail();
        try {
            if (userRepository.existsByUserEmail(userEmail)) {
                return ResponseDto.setFail("이미 존재하는 아이디 입니다");
            }
            userRepository.save(user);

            return ResponseDto.setSuccess("축하해", user);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseDto.setFail("데이터 베이스 오류");
        }
    }

    public ResponseDto<List<UserEntity>> findAll() {
        List<UserEntity> users;
        try {
            users = userRepository.findAll();
            return ResponseDto.setSuccess("find Success", users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFail("DB오류");
        }
    }

    public ResponseDto<UserEntity> findOne(Integer userNum) {
        UserEntity user;
        try {
            user = userRepository.findById(userNum).get();
            return ResponseDto.setSuccess("fidne one", user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFail("DB오류");
        }
    }

    @Transactional
    public ResponseDto<UserEntity> update(Integer userNum, SignUpDto dto) {
        UserEntity user;
        try {
            user = userRepository.findById(userNum).get();
            if (dto.getUserEmail() != null && !dto.getUserEmail().isEmpty()) {
                user.setUserEmail(dto.getUserEmail());
            }
            if (dto.getUserPassword() != null && !dto.getUserPassword().isEmpty()) {
                user.setUserPassword(dto.getUserPassword());
            }

            return ResponseDto.setSuccess("update", user);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseDto.setFail("DB오류");

        }
    }

    public ResponseDto<?> delete(Integer userNum) {
        try {
            if (userRepository.existsById(userNum)) {
                userRepository.deleteById(userNum);

                return ResponseDto.setSuccess("delete", null);
            } else {
                return ResponseDto.setFail("존재하지 않은 id 입니다");
            }

        } catch (Exception e) {
            e.printStackTrace();

            return ResponseDto.setFail("DB오류");
        }
    }

    public ResponseDto<String> signIn(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
        if (!existed) {
            return ResponseDto.setFail("존재하지 않아요");
        }

        return ResponseDto.setSuccess("로그인을 축하드립니다", userEmail);
    }
}
