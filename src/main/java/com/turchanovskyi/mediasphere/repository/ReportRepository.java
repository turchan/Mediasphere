package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
