//package net.zeonsoftwares.fitness.controller;
//
//import net.zeonsoftwares.fitness.entity.UserEntity;
//import net.zeonsoftwares.fitness.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/login")
//@CrossOrigin(origins = "http://localhost:3000")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    // Get all users
//    @GetMapping
//    public ResponseEntity<List<UserEntity>> getAllUsers() {
//        List<UserEntity> users = userRepository.findAll();
//        return ResponseEntity.ok(users);
//    }
//
//    // Get user by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable String id) {
//        Optional<UserEntity> user = userRepository.findById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }
//
//    // Create new user
//    @PostMapping
//    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
//        UserEntity createdUser = userRepository.save(userEntity);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//    }
//
//    // Update user
//    @PutMapping("/{id}")
//    public ResponseEntity<UserEntity> updateUser(@PathVariable String id, @RequestBody UserEntity userEntity) {
//        if (!userRepository.existsById(id)) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        userEntity.setUserId(id);  // Ensure we don't change the userId during update
//        UserEntity updatedUser = userRepository.save(userEntity);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    // Delete user
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
//        if (!userRepository.existsById(id)) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        userRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//}
