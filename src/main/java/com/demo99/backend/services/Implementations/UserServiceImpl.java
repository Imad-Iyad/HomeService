package com.demo99.backend.services.Implementations;

import com.demo99.backend.model.dto.UserReqDTO;
import com.demo99.backend.model.entities.Enums.Role;
import com.demo99.backend.model.entities.User;
import com.demo99.backend.model.mapper.Impl.UserMapper;
import com.demo99.backend.repositories.UserRepository;
import com.demo99.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> getUserById (Long id){
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllProviders() {
        return userRepository.findAll();
    }

    @Override
    public String UpdateUser(Long id, UserReqDTO userDto) {
        User user = userMapper.toEntity(userDto);
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            optionalUser.get().setName(user.getName());
            optionalUser.get().setEmail(user.getEmail());
            optionalUser.get().setPassword(user.getPassword());
            optionalUser.get().setRole(Role.CUSTOMER);
            userRepository.save(optionalUser.get());
            return "User updated successfully";
        }else  {
            return "User not found";
        }
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }

}
