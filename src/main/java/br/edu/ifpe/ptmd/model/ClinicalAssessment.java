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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private Doctor doctor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageBase64;

    @Column(nullable = false)
    private Classification classification;

    @Column(nullable = false)
    private ClassificationMultiClass classificationMultiClass;

    @Column(nullable = false)
    private String binaryPredictions;

    @Column(nullable = false)
    private String multiClassPredictions;

    @Column(nullable = false)
    private String finalDiagnosis;
}
