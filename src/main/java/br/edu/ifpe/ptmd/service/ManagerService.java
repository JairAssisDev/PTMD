package br.edu.ifpe.ptmd.service;
import br.edu.ifpe.ptmd.controller.dto.DoctorRegisterDto;
import br.edu.ifpe.ptmd.controller.dto.ManagerRegisterDto;
import br.edu.ifpe.ptmd.model.AcessLevel;
import br.edu.ifpe.ptmd.model.Doctor;
import br.edu.ifpe.ptmd.model.Manager;
import br.edu.ifpe.ptmd.repository.IDoctorRepository;
import br.edu.ifpe.ptmd.repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private IManagerRepository managerRepository;
    @Autowired
    private IDoctorRepository doctorRepository;

    public void save(ManagerRegisterDto dto) {

        managerRepository.save(new Manager(dto.getNome(),dto.getCpf(),dto.getEmail(),dto.getPassword(),AcessLevel.MANAGER));
    }

    public void save(DoctorRegisterDto dto) {
        doctorRepository.save(new Doctor(dto.getNome(),dto.getCpf(),dto.getEmail(),dto.getPassword(), AcessLevel.DOCTOR,dto.getCRM()));
    }
}
