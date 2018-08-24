package com.github.eduardo;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class ValidarPedido {
   
    public static boolean isPedidoInvalido (String pedido) {
        
        return !(pedido.contains("MANHA") || pedido.contains("NOITE"));
    }
    
}
