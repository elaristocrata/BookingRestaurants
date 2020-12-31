package booking_restaurant_api.repositories;

import booking_restaurant_api.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurnRepository extends JpaRepository<Turn,Long> {
    Optional<Turn>findById(Long id);
}
