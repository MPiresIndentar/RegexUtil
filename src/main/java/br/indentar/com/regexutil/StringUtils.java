package br.indentar.com.regexutil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author marlucio
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    static HashMap mapGrafiaSemAcento = new HashMap();

    /**
     * Metodo principal para comparar 2 strings, retornando uma classe Pair, que
     * possue valores : Pair.first e Pair.second
     *
     * @param a
     * @param b
     * @return
     */
    public static Pair<String> diff(String a, String b) {

        return diffHelper(a.toUpperCase(), b.toUpperCase(), new HashMap<>());
    }

    /**
     * Metodo auxiliar do metodo diff, retornando tambem uma class Pair, que
     * possue valores : Pair.first e Pair.second
     *
     * @param a
     * @param b
     * @param lookup
     * @return
     */
    private static Pair<String> diffHelper(String a, String b, Map<Long, Pair<String>> lookup) {
        long key = ((long) a.length()) << 32 | b.length();
        if (!lookup.containsKey(key)) {
            Pair<String> value;
            if (a.isEmpty() || b.isEmpty()) {
                value = new Pair<>(a, b);
            } else if (a.charAt(0) == b.charAt(0)) {
                value = diffHelper(a.substring(1), b.substring(1), lookup);
            } else {
                Pair<String> aa = diffHelper(a.substring(1), b, lookup);
                Pair<String> bb = diffHelper(a, b.substring(1), lookup);
                if (aa.first.length() + aa.second.length() < bb.first.length() + bb.second.length()) {
                    value = new Pair<>(a.charAt(0) + aa.first, aa.second);
                } else {
                    value = new Pair<>(bb.first, b.charAt(0) + bb.second);
                }
            }
            lookup.put(key, value);
        }
        return lookup.get(key);
    }

    /**
     * Classe extra, essencial no uso do metodo de comparacao de strings
     *
     * @param <T>
     */
    public static class Pair<T> {

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public final T first, second;

        @Override
        public String toString() {
            return "(" + first + "," + second + ")";
        }
    }

    /**
     * Retornando um inteiro, um percentual de error entre duas string.
     *
     * @param a
     * @param b
     * @param str
     * @return
     */
    public Integer percentualAlt(String a, String b) {
        Integer sizeOriginal = retornaMaior(a.toCharArray().length, b.toCharArray().length);
        Pair<String> str = diff(a, b);
        Integer sizeErro = retornaMaior(str.first.toCharArray().length, str.second.toCharArray().length);
        return retornaPorcentagem(sizeOriginal, sizeErro);

    }

    /**
     * Retorna o maior entre dois numeros inteiros
     *
     * @param a
     * @param b
     * @return
     */
    public Integer retornaMaior(Integer a, Integer b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * Retorna a porcentagem de quanto um numero (menor) é do numero original
     * (maior)
     *
     * @param original
     * @param erro
     * @return
     */
    public Integer retornaPorcentagem(Integer original, Integer erro) {
        int aux;

        if (original > erro) {
            aux = (erro * 100) / original;
        } else {
            aux = (original * 100) / erro;
        }
        return aux;
    }

    /**
     *
     * @param chave
     * @param pesoInicial
     * @return
     */
    public static Integer modulo11(String chave, int pesoInicial) {
        int total = 0;
        int peso = pesoInicial;
        for (int i = 0; i < chave.length(); i++) {
            total += (chave.charAt((chave.length() - 1) - i) - '0') * peso;
            peso++;
            if (peso == 10) {
                peso = pesoInicial;
            }
        }
        int resto = total % 11;
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);
    }

    /**
     *
     * @param texto
     * @return
     */
    public static String capitalizaTexto2(String texto) {

        // onde houver . ou / não mexe
        StringBuilder construtorPalavra = null;
        if (texto.contains("/") || texto.contains(".")) {
            String[] split = texto.split("\\s");
            List<String> listaPalavrasComBarra = new ArrayList<>();
            List<String> asList = Arrays.asList(split);
            construtorPalavra = new StringBuilder();
            for (String palavra : asList) {
                if (palavra.contains("/")) {
                    String[] split1 = palavra.split("\\/");
                    listaPalavrasComBarra.addAll(Arrays.asList(split1));
                    construtorPalavra.append(listaPalavrasComBarra.stream().map(palavraStream -> capitalize(palavraStream)).collect(Collectors.joining("/"))).append(" ");
                } else if (palavra.contains(".")) {
                    String[] split1 = palavra.split("\\.");
                    listaPalavrasComBarra.addAll(Arrays.asList(split1));
                    construtorPalavra.append(listaPalavrasComBarra.stream().map(palavraStream -> capitalize(palavraStream)).collect(Collectors.joining("."))).append(". ");
                } else {
                    construtorPalavra.append(capitalize(palavra)).append(" ");
                }
            }
            return construtorPalavra.toString().trim();
        } else {
            return capitalizaTexto(texto);
        }

    }

    /**
     *
     * @param texto
     * @return
     */
    public static String capitalizaTexto(String texto) {

        String capitalizada = Arrays.stream(texto.split("\\s"))
                .map(s -> capitalize(s))
                .collect(Collectors.joining(" "));
        return capitalizada;
    }

    public StringUtils mapeiaDicionario() {

        List<String> listGrafiaCorreta = Arrays.asList(dicionarioAcentuacao());
        mapGrafiaSemAcento = new HashMap();
        listGrafiaCorreta.stream().forEach(correta -> {
            mapGrafiaSemAcento.put(Strings.eliminateAccent(correta), correta);
        });
        return this;
    }

    /**
     *
     * @param s
     * @return
     */
    public static String capitalize(String s) {

        s = corrigeGrafia(s);
        Set<String> banMinusculo = new HashSet<>(Arrays.asList("da", "do", "das", "dos", "a", "e", "de", "de"));
        Set<String> banMaiusculo = new HashSet<>(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));
        if (!s.isEmpty()) {
            String lc = s.toLowerCase();
            boolean contemBanidosEmMinusculo = banMinusculo.contains(lc);
            if (contemBanidosEmMinusculo) {
                return lc;
            } else {
                String maiusculo = lc.toUpperCase();
                boolean contemBanidosEmMaiusculo = banMaiusculo.contains(maiusculo);
                if (contemBanidosEmMaiusculo) {
                    return maiusculo;
                } else {
                    return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
                }
            }
        } else {

            return s;
        }
    }

    /**
     *
     * @param texto
     * @return
     */
    private static String corrigeGrafia(String texto) {
        String eliminateAccent = Strings.eliminateAccent(texto).toLowerCase();
        if (mapGrafiaSemAcento.containsKey(eliminateAccent)) {
            return (String) mapGrafiaSemAcento.get(eliminateAccent);
        } else {
            return texto;
        }

    }

    private String[] dicionarioAcentuacao() {
        String[] dicionarios = {"água", "rosário", "são", "andré", "antônio", "araújo", "claúdio", "areião",
            "candelária", "capitão", "catalão", "centenário", "josé", "marilândia", "espírito", "estância", "fábrica",
            "funcionário", "funcionários", "candidés", "acácias", "itália", "américa", "libério", "vitória", "jardinópolis",
            "jatobá", "cecília", "joão", "trás", "pés", "pé", "marajó", "amália", "amélia", "marilândia", "fátima",
            "nações", "niterói", "rosário", "olegário", "eustáquio", "lúcio", "paraíso", "petrópolis", "família",
            "coração", "bárbara", "efigênia", "eugênia", "lúcia", "mônica", "eugênio", "cristóvão", "sebastião", "simão", "taboão", "tietê", "íris", "parís", "vitória", "viúva"};
        return dicionarios;
    }

    /**
     * stringRepl.replaceAll("[^0-9]", "");
     *
     * @param stringRepl
     * @return
     */
    public static String apenasNumeros(String stringRepl) {
        return stringRepl.replaceAll("[^0-9]", "");
    }

    public static String removeR$(String stringMoedaRealBr) {
        return stringMoedaRealBr.replaceAll("[R$]", "");
    }

    /**
     * Verifica se tem números na string
     *
     * @param containsNumber
     * @return boolean containsNumber.matches(".*[0-9].*")
     */
    public static boolean containsNumber(String containsNumber) {
        return containsNumber.matches(".*[0-9].*");
    }

    /**
     * Extrair números e adiciona um separador entre eles
     *
     * @param containsNumber string com números
     * @param separador separador
     * @return string com números separados
     */
    public static String extrairNumeros(String containsNumber, String separador) {
        return containsNumber.replaceAll("[^\\d]", separador).trim();
    }

    public static String limitaTamanho(String str,int limite){
        return left(str, limite);
    }
    public static String subStringMaxLength(String str, int maxLength) {
        if (str != null && str.length() > 0) {
            int length = str.length();
            if (length > maxLength) {
                return str.substring(0, maxLength - 1);
            }
        }
        return str;

    }

    /**
     *
     * retorna se possui algum caracter especial que possa atrapalhar o parse de
     * um xml Pattern.compile("[&'\"]");
     *
     * @param strTest
     * @return
     */
    public static boolean possuiCaracteresEspeciaisXml(String strTest) {
        Pattern pattern = Pattern.compile("[&'\"]");
        Matcher matcher = pattern.matcher(strTest);
        return matcher.find();
    }

    /**
     * Remove acentos e cedílha
     *
     * @param stringToRemoveAccent
     * @return
     */
    public static String eliminateAccent(final String stringToRemoveAccent) {
        return Strings.eliminateAccent(stringToRemoveAccent);
    }

    public static String findFirstText(String stringSearch, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(stringSearch);
        if (matcher.find()) {
            String found = matcher.group(1);
            return found;
        } else {
            System.out.println("Not found");
        }
        return null;
    }
}
