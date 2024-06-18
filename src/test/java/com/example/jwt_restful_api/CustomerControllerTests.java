package com.example.jwt_restful_api;

import com.example.jwt_restful_api.controller.CustomerController;
import com.example.jwt_restful_api.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerControllerTests {

    @Autowired
    CustomerController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void testCRUD() {
        String expectedUsername = "test";
        String expectedPassword = "pass";
        String expectedRoles = "ROLE_USER";
        Customer expectedCustomer = new Customer(0, expectedUsername, expectedPassword, expectedRoles);
        Customer actualCustomer = controller.addCustomer(expectedCustomer);

        assertEquals(expectedUsername, actualCustomer.getUsername());
        assertEquals(expectedRoles, actualCustomer.getRoles());

        controller.deleteCustomerById(actualCustomer.getId());


    }

}
