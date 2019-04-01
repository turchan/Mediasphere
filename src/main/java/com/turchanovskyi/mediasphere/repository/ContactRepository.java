package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
