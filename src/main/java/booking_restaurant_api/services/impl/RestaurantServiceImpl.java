package booking_restaurant_api.services.impl;

import booking_restaurant_api.entities.Restaurant;
import booking_restaurant_api.exceptions.BookingException;
import booking_restaurant_api.exceptions.NotFoundException;
import booking_restaurant_api.jsons.RestaurantRest;
import booking_restaurant_api.repositories.RestaurantRepository;
import booking_restaurant_api.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    public static final ModelMapper modelMapper = new ModelMapper();

    public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {

        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
    }


    public List<RestaurantRest> getRestaurants() throws BookingException {
        final List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream().map(service -> modelMapper.map(service, RestaurantRest.class))
                .collect(Collectors.toList());
    }

    private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
        return restaurantRepository.findById(restaurantId).orElseThrow(() ->
                new NotFoundException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
    }
}
