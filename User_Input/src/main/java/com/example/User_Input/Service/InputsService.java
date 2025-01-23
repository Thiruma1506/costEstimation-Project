package com.example.User_Input.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User_Input.Entity.Inputs;
import com.example.User_Input.Repository.InputsRepo;

@Service
public class InputsService {

    @Autowired
    private InputsRepo inputsRepository;

    public Inputs createInput(Inputs input) {
        return inputsRepository.save(input);
    }

    public List<Inputs> getAllInputs() {
        return inputsRepository.findAll();
    }

    public Optional<Inputs> getInputById(Long id) {
        // Use Optional to handle the case of a missing resource
        return inputsRepository.findById(id);
    }

}
