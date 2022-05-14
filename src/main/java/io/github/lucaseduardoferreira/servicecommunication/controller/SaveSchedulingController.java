package io.github.lucaseduardoferreira.servicecommunication.controller;

import io.github.lucaseduardoferreira.servicecommunication.api.SaveSchedulingApi;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.mapper.SchedulingMapper;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import io.github.lucaseduardoferreira.servicecommunication.service.SaveSchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduling")
@RequiredArgsConstructor
public class SaveSchedulingController implements SaveSchedulingApi {

    private final SchedulingMapper mapper;
    private final SaveSchedulingService service;

    @Override
    public ResponseEntity<SchedulingResponse> create(@RequestBody SchedulingRequest request) {
        System.out.println(mapper.fromRequest(request));
        return ResponseEntity.ok(mapper.fromResponse(service.save(mapper.fromRequest(request))));
    }
}
