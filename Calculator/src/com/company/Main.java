package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Stack calculator = new Stack();
        String choice; // переменная для выбора действий

        do {
            System.out.print("Введите выражение: ");
            calculator.setFormula(in.nextLine());  // вводим выражение
            System.out.println("Вы ввели: " + calculator.getFormula());

            if (!calculator.checkFormula()) {        // если выражение введено корректно
                calculator.formulaToStringArray();   // конвертирует его в массив
                calculator.formulaStrCorrection();   // редактирует его
                System.out.print("Ответ: ");
                format(calculator.result());         // считает его и выводит в нужном формате
            } else {
                System.out.println("Ошибка ввода!"); // иначе ошибка ввода
            }

            System.out.println("\n1.Продолжить/2.Завершить?");
            do {
                System.out.print("Введите номер выбранного варианта: ");
                choice = in.nextLine();              // вводим значение выбранного варианта
                if(!choice.equals("1") && !choice.equals("2")) { // проверка на ошибку
                    System.out.println("Ошибка ввода!");
                }
            } while(!choice.equals("1") && !choice.equals("2"));

        } while (choice.equals("1"));         // повторяет пока выбрано 1.Продолжить
    }

    public static void format(double digit) { // выводит число в нужном формате
        if (digit == (long) digit) {
            long result = (long) digit;
            System.out.println(result);
        } else {
            BigDecimal result = new BigDecimal(String.valueOf(digit));
            System.out.println(result);
        }
    }
}