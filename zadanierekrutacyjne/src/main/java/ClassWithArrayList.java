import java.util.ArrayList;
import java.util.Scanner;

public class ClassWithArrayList {
    static ArrayList<Integer> newData;

    public static void addingNewArrayList(ArrayList<Integer> newData){
        ArrayList<ArrayList<Integer>> myNumbers = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> firstData = new ArrayList<Integer>();
        firstData.add(1);
        firstData.add(2);
        myNumbers.add(firstData);
        ArrayList<Integer> secondData = new ArrayList<Integer>();
        secondData.add(5);
        myNumbers.add(secondData);

        Scanner newArrayList = new Scanner(System.in);
        System.out.println("Wpisz liczbe nieparzysta");

        String line = newArrayList.nextLine();
        String[] numbersArray = line.split("-");
        for(int j=0; j != numbersArray.length; j++) {
            if (j % 2 == 1) {
                for(int i=0; i<numbersArray.length; i++) {

                    String[] numbers= numbersArray[i].split(" ");
                    ArrayList<Integer> thirdData = new ArrayList<Integer>();
                    for(int f=0; f<numbers.length; f++) {
                        thirdData.add(new Integer(numbers[j]));
                    }
                    newData = thirdData;
                    myNumbers.add(newData);
                }
            } else {
                System.out.println("Liczba nieprawidlowa, sproboj ponownie");
            }
        }

        for (ArrayList i : myNumbers) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        System.out.println("Dzień dobry!");
        //ArrayList<Integer> A = new ArrayList<Integer>();
        addingNewArrayList(newData);
    }
  }


