package net.zeonsoftwares.fitness.controller;

import net.zeonsoftwares.fitness.entity.AdminEntity;
import net.zeonsoftwares.fitness.entity.TrainerEntity;
import net.zeonsoftwares.fitness.repository.AdminRepository;
import net.zeonsoftwares.fitness.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        // Extract data from the request body
        String username = loginData.get("username");
        String password = loginData.get("password");
        String role = loginData.get("role");

        // Validate input fields
        if (username == null || password == null || role == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "message", "Missing required fields: username, password, and role",
                    "status", "error"
            ));
        }

        // Log the login attempt
        System.out.println("Login attempt: Username=" + username + ", Role=" + role);

        // Handle login logic based on role
        switch (role.toLowerCase()) {
            case "admin":
                // Find admin by adminId
                AdminEntity admin = adminRepository.findById(username).orElse(null);
                if (admin != null && admin.getAdminPassword().equals(password)) {
                    return ResponseEntity.ok(Map.of(
                            "message", "Login Successful",
                            "role", "admin"
                    ));
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                            "message", "Invalid admin credentials",
                            "status", "error"
                    ));
                }

            case "trainer":
                // Find trainer by trainerId
                TrainerEntity trainer = trainerRepository.findById(username).orElse(null);
                if (trainer != null && trainer.getTrainerPassword().equals(password)) {
                    return ResponseEntity.ok(Map.of(
                            "message", "Login Successful",
                            "role", "trainer"
                    ));
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                            "message", "Invalid trainer credentials",
                            "status", "error"
                    ));
                }

            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                        "message", "Invalid role. Accepted roles: admin, trainer",
                        "status", "error"
                ));
        }
    }
}
