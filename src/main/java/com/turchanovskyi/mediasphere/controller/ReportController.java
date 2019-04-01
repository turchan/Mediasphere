package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.model.Report;
import com.turchanovskyi.mediasphere.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public Iterable<Report> getAll()
    {
        return reportService.findAll();
    }

    @GetMapping("/{reportId}")
    public Report getMaterial(@PathVariable Long reportId)
    {
        return reportService.findById(reportId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Report create(@RequestBody Report report)
    {
        report.setId_report(null);

        reportService.save(report);

        return report;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Report update(@RequestBody Report report)
    {
        reportService.save(report);

        return report;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{reportId}")
    public void delete(@PathVariable Long reportId)
    {
        reportService.deleteById(reportId);
    }
}
