package booking_restaurant_api.exceptions;

import booking_restaurant_api.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFoundException extends BookingException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message, String code) {
        super(message, code, HttpStatus.NOT_FOUND.value());
    }

    public NotFoundException(String message, String code, ErrorDto data) {
        super(message, code, HttpStatus.NOT_FOUND.value(), Arrays.asList(data));
    }
}
