package com.dj.feesms.service;

import com.dj.feesms.model.Fees;
import com.dj.feesms.repository.FeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeesService {

    private FeesRepository feesRepository;

    public FeesService(FeesRepository feesRepository) {
        this.feesRepository = feesRepository;
    }

    public List<Fees> getPaidStudentFees(Long studentId, boolean paid) {
        return feesRepository.findByStudentIdAndIsPaid(studentId,paid);
    }

    public void savePayment(Fees fees) {
        feesRepository.save(fees);
    }

    public Optional<Fees> findById(Long id) {
        return feesRepository.findById(id);
    }
}
