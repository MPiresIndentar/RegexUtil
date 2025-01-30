/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.indentar.com.regexutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marlucio
 */
public class BrasilRegexUtil {

    public static boolean isPlaca(String placa) {
        placa = placa.replaceAll("-", "").toUpperCase();
        String regex = "\\b[A-Z]{3}\\d{1}[A-Z0-9]{1}\\d{2}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
    }

    public static String toWhatsNumberBr(String number, String defaultDDD, boolean remover9) {
        number = number.replaceAll("[^0-9]", "");
        int length = number.length();
        switch (length) {
            case 8:
                number = "55".concat(defaultDDD).concat(number);
                break;
            case 9:
                char primeiroNumero = number.charAt(0);
                if (primeiroNumero == '9' && remover9) {
                    number = "55".concat(defaultDDD).concat(number.substring(1));
                } else {
                    number = "55".concat(defaultDDD).concat(number);
                }
                break;
            case 10:
                number = "55".concat(number);
                break;
            case 11:
                char primeiroNumeroEm11 = number.charAt(0);
                if (primeiroNumeroEm11 == '9' && remover9) {
                    number = "55".concat(number.substring(1));
                } else {
                    number = "55".concat(number);
                }
                break;
        }
        return number;
    }
}
