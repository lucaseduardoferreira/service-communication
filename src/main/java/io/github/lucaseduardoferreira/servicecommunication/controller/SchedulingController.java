package io.github.lucaseduardoferreira.servicecommunication.controller;

import io.github.lucaseduardoferreira.servicecommunication.api.SchedulingApi;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.mapper.SchedulingMapper;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import io.github.lucaseduardoferreira.servicecommunication.service.SchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduling")
@RequiredArgsConstructor
public class SchedulingController implements SchedulingApi {

    private final SchedulingMapper mapper;
    private final SchedulingService service;

    @Override
    public ResponseEntity<SchedulingResponse> create(SchedulingRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.fromResponse(service.save(mapper.fromRequest(request))));
    }

    @Override
    public ResponseEntity<Page<SchedulingResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable).map(mapper::fromResponse));
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

    @Override
    public void delete(Long id) {
        service.delete(id);
        ResponseEntity.status(HttpStatus.OK).build();
    }
}
