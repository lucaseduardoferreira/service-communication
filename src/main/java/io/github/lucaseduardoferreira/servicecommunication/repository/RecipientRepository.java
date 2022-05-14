package io.github.lucaseduardoferreira.servicecommunication.repository;

import io.github.lucaseduardoferreira.servicecommunication.domain.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipientRepository extends JpaRepository<Recipient, UUID> {

}
