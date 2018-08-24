package com.github.eduardo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class NormalizacaoDePedidoTest {
    
    public NormalizacaoDePedidoTest() {
    }

    @Test
    public void testarNormalizarManha() {
        
        String entrada = "Manhã, 1,2,   3";
        String textoNormalizado = NormalizacaoDePedido.normalizar(entrada);
        assertEquals("MANHA,1,2,3", textoNormalizado);
    }
    
    @Test
    public void testarNormalizarNoite() {
        
        String entrada = "Noite, 1,2,   3";
        String textoNormalizado = NormalizacaoDePedido.normalizar(entrada);
        assertEquals("NOITE,1,2,3", textoNormalizado);
    }
    
}
