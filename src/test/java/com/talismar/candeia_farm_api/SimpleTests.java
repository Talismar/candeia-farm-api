/*
 * Copyright (c) 2024.
 * @author Talismar F. Costa
 */

package com.talismar.candeia_farm_api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SimpleTests {
    @Test
    @EnabledOnOs(OS.LINUX)
    void validateOSTest() {
        // This tests run only system is linux
    }

    @DisplayName("Name of test")
    @Test
    @Disabled
    @EnabledIfEnvironmentVariable(named = "talismar", matches = "USER")
    void testTwo() {

    }
}
