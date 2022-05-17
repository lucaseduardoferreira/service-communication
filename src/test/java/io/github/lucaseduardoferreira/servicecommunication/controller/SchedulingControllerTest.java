package io.github.lucaseduardoferreira.servicecommunication.controller;

import io.github.lucaseduardoferreira.servicecommunication.api.SchedulingApi;
import io.github.lucaseduardoferreira.servicecommunication.api.dto.request.SchedulingRequest;
import io.github.lucaseduardoferreira.servicecommunication.helper.SchedulingHelper;
import io.github.lucaseduardoferreira.servicecommunication.repository.SchedulingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Testcontainers
class SchedulingControllerTest {

    public static final long ID_NOT_EXISTS = 9999999L;
    @Container
    public static PostgreSQLContainer container =
            new PostgreSQLContainer().withUsername("admin-teste").withPassword("pass-test").withDatabaseName("test");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Autowired
    SchedulingApi schedulingApi;

    @Autowired
    SchedulingRepository schedulingRepository;

    @BeforeEach
    void deleteAll() {
        schedulingRepository.deleteAll();
    }

    @Test
    void createScheduling_whenBody_isValid() {
        SchedulingRequest scheduling = SchedulingHelper.getSchedulingRequest();

        var response = schedulingApi.create(scheduling);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void createScheduling_exception_whenBody_isNotValid() {
        SchedulingRequest scheduling = SchedulingHelper.getSchedulingRequest();
        scheduling.getMessage().setBody(null);

        assertThatThrownBy(() -> schedulingApi.create(scheduling))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void getAll_paginated_whenScheduling_exists() {
        SchedulingRequest scheduling = SchedulingHelper.getSchedulingRequest();

        var response = schedulingApi.create(scheduling);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        var responseAll = schedulingApi.getAll(Pageable.unpaged());
        assertThat(responseAll.getBody()).isNotEmpty();
        assertThat(responseAll.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void getById_whenScheduling_exists() {
        SchedulingRequest scheduling = SchedulingHelper.getSchedulingRequest();

        var responseCreate = schedulingApi.create(scheduling);
        assertThat(responseCreate.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        var body = responseCreate.getBody();
        assertThat(body).isNotNull();
        var responseFounded = schedulingApi.getById(body.getId());
        assertThat(responseFounded.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseFounded.getBody()).isNotNull();
        assertThat(responseFounded.getBody().getId()).isEqualTo(body.getId());


    }

    @Test
    void getById_whenScheduling_notExists() {
        SchedulingRequest scheduling = SchedulingHelper.getSchedulingRequest();

        var responseCreate = schedulingApi.create(scheduling);
        assertThat(responseCreate.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        var body = responseCreate.getBody();
        var responseFounded = schedulingApi.getById(ID_NOT_EXISTS);
        assertThat(responseFounded.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void update_whenScheduling_exists() {
        SchedulingRequest scheduling = SchedulingHelper.getSchedulingRequest();

        var responseCreate = schedulingApi.create(scheduling);
        assertThat(responseCreate.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        scheduling.getMessage().setTitle("Update Title");
        var body = responseCreate.getBody();
        assertThat(body).isNotNull();

        var responseUpdate = schedulingApi.update(body.getId(), scheduling);
        assertThat(responseUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);

        var bodyUpdate = responseUpdate.getBody();
        assertThat(bodyUpdate).isNotNull();
        assertThat(bodyUpdate.getMessage().getTitle()).isEqualTo("Update Title");
    }

    @Test
    void update_whenScheduling_notExists() {
        SchedulingRequest scheduling = SchedulingHelper.getSchedulingRequest();

        var responseCreate = schedulingApi.create(scheduling);
        assertThat(responseCreate.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        scheduling.getMessage().setTitle("Update Title");
        var body = responseCreate.getBody();
        assertThat(body).isNotNull();

        var responseUpdate = schedulingApi.update(ID_NOT_EXISTS, scheduling);
        assertThat(responseUpdate.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    }

    @Test
    void delete_whenScheduling_exists() {
        SchedulingRequest scheduling = SchedulingHelper.getSchedulingRequest();

        var responseCreate = schedulingApi.create(scheduling);
        assertThat(responseCreate.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        var schedulingCreated = responseCreate.getBody();
        assertThat(schedulingCreated).isNotNull();
        schedulingApi.delete(schedulingCreated.getId());

        var schedulingNotFounded = schedulingApi.getById(schedulingCreated.getId());
        assertThat(schedulingNotFounded.getBody()).isNull();

    }
}