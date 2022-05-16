package io.github.lucaseduardoferreira.servicecommunication.repository;

import io.github.lucaseduardoferreira.servicecommunication.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
