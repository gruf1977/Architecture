package com.example.myarchitecture;

import com.example.myarchitecture.interactor.MainInteractor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    private MainInteractor mainInteractor;

    @Before
    public void setUp() {
        mainInteractor = new MainInteractor();
    }

    @Test
    public void testFirst() {
        assertFalse(mainInteractor.showDialog(1));
    }

    @Test
    public void testTwo() {
        assertTrue(mainInteractor.showDialog(2));
    }

    @Test
    public void testThree() {
        assertFalse(mainInteractor.showDialog(3));
    }

    @Test
    public void testFour() {
        assertFalse(mainInteractor.showDialog(4));
    }

    @Test
    public void testFive() {
        assertFalse(mainInteractor.showDialog(5));
    }

    @Test
    public void testSix() {
        assertTrue(mainInteractor.showDialog(6));
    }

    @Test
    public void testSeven() {
        assertFalse(mainInteractor.showDialog(7));
    }

    @After
    public void tearDown() {
        mainInteractor = null;
    }
}