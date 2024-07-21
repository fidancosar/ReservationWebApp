package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationIdDto {
    private Integer reservationId;
    private Integer reservationCode;

    public static ReservationIdDto convert(Integer reservationId, Integer reservationCode) {
        return new ReservationIdDto(reservationId, reservationCode);
    }

}
