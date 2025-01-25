package com.example.User_Input.Service;

import java.util.List;
import java.util.Optional;

import com.example.User_Input.Dto.ConstructorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User_Input.Entity.Inputs;
import com.example.User_Input.Repository.InputsRepo;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class InputsService {

    @Autowired
    private InputsRepo inputsRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private static final String CONSTRUCTOR_SERVICE_URL = "http://localhost:8086/api/constructors";


    public Inputs createInput(Inputs input) {
        return inputsRepository.save(input);
    }

    public List<Inputs> getAllInputs() {
        return inputsRepository.findAll();
    }


    public Inputs getInputById(Long id) {
        // Handle Optional correctly to avoid returning null
        return inputsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Input with ID " + id + " not found"));
    }

    // Assign Constructor to Input
    public Inputs assignConstructor(Long inputId, String specialization) {
        Inputs input = getInputById(inputId);

        // Fetch available constructors from ConstructionMicroservice
        ConstructorDto availableConstructor = webClientBuilder.build()
                .get()
                .uri(CONSTRUCTOR_SERVICE_URL + "?specialization=" + specialization + "&available=true")
                .retrieve()
                .bodyToMono(ConstructorDto.class)
                .block();

        if (availableConstructor == null) {
            throw new RuntimeException("No available constructor with specialization: " + specialization);
        }

        // Update Input with Constructor ID
        input.setConstructionId(availableConstructor.getConstructionid());
        inputsRepository.save(input);

        // Mark constructor as unavailable in ConstructionMicroservice
        webClientBuilder.build()
                .post()
                .uri(CONSTRUCTOR_SERVICE_URL + "/" + availableConstructor.getConstructionid() + "/assign")
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return input;
    }

    public void updateConstructionId(Long inputId, Long constructionId) {
        Inputs input = inputsRepository.findById(inputId)
                .orElseThrow(() -> new RuntimeException("Input not found"));
        input.setConstructionId(constructionId);
        inputsRepository.save(input);
    }


}
