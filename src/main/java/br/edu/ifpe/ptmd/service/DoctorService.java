package br.edu.ifpe.ptmd.service;

import br.edu.ifpe.ptmd.controller.dto.DoctorRegisterDto;
import br.edu.ifpe.ptmd.model.AcessLevel;
import br.edu.ifpe.ptmd.model.Doctor;
import br.edu.ifpe.ptmd.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    public void save(DoctorRegisterDto dto) {
        doctorRepository.save(new Doctor(dto.getNome(),dto.getCpf(),dto.getEmail(),dto.getPassword(), AcessLevel.DOCTOR,dto.getCRM()));
    }

}
