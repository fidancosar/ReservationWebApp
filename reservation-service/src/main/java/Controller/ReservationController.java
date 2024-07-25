package Controller;

import Business.ReservationService;
import Dto.ReservationDto;
import Dto.ReservationIdDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/reservation")
@RequiredArgsConstructor
@Validated
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservation());
    }
    @GetMapping("/reservationcode/{reservationcode}")
    public ResponseEntity<ReservationIdDto> getreservationCode(@PathVariable @NotEmpty String reservationCode) {
        return ResponseEntity.ok(reservationService.findReservationByReservationCode((reservationCode)));
    }
    @GetMapping("/reservation/{reservationid}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable @NotEmpty String reservationid) {
        return ResponseEntity.ok(reservationService.findReservationDetailsByReservationId((reservationid)));
    }

}
