package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReservationIdDto {
    private String reservationId;
    private String reservationCode;

    public static ReservationIdDto convert(String reservationId, String reservationCode) {
        return new ReservationIdDto(reservationId, reservationCode);
    }

}
