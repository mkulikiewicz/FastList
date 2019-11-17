package com.mkul.java.util;

import com.mkul.example.object.ExampleObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@Test
public class HashListTest {


    private HashList<ExampleObject> hashList;
    private static final int DEFAULT_LIST_FILL = 100;

    @BeforeMethod
    public void initList() {
        hashList = new HashList<ExampleObject>();
        fillListHelper(DEFAULT_LIST_FILL);
    }

    @AfterMethod
    public void unInitList() {
        hashList = null;
    }

    @Test()
    public void testAddMethodIncreasingSize() {
        //Then
        assertThat(hashList.size()).isEqualTo(DEFAULT_LIST_FILL);
    }

    @Test()
    public void testGetMethodGettingElement() {
        //When
        ExampleObject exampleObject10 = hashList.get(10);

        //Then
        assertThat(exampleObject10).isEqualTo(new ExampleObject("10"));
        assertThat(hashList.size()).isEqualTo(DEFAULT_LIST_FILL);
    }

    @Test
    public void testContainsMethodShouldContain()
    {
        //Then
        assertThat(hashList.contains(new ExampleObject("10"))).isTrue();
    }

    @Test
    public void testContainsMethodShouldNotContain()
    {
        //Then
        assertThat(hashList.contains(new ExampleObject(String.valueOf(DEFAULT_LIST_FILL+1)))).isFalse();
    }

    @Test
    public void testRemoveMethodRemoveElement() {
        //When
        ExampleObject exampleObject10 = hashList.remove(10);

        //Then
        assertThat(exampleObject10).isEqualTo(new ExampleObject("10"));
        assertThat(hashList.size()).isEqualTo(DEFAULT_LIST_FILL-1);
        assertThat(hashList.contains(exampleObject10)).isFalse();
    }

    @Test
    public void testIteratorMethodReturnIterator() {
        //When
        Iterator<ExampleObject> iterator = hashList.iterator();
        iterator.next();
        iterator.remove();


        //Then
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(new ExampleObject("1"));
    }

    @Test
    public void testIsEmptyReturningFalse() {
        //Then
        assertThat(hashList.isEmpty()).isFalse();
    }

    @Test
    public void testIsEmptyReturningTrue() {
        //Given
        HashList<Object> emptyHashList = new HashList<>();

        //Then
        assertThat(emptyHashList.isEmpty()).isTrue();
    }

    @Test
    public void testAddTrue() {
        //Given
        List<ExampleObject> exampleObjectList = new ArrayList<ExampleObject>();
        ExampleObject firstExampleObjectToAdd = new ExampleObject(String.valueOf(DEFAULT_LIST_FILL+1));
        ExampleObject secondExampleObjectToAdd = new ExampleObject(String.valueOf(DEFAULT_LIST_FILL+2));

        exampleObjectList.add(firstExampleObjectToAdd);
        exampleObjectList.add(secondExampleObjectToAdd);

        hashList.addAll(exampleObjectList);

        //Then
        assertThat(hashList.size()).isEqualTo(DEFAULT_LIST_FILL+2);
        assertThat(hashList.contains(firstExampleObjectToAdd)).isTrue();
        assertThat(hashList.contains(secondExampleObjectToAdd)).isTrue();
    }

    private void fillListHelper(int count) {
        for (int i = 0; i < count; i++) {
            hashList.add(new ExampleObject(String.valueOf(i)));
        }
    }

}
