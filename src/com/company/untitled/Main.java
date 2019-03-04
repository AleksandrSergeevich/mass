package com.company.untitled;


public class Main {

    public static void main(String[] args) {
        int[] masArr = new int[100000];
        int n = masArr.length;
        for (int i = 0; i < masArr.length; i++) {
            masArr[i] = (int) (Math.random() * 100000);
            System.out.print(masArr[i] + " ");
        }
        //сортировка более быстрым способом

//        System.out.print("\nSorted: \n");
//        //Сортируем массив
//        Arrays.sort(masArr);
//        //Выводим отсортированный массив на консоль.
//        for (int i = 0; i < masArr.length; i++) {
//            System.out.print(masArr[i] + " ");
//        }
        System.out.println();
        bubbleSort(masArr);
        System.out.println();
        selectionSort(masArr);
        System.out.println();
        selectionSort(masArr, 0, n - 1);
        for (int i = 0; i < n; i++)
            System.out.print(masArr[i] + " ");
    }

    private static void selectionSort(int[] arr){
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i+1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
            System.out.print("\n");
            for( i = 0; i <  arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }


//пузырьковая сортировка

    public static void bubbleSort(int[] arr) {
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.print("\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    // Selection sort algorithm
    public static void selectionSort(int[] numbers, int low, int high) {
        for (int h = low; h <= high; h++)
            swap(numbers, h, getSmallest(numbers, h, high));
    }

    // Get the position of the smallest value from numbers[low] to numbers[high]
    public static int getSmallest(int[] numbers, int low, int high) {
        int small = low;
        for (int i = low + 1; i <= high; i++)
            if (numbers[i] < numbers[small])
                small = i;
        return small;
    }

    // swap numbers
    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}