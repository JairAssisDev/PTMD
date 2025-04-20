package br.edu.ifpe.ptmd.controller;
import br.edu.ifpe.ptmd.config.security.TokenService;
import br.edu.ifpe.ptmd.controller.dto.UserDtoReponse;
import br.edu.ifpe.ptmd.controller.dto.UserLoginDTO;
import br.edu.ifpe.ptmd.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
@Tag(name = "Authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody UserLoginDTO request) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        User user =(User)auth.getPrincipal();
        var toker = tokenService.generateToken(user);
        UserDtoReponse userDto = new UserDtoReponse(user.getUsername(),user.getId(),toker);
        return ResponseEntity.ok(userDto);
    }

}