package com.example.User_Input.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.User_Input.Entity.Inputs;
import com.example.User_Input.Service.InputsService;

@RestController
@RequestMapping("/api/inputs")
public class InputsController {

    @Autowired
    private InputsService inputsService;

    @GetMapping
    public ResponseEntity<List<Inputs>> getAllInputs() {
        return ResponseEntity.ok(inputsService.getAllInputs());
    }

    @PostMapping
    public ResponseEntity<Inputs> createInput(@RequestBody Inputs input) {
        return ResponseEntity.status(201).body(inputsService.createInput(input));
    }

    @GetMapping("getid/{id}")
    public ResponseEntity<Inputs> getInputById(@PathVariable Long id) {
        try {
            Inputs input = inputsService.getInputById(id); // Directly fetch input
            return ResponseEntity.ok(input);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Handle the case where input is not found
        }
    }

    @PatchMapping("/{id}/set-construction-id/{constructionId}")
    public ResponseEntity<Void> setConstructionId(
            @PathVariable Long id,
            @PathVariable Long constructionId) {
        inputsService.updateConstructionId(id, constructionId);
        return ResponseEntity.ok().build();
    }


    // Assign Constructor to Input
    @PostMapping("/{id}/assign-constructor")
    public ResponseEntity<Inputs> assignConstructor(
            @PathVariable Long id,
            @RequestParam String specialization) {
        return ResponseEntity.ok(inputsService.assignConstructor(id, specialization));
    }


}
