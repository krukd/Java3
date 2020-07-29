package ru.gb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
//2. Написать метод, который преобразует массив в ArrayList;
//3. Большая задача:
//
//a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
// нельзя сложить и яблоки, и апельсины;
//c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
// (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
// в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
// сравнивать с коробками с апельсинами);
//f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
// фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
// а в другую перекидываются объекты, которые были в этой коробке;
//g. Не забываем про метод добавления фрукта в коробку.
public class Main {
    public static void main(String[] args) {
        Integer[] arrI = {3, 6, 8, 25, 76, 89};
        String[] arrStr = {"Java", "Python", "C", "PHP", "Ruby"};

        swap(arrI, 3, 5);
        swap(arrStr, 1, 4);

        String[] arr = {"Canada", "Russia", "Poland", "Singapore", "France"};
        arrInList(arr);

        Box<Orange> boxOrange1 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();
        Box<Apple> boxApple1 = new Box<>();
        Box<Apple> boxApple2 = new Box<>();

        boxOrange1.addFruit(new Orange(), 12);
        boxOrange2.addFruit(new Orange(), 6);
        boxApple1.addFruit(new Apple(), 15);
        boxApple2.addFruit(new Apple(), 5);

        System.out.println("Box 1 weight " + boxOrange1.getWeight());
        System.out.println("Box 2 weight " + boxOrange2.getWeight());
        System.out.println("Box 3 weight " + boxApple1.getWeight());
        System.out.println("Box 4 weight " + boxApple2.getWeight());

        System.out.println("Box 1 equals Box 3 " + boxOrange1.compare(boxApple1));
        System.out.println("Box 2 equals Box 4 " + boxOrange2.compare(boxApple2));

        boxOrange1.putTo(boxOrange2);
        boxApple1.putTo(boxApple2);

        System.out.println("Box 1 weight " + boxOrange1.getWeight());
        System.out.println("Box 2 weight " + boxOrange2.getWeight());
        System.out.println("Box 3 weight " + boxApple1.getWeight());
        System.out.println("Box 4 weight " + boxApple2.getWeight());
    }


    public static void swap(Object[] arr, int i, int j) {
        System.out.println("Исходный массив " + Arrays.toString(arr));
        Object s = arr[i];
        arr[i] = arr[j];
        arr[j] = s;
        System.out.println("Массив с заменой двух элементов местами " + Arrays.toString(arr));

    }

    public static <T> void arrInList(T [] arr){

        List<T> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Массив преобразованный в ArrayList " + list);
    }
}
