package Repository;


import Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    Optional<Reservation> findReservationByReservationCode(String reservationCode);
}
