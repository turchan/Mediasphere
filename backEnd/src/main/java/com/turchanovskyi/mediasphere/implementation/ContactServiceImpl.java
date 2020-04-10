package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.exception.ResourceNotFoundException;
import com.turchanovskyi.mediasphere.model.Contact;
import com.turchanovskyi.mediasphere.model.Sphere;
import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.repository.ContactRepository;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;
import com.turchanovskyi.mediasphere.service.ContactService;
import com.turchanovskyi.mediasphere.service.SphereService;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.stereotype.Service;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final UserService userService;
    private final SphereService sphereService;

    public ContactServiceImpl(ContactRepository contactRepository, UserService userService, SphereService sphereService) {
        this.contactRepository = contactRepository;
        this.userService = userService;
        this.sphereService = sphereService;
    }

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact create(Contact contact, @CurrentUser UserPrincipal userPrincipal, Long sphereId) {

        User user = userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Sphere sphere = sphereService.findById(sphereId);

        contact = new Contact.Builder(null, user)
                .setName(contact.getName())
                .setSurname(contact.getSurname())
                .setInformation(contact.getInformation())
                .setPhone(contact.getPhone())
                .setWorkplace(contact.getWorkplace())
                .setPosition(contact.getPosition())
                .setLocation(contact.getLocation())
                .setCountry(contact.getCountry())
                .setCity(contact.getCity())
                .setPrice(contact.getPrice())
                .build();

        contact.getSphereList().add(sphere);

        user.getContactList().add(contact);

        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
