package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.exception.ResourceNotFoundException;
import com.turchanovskyi.mediasphere.model.Contact;
import com.turchanovskyi.mediasphere.model.Report;
import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;
import com.turchanovskyi.mediasphere.service.ContactService;
import com.turchanovskyi.mediasphere.service.ReportService;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reports")
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
    @PostMapping("/create/{contactId}")
    public Report create(@RequestBody Report report, @PathVariable Long contactId,
                         @CurrentUser UserPrincipal userPrincipal) {

        reportService.create(report, contactId, userPrincipal);

        return report;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Report update(@RequestBody Report report)
    {
        reportService.update(report);

        return report;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{reportId}")
    public void delete(@PathVariable Long reportId)
    {
        reportService.deleteById(reportId);
    }
}
