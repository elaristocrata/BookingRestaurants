package booking_restaurant_api.services.impl;

import booking_restaurant_api.entities.Reservation;
import booking_restaurant_api.entities.Restaurant;
import booking_restaurant_api.entities.Turn;
import booking_restaurant_api.exceptions.BookingException;
import booking_restaurant_api.exceptions.InternalServerErrorException;
import booking_restaurant_api.exceptions.NotFoundException;
import booking_restaurant_api.jsons.CreateReservationRest;
import booking_restaurant_api.jsons.ReservationsRest;
import booking_restaurant_api.repositories.ReservationRepository;
import booking_restaurant_api.repositories.RestaurantRepository;
import booking_restaurant_api.repositories.TurnRepository;
import booking_restaurant_api.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



public class ReservationServiceImp implements ReservationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImp.class);
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationsRest getReservation(Long reservationId) throws BookingException {

        return null;
    }


    public String createReservation(CreateReservationRest createReservationRest) throws BookingException {
        final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId()).
                orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));
        final Turn turn = turnRepository.findById(createReservationRest.getRestaurantId()).
                orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));
        String locator = generateLocator(restaurantId, createReservationRest);

        final Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationRest.getPerson());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turn.getName());
        try {
            reservationRepository.save(reservation);
        } catch (final Exception err) {
            LOGGER.error("INTERNAL_SERVER_ERROR", err);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }

        return locator;
    }

    private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest) throws BookingException {
        return restaurantId.getName() + createReservationRest.getTurnId();
    }

}
