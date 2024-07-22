package Business;


import Dto.ReservationDto;
import Dto.ReservationIdDto;
import Model.Reservation;
import Repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import Exception.ReservationNotFoundException;

@Service

public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public List<ReservationDto> getAllReservation() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationDto::convert)
                .collect(Collectors.toList());

    }

    public ReservationIdDto findReservationByReservationCode(String reservationCode) {
        return reservationRepository.findReservationByReservationCode(reservationCode)
                .map(reservation -> new ReservationIdDto(reservation.getReservationId(), reservation.getReservationCode()))
                .orElseThrow(() -> new ReservationNotFoundException("Reservation could not found by reservation code: " +reservationCode));
    }


    public ReservationDto findReservationDetailsByReservationId(String reservationId) {
        return reservationRepository.findById(reservationId)
                .map(ReservationDto::convert)
                .orElseThrow(()-> new ReservationNotFoundException("Reservation could not found by reservation id: " +reservationId));
    }


}

