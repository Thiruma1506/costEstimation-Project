package com.example.User_Input.Controller;

import com.example.User_Input.Entity.Inputs;
import com.example.User_Input.Service.InputRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // This annotation was missing in your original code
@RequestMapping("/api/area-requests")
public class InputController {

    @Autowired
    private InputRequestService areaRequestService;

    // Create new area request
    @PostMapping
    public ResponseEntity<Inputs> createAreaRequest(@RequestBody Inputs areaRequest) {
        Inputs createdRequest = areaRequestService.createAreaRequest(areaRequest);
        return ResponseEntity.status(201).body(createdRequest); // Return status 201 (Created)
    }

    // Get all area requests
    @GetMapping
    public ResponseEntity<List<Inputs>> getAllAreaRequests() {
        List<Inputs> requests = areaRequestService.getAllAreaRequests();
        return ResponseEntity.ok(requests); // Return status 200 (OK)
    }

    // Get area request by ID
    @GetMapping("/{id}")
    public ResponseEntity<Inputs> getAreaRequestById(@PathVariable Long id) {
        Optional<Inputs> request = areaRequestService.getAreaRequestById(id);
        return request.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Return 404 if not found
    }

    // Update area request by ID
    @PutMapping("/{id}")
    public ResponseEntity<Inputs> updateAreaRequest(@PathVariable Long id, @RequestBody Inputs areaRequest) {
        Inputs updatedRequest = areaRequestService.updateAreaRequest(id, areaRequest);
        return ResponseEntity.ok(updatedRequest); // Return updated area request with status 200 (OK)
    }

    // Delete area request by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAreaRequest(@PathVariable Long id) {
        areaRequestService.deleteAreaRequest(id);
        return ResponseEntity.noContent().build(); // Return 204 (No Content) when deleted successfully
    }
}
