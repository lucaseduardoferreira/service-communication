package io.github.lucaseduardoferreira.servicecommunication.repository;

import io.github.lucaseduardoferreira.servicecommunication.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

}
