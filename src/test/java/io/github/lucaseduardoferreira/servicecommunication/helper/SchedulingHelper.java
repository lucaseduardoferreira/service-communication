package io.github.lucaseduardoferreira.servicecommunication.helper;

import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.domain.Message;
import io.github.lucaseduardoferreira.servicecommunication.domain.Recipient;

import java.time.LocalDateTime;

public class SchedulingHelper {

    public static SchedulingRequest getSchedulingRequest() {
        var message = Message.builder().title("Title Test").body("Body Test").build();
        var recipient = Recipient.builder().email("teste@email.com").phone("3599999999").name("Name Test").build();
        return SchedulingRequest.builder()
                .communication("EMAIL")
                .message(message)
                .recipient(recipient)
                .shippingDate(LocalDateTime.now().plusDays(1L))
                .build();
    }
}
