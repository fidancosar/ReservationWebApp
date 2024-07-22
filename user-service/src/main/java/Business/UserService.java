package Business;

import Exception.ReservationNotFoundException;
import Client.ReservationServiceClient;
import Dto.AddReservationRequest;
import Dto.UserDto;
import Model.User;
import Repository.UserRepository;
import Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ReservationServiceClient reservationServiceClient;

    public UserService(UserRepository userRepository, ReservationServiceClient reservationServiceClient) {
        this.userRepository = userRepository;
        this.reservationServiceClient = reservationServiceClient;
    }


    public UserDto getAlReservationByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation could not found by id: "+ userId));

        UserDto userDto = new UserDto(user.getUserId(),
                user.getUserReservation()
                    .stream()
                    .map(reservationServiceClient::getReservationById)
                    .map(ResponseEntity::getBody)
                    .collect(Collectors.toList()));
        return userDto;
    }

    public UserDto createUser() {
        User newUser = userRepository.save(new User());
        return new UserDto(newUser.getUserId());
    }

    public void addReservation(AddReservationRequest request){
        Integer reservationId = reservationServiceClient.getReservationByReservationCode(request.getReservationCode()).getBody().getReservationId();

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new UserNotFoundException("User could not found by user id: " + request.getUserId()));

        user.getUserReservation()
                        .add(user.getUserId());

        userRepository.save(user);
    }

}
