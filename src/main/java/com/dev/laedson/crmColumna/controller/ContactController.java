package com.dev.laedson.crmColumna.controller;

import com.dev.laedson.crmColumna.dto.ContactIdDto;
import com.dev.laedson.crmColumna.dto.CreateContactDto;
import com.dev.laedson.crmColumna.model.Contact;
import com.dev.laedson.crmColumna.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody CreateContactDto dto) {
        var contactId = contactService.createContact(dto);

        return ResponseEntity.created(URI.create("/home" + contactId)).body(contactId);
    }

    @GetMapping
    public Contact getContactById(@RequestBody ContactIdDto dto) {

        return contactService.getContactById(dto);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody ContactIdDto dto) {
        contactService.deleteContact(dto);
        return ResponseEntity.ok(null);
    }
}
