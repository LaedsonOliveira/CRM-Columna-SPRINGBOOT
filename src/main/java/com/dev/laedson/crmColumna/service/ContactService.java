package com.dev.laedson.crmColumna.service;

import com.dev.laedson.crmColumna.dto.ContactIdDto;
import com.dev.laedson.crmColumna.dto.CreateContactDto;
import com.dev.laedson.crmColumna.model.Contact;
import com.dev.laedson.crmColumna.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContactService {


    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public UUID createContact(CreateContactDto dto) {

        var entity = new Contact(
                dto.name(),
                dto.telefone(),
                dto.email(),
                dto.enterprise(),
                dto.role()
        );

        var contact = contactRepository.save(entity);

        return contact.getContactId();
    }

    public Contact getContactById(ContactIdDto dto) {

        var contact = contactRepository.findById(dto.contactId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return contact;
    }

    public void deleteContact(ContactIdDto dto) {

        var contact = contactRepository.findById(dto.contactId()).orElseThrow(() -> new RuntimeException("Contact not found"));

        contactRepository.deleteById(contact.getContactId());
    }


}
