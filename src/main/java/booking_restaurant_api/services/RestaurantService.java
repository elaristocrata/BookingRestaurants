package booking_restaurant_api.services;

import booking_restaurant_api.exceptions.BookingException;
import booking_restaurant_api.jsons.RestaurantRest;

import java.util.List;

public interface RestaurantService {
    RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
    List<RestaurantRest> getRestaurants() throws BookingException;
}
