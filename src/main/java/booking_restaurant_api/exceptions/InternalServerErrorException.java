package booking_restaurant_api.exceptions;

import booking_restaurant_api.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalServerErrorException extends BookingException{
    private static final long serialVersionUID = 1L;
    public InternalServerErrorException(String message, String code) {
        super(message, code, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public InternalServerErrorException(String message, String code, ErrorDto data) {
        super(message, code, HttpStatus.INTERNAL_SERVER_ERROR.value(), Arrays.asList(data));
    }
}
