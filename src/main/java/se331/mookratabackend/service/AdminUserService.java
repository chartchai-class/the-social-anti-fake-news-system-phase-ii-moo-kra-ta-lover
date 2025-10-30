package se331.mookratabackend.service;

import se331.mookratabackend.security.user.User;
import java.util.List;

public interface AdminUserService {
    List<User> getAllUsers();
    User promoteToMember(Long userId);
    User demoteToReader(Long userId);
}