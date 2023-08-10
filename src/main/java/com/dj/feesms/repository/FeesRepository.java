package com.dj.feesms.repository;

import com.dj.feesms.model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Long> {
    List<Fees> findByStudentIdAndIsPaid(Long studentId, boolean isPaid);
}