package pard.secondSeminar.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//getter, setter, constructor, toString 같은 기능 다 들어가있음 -> 불피요한 코드 작성 안해도 됨 -> 나이스 !
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloDto {
    private String userName;
    private int age;
}
