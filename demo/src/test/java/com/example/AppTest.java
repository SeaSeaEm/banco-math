package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.example.App.accs;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    
    @Test
    void testWithdrawApp() {
        App app = new App();

        // lets fill them up
        for (int i = 0; i < accs.length; i++) {
            int rndAccNumber = (int) Math.floor(Math.random() * 99) + 100;
            double rndAccBalance = Math.floor(Math.random() * 99) + 1000;

            accs[i] = new Account(rndAccNumber, rndAccBalance);
        }
        
        for (int i = 0, j = 1; i < accs.length; i++, j++) {
            System.out.println(String.format("%d - Numero da Conta: %d", j, accs[i].getAccountNumber()));
        }
        
        double curValue = accs[0].getBalance();
        accs[0].setAccountNumber(123);

        System.setIn(new ByteArrayInputStream("123\n200\n".getBytes()));
        
        System.out.println(String.format("Saldo anterior: %.2f", accs[0].getBalance()));
        app.deposit();
        
        assertEquals(accs[0].getBalance(), curValue + 200);
    }

    private static final InputStream DEFAULT_STDIN = System.in;

    @AfterEach
    public void rollbackChangesToStdin() {
        System.setIn(DEFAULT_STDIN);
    } 
}
