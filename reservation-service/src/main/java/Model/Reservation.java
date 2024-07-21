package Model;


import Dto.ReservationDto;
import Dto.ReservationIdDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Reservations")

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "reservation_id")
    private Integer reservationId;
    @Column(name= "reservation_code")
    private Integer reservationCode;


}
