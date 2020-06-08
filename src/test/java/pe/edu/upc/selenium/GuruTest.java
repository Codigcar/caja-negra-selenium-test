package pe.edu.upc.selenium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuruTest {

    @Test
    void comprar() {
        Guru guru = new Guru();
        String actual = guru.comprar();
        String expected = "$800.00";

        assertEquals(expected,actual);

    }
}