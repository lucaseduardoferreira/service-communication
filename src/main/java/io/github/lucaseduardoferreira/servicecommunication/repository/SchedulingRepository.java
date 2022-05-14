package io.github.lucaseduardoferreira.servicecommunication.repository;

import io.github.lucaseduardoferreira.servicecommunication.domain.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchedulingRepository extends JpaRepository<Scheduling, UUID> {

}
