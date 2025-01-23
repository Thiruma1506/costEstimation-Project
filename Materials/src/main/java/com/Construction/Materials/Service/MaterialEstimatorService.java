package com.Construction.Materials.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.Construction.Materials.Model.MaterialEstimator;
import com.Construction.Materials.Repository.MaterialRepository;

@Service
public class MaterialEstimatorService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private MaterialRepository materialRepository;

    // Method to fetch cost from CostEstimator service and divide it among materials
    public List<MaterialEstimator> calculateMaterialCost(Long inputId, String quality, Long materialId) {
            // Fetch totalCost from CostEstimator service
            Double totalCost = fetchTotalCostFromCostEstimator(inputId);
    
            if (totalCost == null) {
                throw new RuntimeException("Failed to fetch total cost from CostEstimator service");
            }
    
            // Define cost allocation for each material
            double cementCost = totalCost * 0.15; // 15% of total cost for Cement
            double steelCost = totalCost * 0.10;  // 10% of total cost for Steel
            double brickCost = totalCost * 0.05;  // 5% of total cost for Bricks
            double aggregateCost = totalCost * 0.05;  // 5% for Aggregate
            double sandCost = totalCost * 0.05;     // 5% for Sand
            double flooringCost = totalCost * 0.08;  // 8% for Flooring
            double windowCost = totalCost * 0.07;    // 7% for Windows
            double doorCost = totalCost * 0.05;      // 5% for Doors
            double electricalCost = totalCost * 0.03; // 3% for Electrical Fittings
            double paintingCost = totalCost * 0.10;  // 10% for Painting
            double sanitaryCost = totalCost * 0.05;  // 5% for Sanitary Fittings
            double kitchenCost = totalCost * 0.10;   // 10% for Kitchen Work
            double contractorCost = totalCost * 0.15; // 15% for Contractor work
    
            // Allocate the costs to the resources based on selected quality
            List<MaterialEstimator> materials = List.of(
                createMaterial(materialId,inputId, "Cement", cementCost, quality),
            createMaterial(materialId,inputId, "Steel", steelCost, quality),
            createMaterial(materialId,inputId, "Bricks", brickCost, quality),
            createMaterial(materialId,inputId, "Aggregate", aggregateCost, quality),
            createMaterial(materialId,inputId, "Sand", sandCost, quality),
            createMaterial(materialId,inputId, "Flooring", flooringCost, quality),
            createMaterial(materialId,inputId, "Windows", windowCost, quality),
            createMaterial(materialId,inputId, "Doors", doorCost, quality),
            createMaterial(materialId,inputId, "Electrical fittings", electricalCost, quality),
            createMaterial(materialId,inputId, "Painting", paintingCost, quality),
            createMaterial(materialId,inputId, "Sanitary Fittings", sanitaryCost, quality),
            createMaterial(materialId,inputId, "Kitchen Work", kitchenCost, quality),
            createMaterial(materialId,inputId, "Contractor", contractorCost, quality)
        );

        // Save all materials to the database
        materialRepository.saveAll(materials);

        return materials;
    }

    // Helper method to create MaterialEntity based on resource, amount, and quality
    private MaterialEstimator createMaterial(Long materialId,Long inputId, String resourceName, double cost, String quality) {
        double adjustedCost = adjustCostForQuality(cost, quality);
        return new MaterialEstimator(materialId, inputId, resourceName, "Quantity based on material", quality, adjustedCost);
    }

    // Adjust cost based on material quality (Basic, Premium, UltraPremium)
    private double adjustCostForQuality(double cost, String quality) {
        switch (quality.toLowerCase()) {
            case "premium":
                return cost * 1.2; // 20% extra for premium quality
            case "ultrapremium":
                return cost * 1.5; // 50% extra for ultra premium quality
            case "basic":
            default:
                return cost; // No change for basic quality
        }
    }

    // Method to fetch total cost from CostEstimator microservice
    private Double fetchTotalCostFromCostEstimator(Long inputId) {
        // Make a request to the CostEstimator service to get the total cost
        CostEstimateDto costEstimateDto = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/cost-estimates/calculate/" + inputId) // Endpoint in CostEstimator to fetch total cost
                .retrieve()
                .bodyToMono(CostEstimateDto.class) // Deserialize the response to CostEstimateDto
                .block(); // Block to wait for the response (you can handle it asynchronously if needed)
    
        // Check if the response is valid and return the totalCost
        if (costEstimateDto != null && costEstimateDto.getTotalCost() != null) {
            return costEstimateDto.getTotalCost(); // Return the totalCost value from the CostEstimateDto
        } else {
            throw new RuntimeException("Failed to fetch valid total cost from CostEstimator service");
        }
    }

    // DTO to map the response from CostEstimator service
    private static class CostEstimateDto {
        private Double totalCost;

        public Double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(Double totalCost) {
            this.totalCost = totalCost;
        }
    }
}
