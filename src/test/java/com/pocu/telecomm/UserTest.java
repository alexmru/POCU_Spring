package com.pocu.telecomm;

import com.pocu.telecomm.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserTest {
    private User user;




    @Test
    void ageMustNotBeNegative() {
        assertThatThrownBy(() -> user = new User("dsf","asdf",-20)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void usernameMustNotBeNull() {
        assertThatThrownBy(() -> user = new User("","asdf",20)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void addressMustNotBeNull() {
        assertThatThrownBy(() -> user = new User("asdf","",20)).isInstanceOf(RuntimeException.class);
    }

}
