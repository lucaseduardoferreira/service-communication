package io.github.lucaseduardoferreira.servicecommunication.api;

import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface SaveSchedulingApi {

    @PostMapping
    ResponseEntity<SchedulingResponse> create(SchedulingRequest request);

}
