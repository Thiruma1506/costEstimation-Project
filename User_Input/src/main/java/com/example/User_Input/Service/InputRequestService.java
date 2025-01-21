package com.example.User_Input.Service;

import com.example.User_Input.Repository.InputsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import com.example.User_Input.Entity.Inputs;
import java.util.List;
import java.util.Optional;

@Service  // This annotation registers InputRequestService as a Spring Bean
public class InputRequestService {

    @Autowired
    private InputsRepo inputRequestRepository;

    // Create a new area request
    public Inputs createAreaRequest(Inputs areaRequest) {
        return inputRequestRepository.save(areaRequest);
    }

    // Get all area requests
    public List<Inputs> getAllAreaRequests() {
        return inputRequestRepository.findAll();
    }

    // Get area request by ID
    public Optional<Inputs> getAreaRequestById(Long id) {
        return inputRequestRepository.findById(id);
    }

    // Update area request by ID
    public Inputs updateAreaRequest(Long id, Inputs areaRequest) {
        try {
            if (inputRequestRepository.existsById(id)) {
                areaRequest.setId(id);  // Ensure the request gets updated with the same ID
                return inputRequestRepository.save(areaRequest);
            } else {
                throw new RuntimeException("Area Request not found");
            }
        } catch (OptimisticLockingFailureException e) {
            throw new RuntimeException("The area request has been modified by another user. Please try again.");
        }
    }


    // Delete area request by ID
    public void deleteAreaRequest(Long id) {
        inputRequestRepository.deleteById(id);
    }
}
