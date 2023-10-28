package PARD.thridSeminar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "set")

public class ResponseDto<D> {
    private boolean reseult;
    private String message;
    private D data;

    public static <D> ResponseDto<D> setSuccess(String message, D data) {
        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto<D> setFail(String message) {
        return ResponseDto.set(false, message, null);
    }
}
