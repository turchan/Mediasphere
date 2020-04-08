package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.exception.ResourceNotFoundException;
import com.turchanovskyi.mediasphere.model.Contact;
import com.turchanovskyi.mediasphere.model.Purchase;
import com.turchanovskyi.mediasphere.model.Sphere;
import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;
import com.turchanovskyi.mediasphere.service.ContactService;
import com.turchanovskyi.mediasphere.service.PurchaseService;
import com.turchanovskyi.mediasphere.service.SphereService;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final UserService userService;
    private final ContactService contactService;
    private final SphereService sphereService;
    private final PurchaseService purchaseService;

    public ContactController(UserService userService, ContactService contactService, SphereService sphereService, PurchaseService purchaseService) {
        this.userService = userService;
        this.contactService = contactService;
        this.sphereService = sphereService;
        this.purchaseService = purchaseService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public Iterable<Contact> getAll() {
        return contactService.findAll();
    }

    @GetMapping("/{contactId}")
    @PreAuthorize("hasRole('USER')")
    public Contact getContact(@PathVariable Long contactId) {
        return contactService.findById(contactId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{sphereId}")
    @PreAuthorize("hasRole('USER')")
    public Contact createContact(@RequestBody Contact contact, @CurrentUser UserPrincipal userPrincipal,
                                 @PathVariable Long sphereId) {

        User user = userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Sphere sphere = sphereService.findById(sphereId);

        contact.setId_contact(null);
        contact.setId_user(user);
        contact.getSphereList().add(sphere);

        user.getContactList().add(contact);

        contactService.save(contact);

        return contact;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    @PreAuthorize("hasRole('USER')")
    public Contact updateContact(@RequestBody Contact contact) {
        contactService.save(contact);

        return contact;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/purchase/{contactId}")
    @PreAuthorize("hasRole('USER')")
    public Purchase purchase(@PathVariable Long contactId, @CurrentUser UserPrincipal userPrincipal) {
        User user = userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Contact contact = contactService.findById(contactId);

        Purchase purchase = new Purchase();
        purchase.setId_purchase(null);
        purchase.setId_user(user);
        purchase.setId_contact(contact);

        user.getPurchaseList().add(purchase);
        contact.getPurchaseList().add(purchase);

        purchaseService.save(purchase);

        return purchase;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{contactId}")
    @PreAuthorize("hasRole('USER')")
    public void delete(@PathVariable Long contactId) {
        contactService.deleteById(contactId);
    }
}
