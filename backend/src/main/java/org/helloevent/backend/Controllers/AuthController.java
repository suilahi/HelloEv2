package org.helloevent.backend.Controllers;
import jakarta.validation.Valid;
import org.helloevent.backend.DTO.LoginRequest;
import org.helloevent.backend.DTO.RegisterRequest;
import org.helloevent.backend.Services.AuthService;
import org.helloevent.backend.DTO.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) {
        System.out.println(request.toString());
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid LoginRequest request) {
        return authService.login(request);
    }
}
