package booking_restaurant_api.exceptions;

import booking_restaurant_api.dtos.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class BookingException extends Exception{
    private static final long serialVersionUID= 1L;
    private final String code;
    private final int responseCode;

    private final List<ErrorDto> errorDTOList = new ArrayList<>();

    public BookingException(String message, String code, int responseCode) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public BookingException(String message, String code, int responseCode, List<ErrorDto> errorDtoList) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorDTOList.addAll(errorDtoList);
    }

    public String getCode() {
        return code;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public List<ErrorDto> getErrorDTOList() {
        return errorDTOList;
    }

}
