package io.github.lucaseduardoferreira.servicecommunication.api;

import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SchedulingApi {

    @PostMapping
    ResponseEntity<SchedulingResponse> create(@RequestBody SchedulingRequest request);

    @GetMapping
    ResponseEntity<List<SchedulingResponse>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<SchedulingResponse> getById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<SchedulingResponse> update(@PathVariable Long id, @RequestBody SchedulingRequest request);

}
