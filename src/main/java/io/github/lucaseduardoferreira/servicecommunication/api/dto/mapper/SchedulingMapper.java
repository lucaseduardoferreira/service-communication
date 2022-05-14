package io.github.lucaseduardoferreira.servicecommunication.api.dto.mapper;


import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.response.SchedulingResponse;
import io.github.lucaseduardoferreira.servicecommunication.domain.Scheduling;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface SchedulingMapper {

    Scheduling fromRequest(SchedulingRequest schedulingRequest);

    SchedulingResponse fromResponse(Scheduling scheduling);

}
