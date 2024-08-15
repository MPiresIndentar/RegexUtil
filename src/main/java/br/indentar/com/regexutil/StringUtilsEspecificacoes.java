/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.indentar.com.regexutil;

/**
 *
 * @author indentar-note
 */
public class StringUtilsEspecificacoes extends StringUtils {

    private final Integer aceitacaoDoPrimeiroNomes;
    private final Integer aceitacaoDoNomeTodo;
    private Integer percAlteradoPrimeroNome;
    private Integer percAlteradoRestanteNome;

    public Integer getAceitacaoDoPrimeiroNomes() {
        return aceitacaoDoPrimeiroNomes;
    }

    public Integer getAceitacaoDoNomeTodo() {
        return aceitacaoDoNomeTodo;
    }

    public Integer getPercAlteradoPrimeroNome() {
        return percAlteradoPrimeroNome;
    }

    public Integer getPercAlteradoRestanteNome() {
        return percAlteradoRestanteNome;
    }

    /**
     * Contrutor com os parametros para definir quando um nome ou sobrenome é
     * elegivel para mudanca
     *
     * @param aceitacaoDoPrimeiroNomes percentual de aceitação de alteração
     * @param aceitacaoDoNomeTodo percentual de aceitação de alteração
     */
    public StringUtilsEspecificacoes(Integer aceitacaoDoPrimeiroNomes, Integer aceitacaoDoNomeTodo) {
        this.aceitacaoDoPrimeiroNomes = aceitacaoDoPrimeiroNomes;
        this.aceitacaoDoNomeTodo = aceitacaoDoNomeTodo;
    }

    /**
     * Metodo que verifica se o primeiro nome (String) de um nome completo
     * (String) é elegível para mudança
     *
     * @param nomeOriginal
     * @param nomeMudado
     * @return
     */
    public boolean primeiroNomeElegivelParaMudanca(String nomeOriginal, String nomeMudado) {
        String[] nomeTodoOriginal = nomeOriginal.split(" ");
        String primerioNomeOriginal = nomeTodoOriginal[0];
        String[] nomeTodoMudado = nomeMudado.split(" ");
        String primeiroNomeMudado = nomeTodoMudado[0];
        this.percAlteradoPrimeroNome = percentualAlt(primerioNomeOriginal, primeiroNomeMudado);
        return this.percAlteradoPrimeroNome <= this.aceitacaoDoPrimeiroNomes;
    }

    /**
     * Metodo que verifica se o sobrenome (String) de um nome completo (String)
     * é elegível para mudança
     *
     * @param nomeOriginal
     * @param nomeMudado
     * @return
     */
    public boolean sobreNomeElegivelParaMudanca(String nomeOriginal, String nomeMudado) {
        if (nomeOriginal != null) {
            String[] nomeTodoOriginal = nomeOriginal.split(" ");
            String[] nomeTodoMudado = nomeMudado.split(" ");

            String sobreNomeOriginal = "";
            String sobreNomeMudado = "";

            for (int i = 1; i < nomeTodoOriginal.length; i++) {
                sobreNomeOriginal += nomeTodoOriginal[i] + " ";
            }
            for (int i = 1; i < nomeTodoMudado.length; i++) {
                sobreNomeMudado += nomeTodoMudado[i] + " ";
            }
            this.percAlteradoRestanteNome = percentualAlt(sobreNomeOriginal,
                    sobreNomeMudado);
            return this.percAlteradoRestanteNome <= this.aceitacaoDoNomeTodo;
        }else{
            return true;
        }
        // Integer percentualDeDiferenca = percentualAlt(primerioNomeOriginal, primeiroNomeMudado, diff(nomeOriginal, nomeMudado));
    }

    /**
     * Verifica se tanto o primeiro nome, quanto o sobrenome, sao elegiveis para
     * mudanca.
     *
     * @param nomeOriginal
     * @param nomeMudado
     * @return
     */
    public boolean nomeTodoElegivelParaTroca(String nomeOriginal, String nomeMudado) {
        return sobreNomeElegivelParaMudanca(nomeOriginal, nomeMudado)
                && primeiroNomeElegivelParaMudanca(nomeOriginal, nomeMudado);
    }

}
