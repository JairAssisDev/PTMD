package br.edu.ifpe.ptmd.controller;

import br.edu.ifpe.ptmd.controller.dto.DoctorRegisterDto;
import br.edu.ifpe.ptmd.controller.dto.ManagerRegisterDto;
import br.edu.ifpe.ptmd.service.DoctorService;
import br.edu.ifpe.ptmd.service.ManagerService;
import br.edu.ifpe.ptmd.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
@Tag(name = "Manager")
public class ManagerController {

    @Autowired
    private UserService userService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/manager")
    public ResponseEntity Manager(@RequestBody @Valid ManagerRegisterDto request) {
        if (userService.findByEmail(request.getEmail()))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        request.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        try {
            managerService.save(request);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/doctor")
    public ResponseEntity Doctor(@RequestBody @Valid DoctorRegisterDto request) {
        if (userService.findByEmail(request.getEmail()))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        request.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        try {
            doctorService.save(request);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
