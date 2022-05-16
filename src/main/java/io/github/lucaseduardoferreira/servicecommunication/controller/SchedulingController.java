package io.github.lucaseduardoferreira.servicecommunication.controller;

import io.github.lucaseduardoferreira.servicecommunication.api.SchedulingApi;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.mapper.SchedulingMapper;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import io.github.lucaseduardoferreira.servicecommunication.service.SchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scheduling")
@RequiredArgsConstructor
public class SchedulingController implements SchedulingApi {

    private final SchedulingMapper mapper;
    private final SchedulingService service;

    @Override
    public ResponseEntity<SchedulingResponse> create(SchedulingRequest request) {
        return ResponseEntity.ok(mapper.fromResponse(service.save(mapper.fromRequest(request))));
    }

    @Override
    public ResponseEntity<List<SchedulingResponse>>getAll() {
        return ResponseEntity.ok(service.getAll().stream().map(mapper::fromResponse).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<SchedulingResponse> getById(Long id) {
        var scheduling = service.getById(id);
        return scheduling
                .map(s -> {
                            var schedulingResponse = mapper.fromResponse(s);
                            return ResponseEntity.ok(schedulingResponse);
                        }

                ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<SchedulingResponse> update(Long id, SchedulingRequest request) {
        var scheduling = service.update(id, mapper.fromRequest(request));
        return scheduling
                .map(s -> {
                            var schedulingResponse = mapper.fromResponse(s);
                            return ResponseEntity.ok(schedulingResponse);
                        }

                ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
