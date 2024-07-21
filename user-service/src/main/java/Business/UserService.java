package Business;

import Client.ReservationServiceClient;
import Dto.AddReservationRequest;
import Dto.UserDto;
import Model.User;
import Repository.UserRepository;
import Exception.UserNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ReservationServiceClient reservationServiceClient;

    public UserService(UserRepository userRepository,
                       ReservationServiceClient reservationServiceClient) {
        this.userRepository = userRepository;
        this.reservationServiceClient = reservationServiceClient;
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getAllUserByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User could not found by user id: " + userId));

        UserDto userDto = new UserDto(user.getUserId());
            user.getUserReservation()
                    .stream()
                    .map(reservationServiceClient::getReservationById)
                    .map(ResponseEntity::getBody)
                    .collect(Collectors.toList());
        return userDto;
    }

    public UserDto createUser() {
        User newUser = userRepository.save(new User());
        return new UserDto(newUser.getUserId());
    }

    public void addReservation(AddReservationRequest request){
        Integer
    }

}
