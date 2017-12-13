package com.company;

import games.Matrix;
import games.Palindrom;
import calculator.Arithmetic;
import games.Snail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//Улитка
        System.out.println("Демонстрация матрицы улитка");
        System.out.println("Введите размерность матрицы улитки(размерность должна быть больше 3)");
        String razm = reader.readLine();
        int size = Integer.parseInt(razm);
        if (size > 3) {
            try {
                Snail.calculateSnail(size);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Нужно вводить число");
            }
        } else System.out.println("Ошибка! Размерность массива должна быть больше 3");

        System.out.println("Демонстрация матрицы, состоящей из чисел от 1 до 9-ти");
        System.out.println("Введите число от 1 до 9! Для выхода введите q");
        String num = reader.readLine();
        if (num.equals("q")) System.out.println("Пока");
        else {
            try {
                int num1 = Integer.parseInt(num);
                if (num1 > 0 && num1 < 10)
                    Matrix.createMatrix(num1);
                else System.out.println("Ошибка ввода числа");
            } catch (
                    NumberFormatException e) {
                System.out.println("Ошибка ввода. Нужно вводить число");
            }
        }
        //слово палиндром
        System.out.println("Демонстрация метода палиндром для слова");
        System.out.println("Введите слово, а я определю палиндром это или нет: ");
        String inputWord = reader.readLine();
        if (Palindrom.checkWord(inputWord)) {
            System.out.println("Слово палиндром");
        } else System.out.println("слово не палиндром");
//фраза палиндром
        System.out.println("Демонстрация метода палиндром для фразы");
        System.out.println("Введите фразу, а я определю палиндром это или нет: ");
        String inputPhrase = reader.readLine();
        if (Palindrom.checkPhrase(inputPhrase)) {
            System.out.println("Фраза Палиндром");
        } else {
            System.out.println("Фраза не палиндром");
        }

//Демонстрация метода arrayMultiplication
        System.out.println("Демонстрация метода перемножения элементов массива");
        System.out.println("Введите размерность перемножаемого массива");
        try {
            String inputLength = reader.readLine();
            int arrayLength = Integer.parseInt(inputLength);
            int[] array = new int[arrayLength];
            System.out.println("Введите элементы массива");
            for (int i = 0; i < arrayLength; i++) {
                String inputElement = reader.readLine();
                int value = Integer.parseInt(inputElement);
                array[i] = value;
            }
            System.out.println("Результат перемножения элементов массива: " + Arithmetic.arrayMultiplication(array));
        } catch (
                NumberFormatException e) {
            System.out.println("Ошибка ввода! Необходимо вводить числовые значения");
        }
// Демонстрация функции возведения в степень
        System.out.println("Демонстрация метода возведения в степень");
        System.out.println("Введите число, которое будем возводить в степень");
        String input = reader.readLine();
        try {
            int x = Integer.parseInt(input);
            System.out.println("Введите степень, в которую будем возводить число");
            String input2 = reader.readLine();
            int y = Integer.parseInt(input2);
            System.out.println("Результат возведения в степень: " + Arithmetic.power(x, y));
        } catch (
                NumberFormatException e) {
            System.out.println("Ошибка ввода! Необходимо вводить числовые значения");
        }
// Демонстрации функции деления
        try {
            System.out.println("Демонстрация метода деления");
            System.out.println("Введите делимое: ");
            String input3 = reader.readLine();
            int a = Integer.parseInt(input3);
            System.out.println("Введите делитель: ");
            String input4 = reader.readLine();
            int b = Integer.parseInt(input4);
            if (b != 0)
                System.out.println("Результат операции деления: " + Arithmetic.division(a, b));
            else System.out.println("Ошибка! Деление на 0!");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Необходимо вводить только числа");
        }

//Демонстрация функции извлечения корня
        try {
            System.out.println("Демонстрация метода извлечения корня");
            System.out.println("Введите число из которого будем извлекать корень");
            String input5 = reader.readLine();
            int n = Integer.parseInt(input5);
            if (n < 0) System.out.println("Ошибка! Нельзя извлекать корень из отрицательных чисел");
            else System.out.println("Результат операции извлечения корня: " + Arithmetic.root(n));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Необходимо вводить только число");
        }
    }
}


