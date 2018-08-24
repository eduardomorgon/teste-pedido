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

//    public List<String> extrairPratosPedido() {
//
//        String pratos = entrada.replaceAll("^".concat("(MANHA|NOITE)").concat("((.|\\n)*?),"), "");
//        return Arrays.asList(pratos.split("\\s*,\\s*"))
//                .stream()
//                .sorted()
//                .collect(Collectors.toList());
//    }
//
//    public TipoRefeicao getTipoRefeicaoDaEntrada() {
//
//        if (entrada.contains("MANHA")) {
//            return TipoRefeicao.MANHA;
//        } else {
//            return TipoRefeicao.NOITE;
//        }
//    }

}
