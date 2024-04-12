/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strakhova14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ПК
 */
public class GenerateService {
    public void generateRandomDigits() {
        List<Integer> numbers = new ArrayList<>();

        Runnable generateNumbers = () -> {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                numbers.add(random.nextInt(1000));
            }
            System.out.println("\nСгенерированный список:");
            System.out.println(numbers);
        };

        Runnable sortNumbers = () -> {
            try {
                Thread.sleep(1000); 
                Collections.sort(numbers);
                System.out.println("\nСортированный список:");
                System.out.println(numbers);
            } catch (InterruptedException e) {
                System.out.println("Ошибка в потоке сортировки");
            }
        };

        Thread generatorThread = new Thread(generateNumbers);
        Thread sorterThread = new Thread(sortNumbers);

        generatorThread.start();
        sorterThread.start();
    }  
}
