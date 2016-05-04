package com.company.CSInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Defines all the algebraic methods for the calculator
 * Defines all the memory management methods for the calculator
 */
public interface CalculatorInterface extends Remote{

    /**
     * Sum of two numbers (number1 + number2)
     * */
    double add(double number1, double number2) throws RemoteException;

    /**
     * Difference of two numbers (number1 - number2)
     * */
    double subtraction(double number1, double number2) throws RemoteException;

    /**
     * Product of two numbers (number1 * number2)
     * */
    double product(double number1, double number2) throws RemoteException;

    /**
     * Division of two numbers (number1 / number2)
     * @param number2 can't be zero
     * */
    double division(double number1, double number2) throws IllegalArgumentException, RemoteException;

    /**
     * Inverse of a number
     * @param number can't be zero
     * */
    double inv(double number) throws IllegalArgumentException, RemoteException;

    /**
     * Power of two numbers (number1 ^ number2)
     * */
    double power(double number, double pow) throws RemoteException;

    /**
     * Factorial of a number (number!)
     * */
    double factorial(double number) throws RemoteException;

    /**
     * Squre root of a number (sqrt(number))
     * @param number can't be negative
     * */
    double squareRoot(double number) throws IllegalArgumentException, RemoteException;


    /**
     * Adds a result to memory
     * @param result the added result to the current memory
     * */
    void addToMemory(double result) throws RemoteException;

    /**
     * Removes result from memory
     * @param result the removed result from the current memory
     * */
    void subtractFromMemory(double result) throws RemoteException;

    /**
     * Overwrites the current memory with a new result
     * @param result the result that will overwrite the current memory
     * */
    void storeInMemory(double result) throws RemoteException;

    /**
     * Returns the current value stored in memory
     * */
    double readMemory() throws RemoteException;

    /**
     * Deletes the memory (sets it to zero)
     * */
    void deleteMemory() throws RemoteException;
}
