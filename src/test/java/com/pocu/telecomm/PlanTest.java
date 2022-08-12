package com.pocu.telecomm;

import com.pocu.telecomm.entity.Plan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlanTest {
    private Plan plan;




    @Test
    void nameMustNotBeNull() {
        assertThatThrownBy(() -> plan = new Plan("", 100,"23", 24)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void priceMustNotBeNull() {
        assertThatThrownBy(() -> plan = new Plan("asdf", -100,"23", 24)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void dataSizeMustNotBeNull() {
        assertThatThrownBy(() -> plan = new Plan("asdf", -100,"23", -24)).isInstanceOf(RuntimeException.class);
    }



}
