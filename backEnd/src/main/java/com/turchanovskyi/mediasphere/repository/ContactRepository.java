package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
