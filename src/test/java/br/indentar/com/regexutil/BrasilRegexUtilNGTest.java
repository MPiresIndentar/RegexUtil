/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package br.indentar.com.regexutil;

import static org.testng.Assert.*;

/**
 *
 * @author pcmix
 */
public class BrasilRegexUtilNGTest {

    public BrasilRegexUtilNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of isPlaca method, of class BrasilRegexUtil.
     */
    @org.testng.annotations.Test
    public void testIsPlaca() {
        System.out.println("isPlaca");
        String placa = "bbb4126";
        boolean expResult = true;
        boolean result = BrasilRegexUtil.isPlaca(placa);
        assertEquals(result, expResult);

    }

    /**
     * Test of toWhatsNumberBr method, of class BrasilRegexUtil.
     */
    @org.testng.annotations.Test(testName = "toWhatsNumberBr celular com ddd sem o 9")
    public void testToWhatsNumberBr_celular_com_ddd_sem_9() {
        System.out.println("testToWhatsNumberBr_celular_com_ddd_sem_9");
        String number = "3791246813";
        String expResult = "553791246813";
        String result = BrasilRegexUtil.toWhatsNumberBr(number, "37",false);
        assertEquals(result, expResult);

    }

    @org.testng.annotations.Test(testName = "toWhatsNumberBr celular com ddd  com o 9")
    public void testToWhatsNumberBr_celular_com_ddd_com_9() {
        System.out.println("testToWhatsNumberBr_celular_com_ddd_com_9");
        String number = "37991246813";
        String expResult = "5537991246813";
        String result = BrasilRegexUtil.toWhatsNumberBr(number, "37",false);
        assertEquals(result, expResult);

    }

    @org.testng.annotations.Test(testName = "toWhatsNumberBr fixo com ddd ")
    public void testToWhatsNumberBr_fixo_com_ddd() {
        System.out.println("testToWhatsNumberBr_fixo_com_ddd");
        String number = "3741417604";
        String expResult = "553741417604";
        String result = BrasilRegexUtil.toWhatsNumberBr(number, "37",false);
        assertEquals(result, expResult);
    }
    @org.testng.annotations.Test
    public void testToWhatsNumberBr_fixo_sem_ddd() {
        System.out.println("testToWhatsNumberBr_fixo_sem_ddd");
        String number = "41417604";
        String expResult = "553741417604";
        String result = BrasilRegexUtil.toWhatsNumberBr(number, "37",false);
        assertEquals(result, expResult);
    }
    @org.testng.annotations.Test
    public void testToWhatsNumberBr_celular_sem_ddd_sem_9() {
        System.out.println("testToWhatsNumberBr_celular_sem_ddd_sem_9");
        String number = "91246813";
        String expResult = "553791246813";
        String result = BrasilRegexUtil.toWhatsNumberBr(number, "37",false);
        assertEquals(result, expResult);
    }
    @org.testng.annotations.Test
    public void testToWhatsNumberBr_celular_sem_ddd_com_9() {
        System.out.println("testToWhatsNumberBr_celular_sem_ddd_sem_9");
        String number = "991246813";
        String expResult = "5537991246813";
        String result = BrasilRegexUtil.toWhatsNumberBr(number, "37",false);
        assertEquals(result, expResult);
    }

}
