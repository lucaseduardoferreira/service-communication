package io.github.lucaseduardoferreira.servicecommunication.api.dto.request;

import io.github.lucaseduardoferreira.servicecommunication.domain.Message;
import io.github.lucaseduardoferreira.servicecommunication.domain.Recipient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingRequest {

    @NotNull
    private Message message;

    @NotNull
    private Recipient recipient;

    @NotNull
    private LocalDateTime shippingDate;

    @NotNull
    private String communication;
}
