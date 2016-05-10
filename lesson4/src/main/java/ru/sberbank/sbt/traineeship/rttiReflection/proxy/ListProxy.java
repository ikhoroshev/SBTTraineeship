package ru.sberbank.sbt.traineeship.rttiReflection.proxy;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by фвьшт on 10.04.2016.
 */
public class ListProxy<T> implements List<T>{

    private List<T> target;

    public ListProxy(List<T> target) {
        this.target = target;
    }

    @Override
    public int size() {
        System.out.println("Method 'size' invocation.");
        return target.size();
    }

    @Override
    public boolean isEmpty() {
        System.out.println("Method 'isEmpty' invocation.");
        return target.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        System.out.println("Method 'contains' invocation.");
        return target.contains(o);
    }

    @Override
    public Iterator iterator() {
        System.out.println("Method 'iterator' invocation.");
        return target.iterator();
    }

    @Override
    public Object[] toArray() {
        System.out.println("Method 'toArray' invocation.");
        return target.toArray();
    }

    @Override
    public boolean add(T o) {
        System.out.println("Method 'add' invocation.");
        return target.add(o);
    }

    @Override
    public boolean remove(Object o) {
        System.out.println("Method 'remove' invocation.");
        return target.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        System.out.println("Method 'addAll' invocation.");
        return target.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        System.out.println("Method 'addAll' invocation.");
        return target.addAll(index, c);
    }

    @Override
    public void clear() {
        System.out.println("Method 'clear' invocation.");
        target.clear();
    }

    @Override
    public T get(int index) {
        System.out.println("Method 'get' invocation.");
        return target.get(index);
    }

    @Override
    public T set(int index, T element) {
        System.out.println("Method 'set' invocation.");
        return target.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        System.out.println("Method 'add' invocation.");
        target.add(index, element);
    }

    @Override
    public T remove(int index) {
        System.out.println("Method 'remove' invocation.");
        return target.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        System.out.println("Method 'indexOf' invocation.");
        return target.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        System.out.println("Method 'lastIndexOf' invocation.");
        return target.lastIndexOf(o);
    }

    @Override
    public ListIterator listIterator() {
        System.out.println("Method 'listIterator' invocation.");
        return target.listIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        System.out.println("Method 'listIterator (int index)' invocation.");
        return target.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        System.out.println("Method 'subList' invocation.");
        return target.subList(fromIndex, toIndex);
    }

    @Override
    public boolean retainAll(Collection c) {
        System.out.println("Method 'retainAll' invocation.");
        return target.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        System.out.println("Method 'removeAll' invocation.");
        return target.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        System.out.println("Method 'containsAll' invocation.");
        return target.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        System.out.println("Method 'toArray' invocation.");
        return toArray(a);
    }
}
