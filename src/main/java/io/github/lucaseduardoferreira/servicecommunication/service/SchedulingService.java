package io.github.lucaseduardoferreira.servicecommunication.service;

import io.github.lucaseduardoferreira.servicecommunication.domain.Scheduling;

import java.util.Optional;
import java.util.UUID;

public interface SchedulingService {

    Scheduling save(Scheduling scheduling);

    Optional<Scheduling> getById(UUID id);


}
