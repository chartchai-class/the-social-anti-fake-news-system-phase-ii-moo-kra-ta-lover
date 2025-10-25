package se331.mookratabackend.security.user;

public interface UserDao {
    User findByEmail(String email);

    User save(User user);
}