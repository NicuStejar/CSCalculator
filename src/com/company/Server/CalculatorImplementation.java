package com.company.Server;

import com.company.CSInterfaces.CalculatorInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Tha class that implements all the necessary methods for algebraic calculations and memory management
 */
public class CalculatorImplementation extends UnicastRemoteObject implements CalculatorInterface {

    /**
     * The internal memory for the current CalculatorImplementation that will store the user's data (if selected)
     * */
    private double memory;

    /**
     * Creates a new calculator with an original memory value of 0
     * */
    protected CalculatorImplementation() throws RemoteException {
        this.memory = 0;
    }

    @Override
    public double add(double number1, double number2) throws RemoteException {
        return number1 + number2;
    }

    @Override
    public double subtraction(double number1, double number2) throws RemoteException {
        return number1 - number2;
    }

    @Override
    public double product(double number1, double number2) throws RemoteException {
        return number1 * number2;
    }

    @Override
    public double division(double number1, double number2) throws RemoteException {
        if (number2 == 0)
            throw new IllegalArgumentException("Second number can't be zero");
        return number1 / number2;
    }

    @Override
    public double inv(double number) throws RemoteException {
        if (number == 0)
            throw new IllegalArgumentException("Number can't be zero");
        return 1 / number;
    }

    @Override
    public double power(double number, double pow) throws RemoteException {
        return Math.pow(number, pow);
    }

    @Override
    public double factorial(double number) throws RemoteException {
        double result = 1;
        for (int index = 1; index <= number; index++) {
            result = result * index;
        }

        return result;
    }

    @Override
    public double squareRoot(double number) throws RemoteException {
        if (number < 0)
            throw new IllegalArgumentException("Number can't be negative");
        return Math.sqrt(number);
    }

    @Override
    public void addToMemory(double result) throws RemoteException {
        this.memory = this.memory + result;
    }

    @Override
    public void subtractFromMemory(double result) throws RemoteException {
        this.memory = this.memory - result;
    }

    @Override
    public void storeInMemory(double result) throws RemoteException {
        this.memory = result;
    }

    @Override
    public double readMemory() throws RemoteException {
        return this.memory;
    }

    @Override
    public void deleteMemory() throws RemoteException {
        this.memory = 0;
    }
}