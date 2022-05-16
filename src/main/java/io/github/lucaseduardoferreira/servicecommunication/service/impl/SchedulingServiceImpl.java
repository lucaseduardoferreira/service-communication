package io.github.lucaseduardoferreira.servicecommunication.service.impl;

import io.github.lucaseduardoferreira.servicecommunication.domain.Scheduling;
import io.github.lucaseduardoferreira.servicecommunication.repository.MessageRepository;
import io.github.lucaseduardoferreira.servicecommunication.repository.RecipientRepository;
import io.github.lucaseduardoferreira.servicecommunication.repository.SchedulingRepository;
import io.github.lucaseduardoferreira.servicecommunication.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        scheduling.setSent(Boolean.FALSE);
        scheduling.setCreatedAt(LocalDateTime.now());
        return schedulingRepository.save(scheduling);
    }

    @Override
    public Optional<Scheduling> getById(Long id) {
        return schedulingRepository.findById(id);
    }

    @Override
    public Optional<Scheduling> update(Long id, Scheduling scheduling) {
        var schedulingFounded = schedulingRepository.findById(id);
        if (schedulingFounded.isPresent()) {
            var message = scheduling.getMessage();

            var recipient = scheduling.getRecipient();

            schedulingFounded.get().setUpdatedAt(LocalDateTime.now());
            schedulingFounded.get().setSent(scheduling.getSent());
            schedulingFounded.get().setCommunication(scheduling.getCommunication());
            schedulingFounded.get().setMessage(message);
            schedulingFounded.get().setRecipient(recipient);
            return Optional.of(schedulingRepository.save(schedulingFounded.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<Scheduling> getAll() {
        return schedulingRepository.findAll();
    }
}
