/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.indentar.com.regexutil;

import jdk.nashorn.internal.ir.annotations.Ignore;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Marlucio
 */
@Ignore
public class StringUtilsEspecificacoesTest {
    
    public StringUtilsEspecificacoesTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    


    /**
     * Test of getAceitacaoDoPrimeiroNomes method, of class StringUtilsEspecificacoes.
     */
    @org.junit.jupiter.api.Test
    public void testGetAceitacaoDoPrimeiroNomes() {
        System.out.println("getAceitacaoDoPrimeiroNomes");
        StringUtilsEspecificacoes instance = null;
        Integer expResult = null;
        Integer result = instance.getAceitacaoDoPrimeiroNomes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAceitacaoDoNomeTodo method, of class StringUtilsEspecificacoes.
     */
    @org.junit.jupiter.api.Test
    public void testGetAceitacaoDoNomeTodo() {
        System.out.println("getAceitacaoDoNomeTodo");
        StringUtilsEspecificacoes instance = null;
        Integer expResult = null;
        Integer result = instance.getAceitacaoDoNomeTodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPercAlteradoPrimeroNome method, of class StringUtilsEspecificacoes.
     */
    @org.junit.jupiter.api.Test
    public void testGetPercAlteradoPrimeroNome() {
        System.out.println("getPercAlteradoPrimeroNome");
        StringUtilsEspecificacoes instance = null;
        Integer expResult = null;
        Integer result = instance.getPercAlteradoPrimeroNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPercAlteradoRestanteNome method, of class StringUtilsEspecificacoes.
     */
    @org.junit.jupiter.api.Test
    public void testGetPercAlteradoRestanteNome() {
        System.out.println("getPercAlteradoRestanteNome");
        StringUtilsEspecificacoes instance = null;
        Integer expResult = null;
        Integer result = instance.getPercAlteradoRestanteNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of primeiroNomeElegivelParaMudanca method, of class StringUtilsEspecificacoes.
     */
    @org.junit.jupiter.api.Test
    public void testPrimeiroNomeElegivelParaMudanca() {
        System.out.println("primeiroNomeElegivelParaMudanca");
        String nomeOriginal = "";
        String nomeMudado = "";
        StringUtilsEspecificacoes instance = null;
        boolean expResult = false;
        boolean result = instance.primeiroNomeElegivelParaMudanca(nomeOriginal, nomeMudado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sobreNomeElegivelParaMudanca method, of class StringUtilsEspecificacoes.
     */
    @org.junit.jupiter.api.Test
    public void testSobreNomeElegivelParaMudanca() {
        System.out.println("sobreNomeElegivelParaMudanca");
        String nomeOriginal = "";
        String nomeMudado = "";
        StringUtilsEspecificacoes instance = null;
        boolean expResult = false;
        boolean result = instance.sobreNomeElegivelParaMudanca(nomeOriginal, nomeMudado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nomeTodoElegivelParaTroca method, of class StringUtilsEspecificacoes.
     */
    @org.junit.jupiter.api.Test
    public void testNomeTodoElegivelParaTroca() {
        System.out.println("nomeTodoElegivelParaTroca");
        String nomeOriginal = "Marlúcio Ferreira Pires Junior";
        String nomeMudado = "Marlúcio F Pires Jr";
        StringUtilsEspecificacoes instance = new StringUtilsEspecificacoes(0, 80);
        boolean expResult = true;
        boolean result = instance.nomeTodoElegivelParaTroca(nomeOriginal, nomeMudado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
