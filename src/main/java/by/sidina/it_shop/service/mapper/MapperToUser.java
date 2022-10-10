package by.sidina.it_shop.service.mapper;

import by.sidina.it_shop.dto.UserDto;
import by.sidina.it_shop.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class MapperToUser {
    public User mapToUser(UserDto userDto, User user) {
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCountry(userDto.getCountry());
        return user;
    }
}
