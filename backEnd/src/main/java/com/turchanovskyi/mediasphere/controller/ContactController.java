package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.model.Contact;
import com.turchanovskyi.mediasphere.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public Iterable<Contact> getAll()
    {
        return contactService.findAll();
    }

    @GetMapping("/{contactId}")
    public Contact getContact(@PathVariable Long contactId)
    {
        return contactService.findById(contactId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Contact createContact(@RequestBody Contact contact)
    {
        contact.setId_contact(null);

        contactService.save(contact);

        return contact;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Contact updateContact(@RequestBody Contact contact)
    {
        contactService.save(contact);

        return contact;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{contactId}")
    public void delete(@PathVariable Long contactId)
    {
        contactService.deleteById(contactId);
    }

}
