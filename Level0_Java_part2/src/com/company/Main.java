package com.company;

import com.sun.jdi.Value;
import games.Matrix;
import games.Snail;
import calculator.Arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

       // Snail arraySnail = new Snail();
       // System.out.println(arraySnail.calculateSnail(8));

        int num1 = 0;
        while (!(num1 == -1)) {

            System.out.println("Vvedite chislo ot 1 do 9! Dlya vyhoda vvedite -1");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String num = reader.readLine();

            num1 = Integer.parseInt(num);

            if (num1 > 0 && num1 < 10)
                Matrix.createMatrix(num1);
            else if (num1 == -1) System.out.println("Bye bye");
            else System.out.println("Oshibka vvoda chisla");
        }

        //Демонстрация метода arrayMultiplication
        System.out.println("Vvedite rasmernost massiva");
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String inputLength = input.readLine();
            int arrayLength = Integer.parseInt(inputLength);
            int[] array = new int[arrayLength];
            System.out.println("Vvedite elementy massiva");
            for (int i = 0; i < arrayLength; i++) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String inputElement = reader.readLine();
                int value = Integer.parseInt(inputElement);
                array[i] = value;
            }
            System.out.println("Result multiplie array: " + Arithmetic.arrayMultiplication(array));
        }catch (NumberFormatException e){
            System.out.println("Oshibka vvoda! Neobhodimo vvodit tolko chisla");
        }
// Демонстрация функции возведения в степень
        System.out.println("Vvedite chislo, kotoroe budem vozvodit v stepen");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        try{int x = Integer.parseInt(input);
        System.out.println("Vvedite stepen v kotoruyu budem vozvodit");
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String input2 = reader.readLine();
        int y = Integer.parseInt(input2);
        System.out.println("Resultat vozvedeniya v stepen: " + Arithmetic.power(x,y));
        }catch (NumberFormatException e){
            System.out.println("Error! Neobhodimo vvodit tolko chisla");
        }
// Демонстрации функции деления
        System.out.println("Vvedite chislo kotoroe budem delit: ");
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
        String input3 = reader.readLine();
        int a = Integer.parseInt(input3);
        System.out.println("Vvedite chislo na kotoroe budem delit: ");
        BufferedReader reader4 = new BufferedReader(new InputStreamReader(System.in));
        String input4 = reader.readLine();
        int b = Integer.parseInt(input4);
        if (Arithmetic.division(a,b)!=0)
        System.out.println("Результат операции деления: "+ Arithmetic.division(a,b));


//Демонстрация функции извлечения корня
        System.out.println("Введите число из которого будем извлекать корень");
        BufferedReader reader5 = new BufferedReader(new InputStreamReader(System.in));
        String input5 = reader.readLine();
        int n = Integer.parseInt(input5);
        if (n < 0) System.out.println("Ошибка! Нельзя извлекать корень из отрицательных чисел");
        else System.out.println("Результат операции извлечения корня: " +Arithmetic.root(n));


    }
}


