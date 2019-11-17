package com.mkul.java.util;

import java.util.*;

/**
 * List to store object using hashMap.
 * <p>
 * Remember to implements methods hashcode and equals before start using this list.
 *
 * @param <E>
 */
public class HashList<E> implements List<E> {

    HashMap<Integer, E> memory = new HashMap<>();


    @Override
    public int size() {
        return memory.size();
    }

    @Override
    public boolean isEmpty() {
        return memory.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(o != null)
        {
            return memory.containsValue(o);
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
       return memory.values().iterator();
    }

    @Override
    public Object[] toArray() {
        return memory.values().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        memory.put(memory.size(), e);
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for(E element:collection)
        {
            memory.put(memory.size()+1,element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        memory.clear();
    }

    @Override
    public E get(int index) {
        return memory.get(index);
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return memory.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
