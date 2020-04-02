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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;
    private final ContactService contactService;
    private final UserService userService;

    public ReportController(ReportService reportService, ContactService contactService, UserService userService) {
        this.reportService = reportService;
        this.contactService = contactService;
        this.userService = userService;
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
                         @CurrentUser UserPrincipal userPrincipal)
    {
        Contact contact = contactService.findById(contactId);
        User user = userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        report.setId_report(null);
        report.setId_contact(contact);
        report.setId_user(user);

        contact.getReportList().add(report);
        user.getReportList().add(report);

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
