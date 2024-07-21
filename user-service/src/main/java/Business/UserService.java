package Business;

import Dto.UserDto;
import Model.User;
import Repository.UserRepository;
import Exception.UserNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getAllUserByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User could not found by user id: " + userId));

        UserDto userDto = new UserDto(user.getUserId());
        return userDto;
    }

    public UserDto createUser() {
        User newUser = userRepository.save(new User());
        return new UserDto(newUser.getUserId());
    }

}
