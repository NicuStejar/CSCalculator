package com.company.CSInterfaces;

/**
 * Stores values needed for Client-Server connection
 * Stores: connection port, ip address and binding name
 */
public class AppConfig {

    /**
     * Port of the server's calculator service
     */
    public static final int CON_PORT = 1098;

    /**
     * IP address of server
     */
    public static final String CON_ADDRESS = "172.27.100.145"; //localhost

    /**
     * Binding name used for RMI of calculator
     */
    public static final String CALC_BINDING_NAME = "calculator";

    /**
     * Exit code for success
     */
    public static final int EXIT_SUCCESS = 0;
}
