package com.github.eduardo;

import java.util.List;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public interface Prato {
    
    String getPratosSelecionados(List<String> pedido);
    boolean isPedidoValido(List<String> pedidos);
    
}
