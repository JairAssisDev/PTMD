package br.edu.ifpe.ptmd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClinicalAssessment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private Doctor doctor;
    @OneToOne
    private Patient patient;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)
    private String classification;

    @Column(nullable = false)
    private String classificationMultiClass;

    @Column(nullable = false)
    private String binaryPredictions;

    @Column(nullable = false)
    private String multiClassPredictions;

    @Column(nullable = false)
    private String finalDiagnosis;

}
