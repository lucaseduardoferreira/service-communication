package io.github.lucaseduardoferreira.servicecommunication.repository;

import io.github.lucaseduardoferreira.servicecommunication.domain.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {

}
