package booking_restaurant_api.services;

import booking_restaurant_api.exceptions.BookingException;
import booking_restaurant_api.jsons.CreateReservationRest;
import booking_restaurant_api.jsons.ReservationsRest;

public interface ReservationService {
    ReservationsRest getReservation(Long reservationId) throws BookingException;
    String createReservation(CreateReservationRest createReservationRest) throws BookingException;

}
