package com.rockman.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class Test1 {

    @Test
    public void testsWork() {
        assertThat("Tests work", true, is(true));
    }

}
