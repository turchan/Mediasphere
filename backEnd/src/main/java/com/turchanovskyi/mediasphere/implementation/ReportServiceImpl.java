package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.model.Report;
import com.turchanovskyi.mediasphere.repository.ReportRepository;
import com.turchanovskyi.mediasphere.service.ReportService;
import org.springframework.stereotype.Service;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Iterable<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report findById(Long id) {
        return reportRepository.findById(id).get();
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }
}
