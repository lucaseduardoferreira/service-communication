package io.github.lucaseduardoferreira.servicecommunication.controller;

import io.github.lucaseduardoferreira.servicecommunication.api.SchedulingApi;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.mapper.SchedulingMapper;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import io.github.lucaseduardoferreira.servicecommunication.service.SchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/scheduling")
@RequiredArgsConstructor
public class SchedulingController implements SchedulingApi {

    private final SchedulingMapper mapper;
    private final SchedulingService service;

    @Override
    public ResponseEntity<SchedulingResponse> create(@RequestBody SchedulingRequest request) {
        return ResponseEntity.ok(mapper.fromResponse(service.save(mapper.fromRequest(request))));
    }

    @Override
    public ResponseEntity<SchedulingResponse> getAll(SchedulingRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<SchedulingResponse> getById(UUID id) {
        var scheduling = service.getById(id);
        return scheduling
                .map(s -> {
                            var schedulingResponse = mapper.fromResponse(s);
                            return ResponseEntity.ok(schedulingResponse);
                        }

                ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
