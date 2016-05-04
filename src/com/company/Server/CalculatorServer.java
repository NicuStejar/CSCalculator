package com.company.Server;

import com.company.CSInterfaces.AppConfig;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Main class for the back-end logic
 * Creates a value in the RMIRegistry and a {@link CalculatorImplementation} object and binds the two
 */
public class CalculatorServer {

    public static void main(String[] args) {

        try {
            // creates a new value in the RMIRegistry
            Registry registry = LocateRegistry.createRegistry(AppConfig.CON_PORT);
            // creates an implementation of the calculator's logic
            CalculatorImplementation calculator = new CalculatorImplementation();
            // binds the registry with the calculator's logic
            registry.rebind(AppConfig.CALC_BINDING_NAME, calculator);

            // displays message to confirm that server is up and running
            System.out.println("Server is ready!");
        } catch (RemoteException e) {
            System.out.println("Connection problem - server");
            e.printStackTrace();
        }
    }

}
