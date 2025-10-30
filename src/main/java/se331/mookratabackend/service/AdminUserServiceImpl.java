package se331.mookratabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.mookratabackend.security.user.Role;
import se331.mookratabackend.security.user.User;
import se331.mookratabackend.security.user.UserRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {
    final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User promoteToMember(Long userId) {
        User user = userRepository.findById(userId.intValue()).orElseThrow();
        user.getRoles().remove(Role.ROLE_READER);
        user.getRoles().add(Role.ROLE_MEMBER);
        return userRepository.save(user);
    }

    @Override
    public User demoteToReader(Long userId) {
        User user = userRepository.findById(userId.intValue()).orElseThrow();
        user.getRoles().remove(Role.ROLE_MEMBER);
        user.getRoles().add(Role.ROLE_READER);
        return userRepository.save(user);
    }
}