package coop.avalonlab.guice;


import static org.assertj.core.api.Assertions.assertThat;

import coop.avalonlab.guice.test.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

class GuiceInjectorScannerTest {

    @Test
    void canFindMultipleImplementation() {

        Set<Class<TestInterface>> result = GuiceInjectorScanner
                .findImplementationsOf(TestInterface.class, TestInterface.class.getPackageName())
                .getSubClasses();

        assertThat(result).hasOnlyElementsOfTypes(TestImplementationOne.class.getClass(),
                TestImplementationTwo.class.getClass());
    }

    @Test
    void canFindOneImplementation() {

        Set<Class<TestInterface2>> result = GuiceInjectorScanner
                .findImplementationsOf(TestInterface2.class, TestInterface2.class.getPackageName())
                .getSubClasses();

        assertThat(result).hasOnlyElementsOfTypes(Test2Impl.class.getClass());
    }

}