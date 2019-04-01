package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.Report;

public interface ReportService {

    Iterable<Report> findAll();
    Report findById(Long id);
    Report save(Report report);
    void deleteById(Long id);
}
