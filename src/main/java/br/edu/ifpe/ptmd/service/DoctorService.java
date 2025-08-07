package br.edu.ifpe.ptmd.service;

import br.edu.ifpe.ptmd.controller.dto.ClinicalAssessmentImageDTO;
import br.edu.ifpe.ptmd.controller.dto.ClinicalAssessmentImageRequestDTO;
import br.edu.ifpe.ptmd.controller.dto.PredictionDTO;
import br.edu.ifpe.ptmd.model.Classification;
import br.edu.ifpe.ptmd.model.ClassificationMultiClass;
import br.edu.ifpe.ptmd.model.ClinicalAssessment;
import br.edu.ifpe.ptmd.repository.IClinicalAssessmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {

    private final IClinicalAssessmentRepository assessmentRepository;

    public DoctorService(IClinicalAssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }


    public void salvar(ClinicalAssessmentImageRequestDTO dto) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        // Cria o recurso da imagem
        ByteArrayResource imagemResource = new ByteArrayResource(dto.file().getBytes()) {
            @Override
            public String getFilename() {
                return dto.file().getOriginalFilename(); // ou forneça um nome fixo se necessário
            }
        };

        // Corpo do formulário multipart
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", imagemResource);

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);

        // Envio da requisição
        String apiUrl = "http://127.0.0.1:8081/predict";
        ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            Map<String, Object> json = response.getBody();

            // Acessa a lista "predictions"
            List<Map<String, Object>> predictions = (List<Map<String, Object>>) json.get("predictions");

            if (predictions != null && !predictions.isEmpty()) {
                Map<String, Object> firstPrediction = predictions.get(0);

                String prediction = (String) firstPrediction.get("class");
                double probability = (Double) firstPrediction.get("Probabilidade");
                String multClass = (String) firstPrediction.get("MultClass");
                String probabilidadeMultClass = (String) firstPrediction.get("ProbabilidadeMultClass");

                ClinicalAssessment assessment = new ClinicalAssessment();
                assessment.setNome(dto.nome());
                assessment.setCpf(dto.cpf());
                assessment.setImageBase64(Base64.getEncoder().encodeToString(dto.file().getBytes()));
                assessment.setBinaryPredictions("Probabilidade: " + probability);

                // Só define classification se o valor não for vazio
                if (multClass != null && !multClass.isBlank()) {
                    assessment.setClassificationMultiClass(ClassificationMultiClass.valueOf(multClass));
                    assessment.setMultiClassPredictions("Probabilidade: " + probabilidadeMultClass);
                }

                if (prediction != null && !prediction.isBlank()) {
                    Classification classification = Classification.valueOf(prediction.toUpperCase());
                    assessment.setClassification(classification);
                }
            }
        }

    }
}
