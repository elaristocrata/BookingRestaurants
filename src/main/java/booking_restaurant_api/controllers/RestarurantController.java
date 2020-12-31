package booking_restaurant_api.controllers;

import booking_restaurant_api.exceptions.BookingException;
import booking_restaurant_api.jsons.RestaurantRest;
import booking_restaurant_api.responses.BookingResponse;
import booking_restaurant_api.services.CancelReservationService;
import booking_restaurant_api.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/booking-restaurant" + "v1")
public class RestarurantController {
    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurant" + "/{" + "restaurantId" + "}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<RestaurantRest> getRestaurantById(Long restaurantId) throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurantById(restaurantId));
    }


}
