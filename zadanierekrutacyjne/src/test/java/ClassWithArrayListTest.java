import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ClassWithArrayListTest {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test " + this.getClass().getName()); }
    @Test
    public void firstTest(ArrayList<Integer> empty) {
        System.out.println("Test sprawdzający dodawanie pustej liczby");;
        ClassWithArrayList.addingNewArrayList(empty);
    }

    @Test
    public void secondTest(ArrayList<Integer> even) {
        System.out.println("Test sprawdzający dodawanie parzystej liczby");;
        ClassWithArrayList.addingNewArrayList(even);
    }

    @Test
    public void thirdTest(ArrayList<Integer> odd) {
        System.out.println("Test sprawdzający dodawanie nieparzystej liczby");;
        ClassWithArrayList.addingNewArrayList(odd);
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test " + this.getClass().getName()); }


}
