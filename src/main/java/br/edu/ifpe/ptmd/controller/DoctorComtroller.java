package br.edu.ifpe.ptmd.controller;

import br.edu.ifpe.ptmd.controller.dto.ClinicalAssessmentImageDTO;
import br.edu.ifpe.ptmd.controller.dto.ClinicalAssessmentImageRequestDTO;
import br.edu.ifpe.ptmd.service.DoctorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("doctor")
@Tag(name = "Doctor")
public class DoctorComtroller {

    @Autowired
    DoctorService  doctorService;
    @PostMapping("/assessment")
    public ResponseEntity<String> criarAvaliacao(@ModelAttribute @Valid ClinicalAssessmentImageRequestDTO dto) throws IOException {
        doctorService.salvar(dto);
        return ResponseEntity.ok("Avaliação clínica salva com sucesso");
    }


}
