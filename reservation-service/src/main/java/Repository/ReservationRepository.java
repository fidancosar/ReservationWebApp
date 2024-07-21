package Repository;


import Dto.ReservationIdDto;
import Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Optional<Reservation> findReservationByReservationCode(Integer reservationCode);
}
