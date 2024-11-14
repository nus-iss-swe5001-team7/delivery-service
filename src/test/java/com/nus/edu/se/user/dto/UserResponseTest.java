package com.nus.edu.se.user.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsersResponseTest {

    @Test
    void testNoArgsConstructor() {
        // Create an object using the no-args constructor
        UsersResponse userResponse = new UsersResponse();

        // Verify that all fields are null or default values
        assertNull(userResponse.getUserId());
        assertNull(userResponse.getName());
        assertNull(userResponse.getPassword());
        assertNull(userResponse.getEmail());
        assertNull(userResponse.getRole());
    }

    @Test
    void testAllArgsConstructor() {
        // Test data
        UUID userId = UUID.randomUUID();
        String name = "John Doe";
        String password = "securePassword";
        String email = "john.doe@example.com";
        String role = "CUSTOMER";

        // Create an object using the all-args constructor
        UsersResponse userResponse = new UsersResponse(userId, name, password, email, role);

        // Verify that all fields are correctly initialized
        assertEquals(userId, userResponse.getUserId());
        assertEquals(name, userResponse.getName());
        assertEquals(password, userResponse.getPassword());
        assertEquals(email, userResponse.getEmail());
        assertEquals(role, userResponse.getRole());
    }

    @Test
    void testSettersAndGetters() {
        // Create an object
        UsersResponse userResponse = new UsersResponse();

        // Test data
        UUID userId = UUID.randomUUID();
        String name = "Jane Doe";
        String password = "strongPassword";
        String email = "jane.doe@example.com";
        String role = "RESTAURANT_STAFF";

        // Set fields using setters
        userResponse.setUserId(userId);
        userResponse.setName(name);
        userResponse.setPassword(password);
        userResponse.setEmail(email);
        userResponse.setRole(role);

        // Verify fields using getters
        assertEquals(userId, userResponse.getUserId());
        assertEquals(name, userResponse.getName());
        assertEquals(password, userResponse.getPassword());
        assertEquals(email, userResponse.getEmail());
        assertEquals(role, userResponse.getRole());
    }
}
