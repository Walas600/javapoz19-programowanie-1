package pl.sdacademy.javapoz19programowanie1.lists;

import org.junit.Assert;
import org.junit.Test;


public class MyArrayListTest {
    @Test
    public void removeOfMiddleElementShouldEraseElementFromList() {
        //given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        //when
        myArrayList.remove(1);

        //then
        Assert.assertEquals(2, myArrayList.size());

        Assert.assertEquals((Integer) 1, myArrayList.get(0));
        Assert.assertEquals((Integer) 5, myArrayList.get(1));
    }


    @Test
    public void removeOfLastElementShouldEraseElementFromList() {
        //given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        //when
        myArrayList.remove(2);

        //then
        Assert.assertEquals(2, myArrayList.size());

        Assert.assertEquals((Integer) 1, myArrayList.get(0));
        Assert.assertEquals((Integer) 3, myArrayList.get(1));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void removeNonExistingElementShouldThrowArrayIndexOutOfBoundsException() {
        //given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);
        //when
        myArrayList.remove(3);
    }

    @Test
    public void addShouldAddElementAndMoveExistingElementsInList(){
        //given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        //when
        myArrayList.add(1,2);

        //then
        Assert.assertEquals(4, myArrayList.size());

        Assert.assertEquals((Integer) 1, myArrayList.get(0));
        Assert.assertEquals((Integer) 2, myArrayList.get(1));
        Assert.assertEquals((Integer) 3, myArrayList.get(2));
        Assert.assertEquals((Integer) 5, myArrayList.get(3));
    }

    @Test
    public void addShouldAddElementAtEnd(){
        //given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        //when
        myArrayList.add(3,7);

        //then
        Assert.assertEquals(4, myArrayList.size());

        Assert.assertEquals((Integer) 1, myArrayList.get(0));
        Assert.assertEquals((Integer) 3, myArrayList.get(1));
        Assert.assertEquals((Integer) 5, myArrayList.get(2));
        Assert.assertEquals((Integer) 7, myArrayList.get(3));

    }

    @Test
    public void addShouldAddElementAtBeginning(){
        //given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        //when
        myArrayList.add(0,0);

        //then
        Assert.assertEquals(4, myArrayList.size());

        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 1, myArrayList.get(1));
        Assert.assertEquals((Integer) 3, myArrayList.get(2));
        Assert.assertEquals((Integer) 5, myArrayList.get(3));

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addReplacingShouldThrowArrayIndexOutOfBoundsExceptionWhenAddingOnWrongIndex(){
        //given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        //when
        myArrayList.add(4,35);
    }
    @Test
    public void addShouldAddElementInMiddleOfListOfSize10(){
        //given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(10);
        myArrayList.add(11);

        //when
        myArrayList.add(8,9);

        //then
        Assert.assertEquals(11, myArrayList.size());

        Assert.assertEquals((Integer) 1, myArrayList.get(0));
        Assert.assertEquals((Integer) 2, myArrayList.get(1));
        Assert.assertEquals((Integer) 3, myArrayList.get(2));
        Assert.assertEquals((Integer) 4, myArrayList.get(3));
        Assert.assertEquals((Integer) 5, myArrayList.get(4));
        Assert.assertEquals((Integer) 6, myArrayList.get(5));
        Assert.assertEquals((Integer) 7, myArrayList.get(6));
        Assert.assertEquals((Integer) 8, myArrayList.get(7));
        Assert.assertEquals((Integer) 9, myArrayList.get(8));
        Assert.assertEquals((Integer) 10, myArrayList.get(9));
        Assert.assertEquals((Integer) 11, myArrayList.get(10));
    }

}