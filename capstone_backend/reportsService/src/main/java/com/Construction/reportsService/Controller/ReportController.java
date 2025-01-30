package com.Construction.reportsService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Construction.reportsService.Dto.ReportResponseDto;
import com.Construction.reportsService.Service.PdfDownloader;
import com.Construction.reportsService.Service.ReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private PdfDownloader pdfDownloader;

    @GetMapping("/{inputId}")
    public ResponseEntity<ReportResponseDto> generateReport(@PathVariable Long inputId) {
        return ResponseEntity.ok(reportService.generateReport(inputId));
    }

    @GetMapping("/{inputId}/pdf")
    public ResponseEntity<byte[]> generatePdf(@PathVariable Long inputId) {
        ReportResponseDto reportData = reportService.generateReport(inputId);
        
        if (reportData == null) {
            return ResponseEntity.notFound().build(); // Handle missing reports
        }

        byte[] pdfBytes = pdfDownloader.generatePdfReport(reportData); // Use instance method

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "report.pdf");
        headers.setContentType(MediaType.APPLICATION_PDF);

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }
}

