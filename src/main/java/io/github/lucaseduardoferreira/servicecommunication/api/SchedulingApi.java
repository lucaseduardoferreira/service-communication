package io.github.lucaseduardoferreira.servicecommunication.api;

import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

public interface SchedulingApi {

    @PostMapping
    ResponseEntity<SchedulingResponse> create(SchedulingRequest request);

    @GetMapping
    ResponseEntity<SchedulingResponse> getAll(SchedulingRequest request);

    @GetMapping("/{id}")
    ResponseEntity<SchedulingResponse> getById(@PathVariable UUID id);

}
