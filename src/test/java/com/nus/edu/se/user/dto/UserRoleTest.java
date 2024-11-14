package com.nus.edu.se.user.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleTest {

    @Test
    void testEnumValues() {
        // Verify the expected values are present
        UserRole[] roles = UserRole.values();
        assertEquals(4, roles.length, "The UserRole enum should have 4 values");
        assertArrayEquals(
                new UserRole[]{UserRole.CUSTOMER, UserRole.RESTAURANT_STAFF, UserRole.DELIVERY_STAFF, UserRole.NA},
                roles,
                "The UserRole enum values are incorrect"
        );
    }

    @Test
    void testValueOf() {
        // Verify the valueOf method for each enum value
        assertEquals(UserRole.CUSTOMER, UserRole.valueOf("CUSTOMER"));
        assertEquals(UserRole.RESTAURANT_STAFF, UserRole.valueOf("RESTAURANT_STAFF"));
        assertEquals(UserRole.DELIVERY_STAFF, UserRole.valueOf("DELIVERY_STAFF"));
        assertEquals(UserRole.NA, UserRole.valueOf("NA"));

        // Verify that an invalid name throws an exception
        assertThrows(IllegalArgumentException.class, () -> UserRole.valueOf("INVALID_ROLE"));
    }
}
