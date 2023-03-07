/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author a22davidil
 */
public class XogoTest {
    
    public XogoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

   @Test
    public void c1() {
        System.out.println("ePosicionValida");
        int x = -5;
        int y = 0;
        Xogo instance = null;
        boolean expResult = false;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    @Test
    public void c2() {
        System.out.println("ePosicionValida");
        int x = 0;
        int y = 0;
        Xogo instance = null;
        boolean expResult = true;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    @Test
    public void c3() {
        System.out.println("ePosicionValida");
        int x = 0;
        int y = -8;
        Xogo instance = null;
        boolean expResult = false;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    @Test
    public void c4() {
        System.out.println("ePosicionValida");
        int x = -8;
        int y = -6;
        Xogo instance = null;
        boolean expResult = false;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    @Test
    public void c5() {
        System.out.println("ePosicionValida");
        int x = 400;
        int y = 0;
        Xogo instance = null;
        boolean expResult = false;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void c6() {
        System.out.println("ePosicionValida");
        int x = 0;
        int y = 700;
        Xogo instance = null;
        boolean expResult = false;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    @Test
    public void c7() {
        System.out.println("ePosicionValida");
        int x = 320;
        int y = 0;
        Xogo instance = null;
        boolean expResult = true;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    @Test
    public void c8() {
        System.out.println("ePosicionValida");
        int x = 0;
        int y = 640;
        Xogo instance = null;
        boolean expResult = true;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    @Test
    public void c9() {
        System.out.println("ePosicionValida");
        int x = 320;
        int y = 640;
        Xogo instance = null;
        boolean expResult = true;
        boolean result = instance.ePosicionValida(x, y);
        assertEquals(expResult, result);
        
    }
    
}
