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
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Iterable<Report> getAll()
    {
        return reportService.findAll();
    }

    @GetMapping("/{reportId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Report getMaterial(@PathVariable Long reportId)
    {
        return reportService.findById(reportId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{contactId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Report create(@RequestBody Report report, @PathVariable Long contactId,
                         @CurrentUser UserPrincipal userPrincipal) {

        reportService.create(report, contactId, userPrincipal);

        return report;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Report update(@RequestBody Report report)
    {
        reportService.update(report);

        return report;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{reportId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long reportId)
    {
        reportService.deleteById(reportId);
    }
}
