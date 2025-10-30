package se331.mookratabackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;           // ADD THIS
import org.springframework.security.core.context.SecurityContextHolder;  // ADD THIS
import org.springframework.web.bind.annotation.*;
import se331.mookratabackend.security.user.User;
import se331.mookratabackend.service.AdminUserService;
import se331.mookratabackend.util.LabMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    final AdminUserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDto(users));
    }

    @PutMapping("/users/{userId}/promote-to-member")
    public ResponseEntity<?> promoteToMember(@PathVariable Long userId) {
        User user = userService.promoteToMember(userId);
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDto(user));
    }

    @PutMapping("/users/{userId}/demote-to-reader")
    public ResponseEntity<?> demoteToReader(@PathVariable Long userId) {
        User user = userService.demoteToReader(userId);
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDto(user));
    }
}