package basic.data.structures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExampleTest {

    private List listForTesting;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    @Test
    void arrayListTest() {
        listForTesting = new ArrayList();
    }

    @Test
    void linkedListTest() {
        listForTesting = new LinkedList();
    }

    @Test
    void vectorTest() {

    }

    @Test
    void stackTest() {

    }
}