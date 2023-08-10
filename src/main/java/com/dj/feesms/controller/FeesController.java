package com.dj.feesms.controller;

import com.dj.feesms.model.Fees;
import com.dj.feesms.service.FeesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fees")
public class FeesController {
    private final FeesService feesService;

    public FeesController(FeesService feesService) {
        this.feesService = feesService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<Fees>> getPaidStudentFees(@PathVariable Long studentId) {
        List<Fees> feesList = feesService.getPaidStudentFees(studentId,true);
        return new ResponseEntity<>(feesList, HttpStatus.OK);
    }

    @PostMapping("/pay/{id}")
    public ResponseEntity<String> payFees(@PathVariable Long id) {
        Optional<Fees> optionalFees = feesService.findById(id);
        if (optionalFees.isPresent()) {
            Fees fees = optionalFees.get();
            fees.setPaid(true);
            feesService.savePayment(fees);
            return new ResponseEntity<>("Fees paid successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fees not found", HttpStatus.NOT_FOUND);
    }
}
