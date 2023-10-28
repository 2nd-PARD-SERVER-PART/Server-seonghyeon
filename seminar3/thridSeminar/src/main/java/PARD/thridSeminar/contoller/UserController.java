package PARD.thridSeminar.contoller;

import PARD.thridSeminar.dto.ResponseDto;
import PARD.thridSeminar.dto.SignUpDto;
import PARD.thridSeminar.service.UserService;
import PARD.thridSeminar.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseDto<UserEntity> signUp(@RequestBody SignUpDto dto) {
        ResponseDto<UserEntity> result = userService.signUp(dto);

        return result;
    }

    @GetMapping("/findAll")
    public ResponseDto<List<UserEntity>> findAll() {
        ResponseDto<List<UserEntity>> result = userService.findAll();

        return result;
    }

    @GetMapping("/findOne/{id}")
    public ResponseDto<UserEntity> findOne(@PathVariable Integer id) {
        ResponseDto<UserEntity> result = userService.findOne(id);

        return result;
    }

    //update dto 따로 만들어야 됨
    @PatchMapping("/update/{userNum}")
    public ResponseDto<UserEntity> update(@PathVariable int userNum, @RequestBody SignUpDto dto) {
        ResponseDto<UserEntity> result = userService.update(userNum, dto);

        return result;
    }

    @DeleteMapping("/delete/{userNum}")
    public ResponseDto<?> delete(@PathVariable int userNum) {
        ResponseDto<?> result = userService.delete(userNum);

        return result;
    }

    @GetMapping("/singIn")
    public ResponseDto<?> signIn(@RequestBody SignUpDto dto) {
        ResponseDto<?> result = userService.signIn(dto);

        return result;
    }
}
