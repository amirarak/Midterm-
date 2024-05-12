package kg.alatoo.midterm.controllers;

import kg.alatoo.midterm.DTO.authorization.AuthLoginDTO;
import kg.alatoo.midterm.DTO.authorization.JwtDTO;
import kg.alatoo.midterm.entity.RefreshToken;
import kg.alatoo.midterm.service.RefreshTokenService;
import kg.alatoo.midterm.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public JwtDTO AuthenticateAndGetToken(@RequestBody AuthLoginDTO authRequestDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequestDTO.getUsername());
            return JwtDTO.builder()
                    .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername()))
                    .token(refreshToken.getToken())
                    .build();

        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}
