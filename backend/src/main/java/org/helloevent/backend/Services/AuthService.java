package org.helloevent.backend.Services;

import jakarta.validation.Valid;
import org.helloevent.backend.DTO.AuthResponse;
import org.helloevent.backend.DTO.LoginRequest;
import org.helloevent.backend.DTO.RegisterRequest;
import org.helloevent.backend.Config.JwtUtil;
import org.helloevent.backend.Entity.Client;
import org.helloevent.backend.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepo;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(PasswordEncoder passwordEncoder, ClientRepository clientRepo, JwtUtil jwtUtil) {
        this.passwordEncoder = passwordEncoder;
        this.clientRepo = clientRepo;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse register(@Valid RegisterRequest request) {
        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide.");
        }

        if (clientRepo.findByEmail(request.getEmail()) != null) {
            throw new IllegalArgumentException("Un compte avec cet email existe déjà.");
        }

        Client client = new Client();
        client.setEmail(request.getEmail());
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        client.setName(request.getName());
        client.setRole(request.getRole());

        clientRepo.save(client);

        String jwt = jwtUtil.generateToken(client.getEmail(), client.getRole());
        return new AuthResponse(jwt);
    }

    public AuthResponse login(@Valid LoginRequest req) {
        Client client = clientRepo.findByEmail(req.getEmail());

        if (client == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec cet email.");
        }

        if (!passwordEncoder.matches(req.getPassword(), client.getPassword())) {
            throw new BadCredentialsException("Mot de passe incorrect.");
        }

        String token = jwtUtil.generateToken(client.getEmail(), client.getRole());
        return new AuthResponse(token);
    }
}
