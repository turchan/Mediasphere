package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.Report;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;

public interface ReportService {

    Iterable<Report> findAll();
    Report findById(Long id);
    Report create(Report report, Long contactId, @CurrentUser UserPrincipal userPrincipal);
    Report update(Report report);
    void deleteById(Long id);
}
