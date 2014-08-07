package com.rafabene.demos.serviceloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Esta classe apenas imprime todas as implementações disponívels de {@link javax.sql.Driver}
 * 
 * Demonstra como funcionar o ServiceLoader que lê o arquivo META-INF/services/javax.sql.Driver
 * 
 * @author rafaelbenevides
 *
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while(iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println(driver.getClass());
        }

    }

}
