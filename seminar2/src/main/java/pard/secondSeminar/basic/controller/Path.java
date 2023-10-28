package pard.secondSeminar.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pard.secondSeminar.basic.dto.HelloDto;

@Slf4j
@RestController
public class Path {

    @GetMapping("mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mapping userId={}", data);

        return "userId = " + data;
    }

    //required == ture => 반드시 있어야 함
    //int: null 값 허용 O
    //Integer: null 값 허용 X
    @GetMapping("mapping/users/{userId}/age/{age}")
    public String mappingPath(@PathVariable String userId, @PathVariable int age) {
        log.info("mapping userId={}, age={}", userId, age);

        return "userId = " + userId + ", age = " + age;
    }

    //http://localhost:8080/requestParam/users?name=ysh&age=21
    @GetMapping("requestParam/users")
    public String mappingPath(@RequestParam(defaultValue = "YSH") String name, @RequestParam(required = false) Integer age) {
        log.info("RequestParam name={}, age={}", name, age);

        return "name = " + name + ", age = " + age;
    }

    @ResponseStatus(HttpStatus.CREATED) //디폴트 값 200
    @PostMapping("requestBody")
    public String requestBody(@RequestBody HelloDto helloDto) {
        log.info("RequestBody : name={}, age={}", helloDto.getUserName(), helloDto.getAge());

        return "name = " + helloDto.getUserName() + " , age = " + helloDto.getAge();
    }


}
