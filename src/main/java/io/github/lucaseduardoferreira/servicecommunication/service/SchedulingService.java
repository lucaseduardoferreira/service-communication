package io.github.lucaseduardoferreira.servicecommunication.service;

import io.github.lucaseduardoferreira.servicecommunication.domain.Scheduling;

import java.util.List;
import java.util.Optional;

public interface SchedulingService {

    Scheduling save(Scheduling scheduling);

    Optional<Scheduling> getById(Long id);

    Optional<Scheduling> update(Long id, Scheduling scheduling);

    List<Scheduling> getAll();

}
