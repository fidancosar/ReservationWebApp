package Dto;

import Model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private ReservationIdDto reservationId;
    private Integer reservationCode;

    public ReservationDto(ReservationIdDto convert) {
    }

    public static ReservationDto convert(Reservation from) {

        return new ReservationDto(
                from.getReservationId() != null ? ReservationIdDto.convert(from.getReservationId(), from.getReservationCode()) : null);

}
}
