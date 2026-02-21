package com.saniya.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SoftwareEngineerServiceTest {

    private SoftwareEngineerRepository repository;
    private SoftwareEngineerService service;

    @BeforeEach
    void setUp() {
        repository = mock(SoftwareEngineerRepository.class);
        service = new SoftwareEngineerService(repository);
    }

    @Test
    void testGetAllSoftwareEngineers() {
        SoftwareEngineer engineer = new SoftwareEngineer(1, "Alex", "Java");
        when(repository.findAll()).thenReturn(List.of(engineer));

        List<SoftwareEngineer> result = service.getAllSoftwareEngineers();

        assertEquals(1, result.size());
        assertEquals("Alex", result.get(0).getName());
    }

    @Test
    void testGetSoftwareEngineerById() {
        SoftwareEngineer engineer = new SoftwareEngineer(1, "Alex", "Java");
        when(repository.findById(1)).thenReturn(Optional.of(engineer));

        SoftwareEngineer result = service.getSoftwareEngineerById(1);

        assertEquals("Alex", result.getName());
    }

    @Test
    void testGetSoftwareEngineerById_NotFound() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            service.getSoftwareEngineerById(1);
        });
    }
}