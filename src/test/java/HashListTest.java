import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashListTest {


    private ArrayList arrayList;
    private LinkedList linkedList;
    private static final int ELEMENT_COUNT = 1000000;

    @BeforeMethod
    public void initArray() {
        arrayList = new ArrayList<Integer>();
        linkedList = new LinkedList<Integer>();
        addToArrayList();
        addToLinkedList();
    }

    @AfterMethod
    public void unInitArray() {
        arrayList = null;
        linkedList = null;
        System.gc();
    }


    @Test(invocationCount = 10)
    public void testAddTimeToAddingLinkedListAndArrayList() {

        long beforeMillis = System.currentTimeMillis();
        addToArrayList();
        long afterArray = System.currentTimeMillis();
        addToLinkedList();
        long afterLinked = System.currentTimeMillis();

        long howManyMillisArray = afterArray - beforeMillis;
        long howManyMillisList = afterLinked - afterArray;


//        assertThat(howManyMillisArray).isGreaterThan(howManyMillisList);
        System.out.println("LinkdeList:" + howManyMillisList + "\tArrayList:" + howManyMillisArray);
    }

    private void addToArrayList() {
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(new Integer(i));
        }
    }

    private void addToLinkedList() {
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            linkedList.addFirst(new Integer(i));
        }
    }

}
