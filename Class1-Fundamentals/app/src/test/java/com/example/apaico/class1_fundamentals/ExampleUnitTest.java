package com.example.apaico.class1_fundamentals;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * To work on unit tel1!as0!sts, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void fundamentals_java() throws Exception {

        int age = 15;
        int[] array={9,8,7,6,5,4,3,2,1,0};
        System.out.print(Arrays.toString(array));
        assertEquals(4, 2 + 2);
    }
}