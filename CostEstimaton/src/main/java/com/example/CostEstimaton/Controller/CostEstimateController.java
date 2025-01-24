package com.example.CostEstimaton.Controller;



// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.ConstructionCalculator.CostEstimator.Model.CostEstimate;
// import com.ConstructionCalculator.CostEstimator.Service.CostEstimateService;

// @RestController
// @RequestMapping("/api/cost-estimates")
// public class CostEstimateController {

//     @Autowired
//     private CostEstimateService costEstimateService;

//     @PostMapping("/{inputId}")
//     public ResponseEntity<CostEstimate> calculateCost(@PathVariable Long inputId) {
//         CostEstimate estimate = costEstimateService.calculateCost(inputId);
//         return ResponseEntity.ok(estimate);
//     }

//     @GetMapping("/calculate/{inputId}")
//     public ResponseEntity<Object> getCostEstimate(@PathVariable Long inputId) {
//         Optional<CostEstimate> costEstimateOpt = costEstimateService.getCostEstimate(inputId);
//         if (costEstimateOpt.isPresent()) {
//             return ResponseEntity.ok(costEstimateOpt.get());
//         } else {
//             return ResponseEntity.status(404).body("Input not found");
//         }
//     }

//     @GetMapping
//     public ResponseEntity<List<CostEstimate>> getAllEstimates() {
//         return ResponseEntity.ok(costEstimateService.getAllEstimates());
//     }

import com.example.CostEstimaton.Service.CostEstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostEstimaton.Model.CostEstimate;

@RestController
@RequestMapping("/api/cost-estimates")
public class CostEstimateController {

    @Autowired
    private CostEstimateService costEstimateService;

    @GetMapping("/calculate/{inputId}")
    public ResponseEntity<CostEstimate> calculateCost(
            @PathVariable Long inputId) {
        CostEstimate estimate = costEstimateService.calculateCost(inputId);
        return ResponseEntity.ok(estimate);
    }
}
