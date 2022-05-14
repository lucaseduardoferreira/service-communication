package io.github.lucaseduardoferreira.servicecommunication.service.impl;

import io.github.lucaseduardoferreira.servicecommunication.domain.Scheduling;
import io.github.lucaseduardoferreira.servicecommunication.repository.MessageRepository;
import io.github.lucaseduardoferreira.servicecommunication.repository.RecipientRepository;
import io.github.lucaseduardoferreira.servicecommunication.repository.SchedulingRepository;
import io.github.lucaseduardoferreira.servicecommunication.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class SchedulingServiceImpl implements SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    @Override
    public Scheduling save(Scheduling scheduling) {
        messageRepository.save(scheduling.getMessage());
        recipientRepository.save(scheduling.getRecipient());
        return schedulingRepository.save(scheduling);
    }

    @Override
    public Optional<Scheduling> getById(UUID id) {
        return schedulingRepository.findById(id);
    }
}
