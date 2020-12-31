package booking_restaurant_api.services.impl;


import booking_restaurant_api.exceptions.BookingException;
import booking_restaurant_api.exceptions.InternalServerErrorException;
import booking_restaurant_api.exceptions.NotFoundException;
import booking_restaurant_api.repositories.ReservationRepository;
import booking_restaurant_api.services.CancelReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelReservationServiceImpl implements CancelReservationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);
    @Autowired
    private ReservationRepository reservationRepository;

    public String deleteReservation(String locator) throws BookingException {
        reservationRepository.findByLocator(locator).
                orElseThrow(() -> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));
        try {
            reservationRepository.deleteByLocator(locator);
        } catch (final Exception err) {
            LOGGER.error("INTERNAL_SERVER_ERROR", err);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");

        }
        return "LOCATOR_DELETED";
    }
}
