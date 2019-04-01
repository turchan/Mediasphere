package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.Contact;

public interface ContactService {

    Iterable<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact id);
    void deleteById(Long id);
}
