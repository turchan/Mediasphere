package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.Contact;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;

public interface ContactService {
    Iterable<Contact> findAll();
    Contact findById(Long id);
    Contact create(Contact contact, @CurrentUser UserPrincipal userPrincipal, Long sphereId);
    Contact update(Contact contact);
    void deleteById(Long id);
}
