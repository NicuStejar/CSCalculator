package com.company.Client;

import com.company.CSInterfaces.AppConfig;
import com.company.CSInterfaces.CalculatorInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Main class for front-end logic
 * Connects to a server and lets the user choose what operation he wants to execute
 */
public class CalculatorClient {

    /**
     * Method that connects to the Remote Server and displays the menus for the user
     * */
    public static void main(String[] arg) {

        // variables for input
        Scanner reader = new Scanner(System.in);
        double operand1, operand2, result = 0;
        int option;

        // variable for memory operations
        boolean memoryWasRead = false;

        try {
            // connects to the remote virtual machine and looks up for the calculator
            Registry registry = LocateRegistry.getRegistry(AppConfig.CON_ADDRESS, AppConfig.CON_PORT);
            CalculatorInterface calculator = (CalculatorInterface) registry.lookup(AppConfig.CALC_BINDING_NAME);

            // runs until a certain value is entered
            while (true) {
                // displays the menus and reads the option entered by user
                System.out.print("\033[H\033[2J");
                displayAlgebraicMenu();
                displayMemoryMenu();
                System.out.print("Option = ");
                option = reader.nextInt();

                // choose operation
                switch (option) {
                    case 1 : // summation
                        if(memoryWasRead) {
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.add(calculator.readMemory(), operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                            memoryWasRead = false;
                        } else {
                            System.out.print("Number1 = ");
                            operand1 = reader.nextDouble();
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.add(operand1, operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                        }
                        break;

                    case 2 : // subtraction
                        if(memoryWasRead) {
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.subtraction(calculator.readMemory(), operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                            memoryWasRead = false;
                        } else {
                            System.out.print("Number1 = ");
                            operand1 = reader.nextDouble();
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.subtraction(operand1, operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                        }
                        break;

                    case 3 : // product
                        if(memoryWasRead) {
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.product(calculator.readMemory(), operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                            memoryWasRead = false;
                        } else {
                            System.out.print("Number1 = ");
                            operand1 = reader.nextDouble();
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.product(operand1, operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                        }
                        break;

                    case 4 : // division
                        if(memoryWasRead) {
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.division(calculator.readMemory(), operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                            memoryWasRead = false;
                        } else {
                            System.out.print("Number1 = ");
                            operand1 = reader.nextDouble();
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.division(operand1, operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                        }
                        break;

                    case 5 : // inverse
                        if(memoryWasRead) {
                            result = calculator.inv(calculator.readMemory());
                            System.out.println("Result = " + result);
                            System.out.println();
                            memoryWasRead = false;
                        } else {
                            System.out.print("Number = ");
                            operand1 = reader.nextDouble();
                            result = calculator.inv(operand1);
                            System.out.println("Result = " + result);
                            System.out.println();
                        }
                        break;

                    case 6 : // power
                        if(memoryWasRead) {
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.power(calculator.readMemory(), operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                            memoryWasRead = false;
                        } else {
                            System.out.print("Number1 = ");
                            operand1 = reader.nextDouble();
                            System.out.print("Number2 = ");
                            operand2 = reader.nextDouble();
                            result = calculator.power(operand1, operand2);
                            System.out.println("Result = " + result);
                            System.out.println();
                        }
                        break;

                    case 7 : // factorial
                        if(memoryWasRead) {
                            result = calculator.factorial(calculator.readMemory());
                            System.out.println("Result = " + result);
                            System.out.println();
                            memoryWasRead = false;
                        } else {
                            System.out.print("Number = ");
                            operand1 = reader.nextDouble();
                            result = calculator.factorial(operand1);
                            System.out.println("Result = " + result);
                            System.out.println();
                        }
                        break;

                    case 8 : // square root
                        if(memoryWasRead) {
                            result = calculator.squareRoot(calculator.readMemory());
                            System.out.println("Result = " + result);
                            System.out.println();
                            memoryWasRead = false;
                        } else {
                            System.out.print("Number = ");
                            operand1 = reader.nextDouble();
                            result = calculator.squareRoot(operand1);
                            System.out.println("Result = " + result);
                            System.out.println();
                        }
                        break;

                    case 9 : // add a result in calculator's memory
                        calculator.addToMemory(result);
                        memoryWasRead = false;
                        System.out.println();
                        break;

                    case 10 : // subtract a result from the calculator's memory
                        calculator.subtractFromMemory(result);
                        memoryWasRead = false;
                        System.out.println();
                        break;

                    case 11 : // store a result in memory
                        calculator.storeInMemory(result);
                        memoryWasRead = false;
                        System.out.println();
                        break;

                    case 12 : // read the memory
                        result = calculator.readMemory();
                        memoryWasRead = true;
                        System.out.println(result);
                        System.out.println();
                        break;

                    case 13 : // delete memory
                        calculator.deleteMemory();
                        memoryWasRead = false;
                        System.out.println();
                        break;

                    case 14 : // exit
                        System.exit(AppConfig.EXIT_SUCCESS);
                        break;

                    default :
                        System.out.println("Incorrect option!");
                        break;
                }
            }

        } catch (RemoteException e) {
            System.out.println("Connection error - client");
        } catch (NotBoundException e){
            System.out.println(AppConfig.CALC_BINDING_NAME + "object not bound in server");
        }
    }

    /**
     * Method that displays the Algebraic operations supported by server
     * */
    public static void displayAlgebraicMenu() {
        System.out.println("Meniu");
        System.out.println("Adunare - 1");
        System.out.println("Scadere - 2");
        System.out.println("Inmultire - 3");
        System.out.println("Impartire - 4");
        System.out.println("Invers - 5");
        System.out.println("Putere - 6");
        System.out.println("Factorial - 7");
        System.out.println("Radical - 8 ");
    }

    /**
     * Method that displays the Memory operations supported by server
     * */
    public static void displayMemoryMenu() {
        System.out.println("Adunare rezultat in memorie - 9");
        System.out.println("Scadere rezultat din memorie - 10");
        System.out.println("Stocare rezultat in memorie - 11");
        System.out.println("Citire rezultat din memorie - 12");
        System.out.println("Stergere rezultat din memorie - 13");
        System.out.println("Iesire - 14");
    }

}
