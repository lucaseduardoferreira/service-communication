package io.github.lucaseduardoferreira.servicecommunication.api.dto.request;

import io.github.lucaseduardoferreira.servicecommunication.domain.Message;
import io.github.lucaseduardoferreira.servicecommunication.domain.Recipient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingRequest {

    private Message message;
    private Recipient recipient;
    private LocalDateTime shippingDate;

    private String communication;
}
