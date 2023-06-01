package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTest {

    @Disabled("Disable the test until ticket is resolved")
    @Test
    void basicTest() {
        System.out.println("Basic Test Disabled");
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testRunOnMacOnly() {
        System.out.println("Enable on Mac OS Only");
    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testRunOnLinuxOnly() {
        System.out.println("Enable on Linux Only");
    }

    @EnabledOnOs({OS.LINUX, OS.MAC, OS.WINDOWS})
    @Test
    void testRunOnLinuxMacAndWindowsOnly() {
        System.out.println("Enable on Linux, Mac And Windows Only");
    }

    @EnabledOnJre(JRE.JAVA_17)
    @Test
    void testRunOnJRE17() {
        System.out.println("Test runs on Java 17 only");
    }

    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_18)
    @Test
    void testRunOnJavaRange() {
        System.out.println("Test runs on Java 11 - 18");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "LUV2CODE_ENV", matches = "DEV")
    void testOnlyForDevEnvironment() {
        System.out.println("Executes for dev environment only");
    }

    @Test
    @EnabledIfSystemProperty(named = "LUV2CODE_SYS_PROP", matches = "CI_CD_DEPLOY")
    void testOnlyForSystemProperty() {
        System.out.println("Executes for CI CD only");
    }
}
