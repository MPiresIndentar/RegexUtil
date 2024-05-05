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
}
