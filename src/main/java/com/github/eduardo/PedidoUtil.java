package com.github.eduardo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class PedidoUtil {
    
    private final String entradaNormalizada;

    public PedidoUtil(String entradaNormalizada) {
        this.entradaNormalizada = entradaNormalizada;
    }
    
    public List<String> extrairPratosPedido() {

        String pratos = entradaNormalizada.replaceAll("^".concat("(MANHA|NOITE)").concat("((.|\\n)*?),"), "");
        return Arrays.asList(pratos.split("\\s*,\\s*"))
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public TipoRefeicao getTipoRefeicaoDaEntrada() {

        if (entradaNormalizada.contains("MANHA")) {
            return TipoRefeicao.MANHA;
        } else {
            return TipoRefeicao.NOITE;
        }
    }
    
}
