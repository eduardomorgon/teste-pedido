package com.github.eduardo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class ValidarPedidoTest {
    
    public ValidarPedidoTest() {
    }

    @Test
    public void testIsPedidoInvalido() {
        
        String entrada = "TTTT,  1  ,4, 2, 3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        boolean pedidoNaoValido = ValidarPedido.isPedidoInvalido(entradaNormalizada);
        assertTrue(pedidoNaoValido);
    }
    
    @Test
    public void testIsPedidoValido() {
        
        String entrada = "manha,  1  ,4, 2, 3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        boolean pedidoNaoValido = ValidarPedido.isPedidoInvalido(entradaNormalizada);
        assertFalse(pedidoNaoValido);
    }
    
    
    
}
