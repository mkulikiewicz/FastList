package com.mkul.example.object;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleObjectTest {

    @Test
    public void testEqualsMethodReturnTrue() {
        ExampleObject exampleObject = new ExampleObject("10");
        ExampleObject sameAsExampleObject = new ExampleObject("10");

        assertThat(exampleObject.equals(sameAsExampleObject)).isTrue();
    }

    @Test
    public void testEqualsMethodReturnFalse() {
        ExampleObject exampleObject = new ExampleObject("10");
        ExampleObject differentAsExampleObject = new ExampleObject("20");

        assertThat(exampleObject.equals(differentAsExampleObject)).isFalse();
    }

    @Test
    public void testToString()
    {
        ExampleObject exampleObject = new ExampleObject("10");

        assertThat(exampleObject.toString()).isEqualTo(10);
    }
}
