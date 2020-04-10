package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.exception.ResourceNotFoundException;
import com.turchanovskyi.mediasphere.model.Contact;
import com.turchanovskyi.mediasphere.model.Report;
import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.repository.ReportRepository;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;
import com.turchanovskyi.mediasphere.service.ContactService;
import com.turchanovskyi.mediasphere.service.ReportService;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.stereotype.Service;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ContactService contactService;
    private final UserService userService;

    public ReportServiceImpl(ReportRepository reportRepository, ContactService contactService, UserService userService) {
        this.reportRepository = reportRepository;
        this.contactService = contactService;
        this.userService = userService;
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
    public Report create(Report report, Long contactId, @CurrentUser UserPrincipal userPrincipal) {

        Contact contact = contactService.findById(contactId);
        User user = userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        report = new Report.Builder(null, user, contact)
                .setTitle(report.getTitle())
                .setContent(report.getContent())
                .build();

        contact.getReportList().add(report);
        user.getReportList().add(report);

        return reportRepository.save(report);
    }

    @Override
    public Report update(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }
}
