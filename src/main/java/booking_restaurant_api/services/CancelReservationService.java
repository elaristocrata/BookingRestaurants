package booking_restaurant_api.services;

import booking_restaurant_api.exceptions.BookingException;

public interface CancelReservationService {
     String deleteReservation(String locator) throws BookingException;
}
