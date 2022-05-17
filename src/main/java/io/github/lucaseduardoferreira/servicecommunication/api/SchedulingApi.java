package io.github.lucaseduardoferreira.servicecommunication.api;

import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface SchedulingApi {

    @PostMapping
    ResponseEntity<SchedulingResponse> create(@RequestBody @Valid SchedulingRequest request);

    @GetMapping
    ResponseEntity<Page<SchedulingResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<SchedulingResponse> getById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<SchedulingResponse> update(@PathVariable Long id, @RequestBody @Valid SchedulingRequest request);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
