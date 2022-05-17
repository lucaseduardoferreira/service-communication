package io.github.lucaseduardoferreira.servicecommunication.service;

import io.github.lucaseduardoferreira.servicecommunication.domain.Scheduling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SchedulingService {

    Scheduling save(Scheduling scheduling);

    Optional<Scheduling> getById(Long id);

    Optional<Scheduling> update(Long id, Scheduling scheduling);

    Page<Scheduling> getAll(Pageable pageable);

    void delete(Long id);

}
