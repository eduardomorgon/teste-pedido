package com.github.eduardo;

import java.text.Normalizer;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class NormalizacaoDePedido {
    
    public static String normalizar(String entrada) {

        return Normalizer
                .normalize(entrada, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("( )+", "")
                .toUpperCase();
    }

}
