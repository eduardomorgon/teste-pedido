package com.github.eduardo;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class PratoNoiteTest {
    
    public PratoNoiteTest() {
    }

    @Test
    public void testGetPratosSelecionados() {
        
        String entrada = "Noite,  1  ,4, 2,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoNoite().getPratosSelecionados(pratos);
        
        assertEquals("carne, batata, vinho, bolo", pratosSelecionados);
        
    }
    
    @Test
    public void testGetPratosSelecionadosComVariosAcompanhamentos() {
        
        String entrada = "Noite,  1  ,4, 2,  2,2, 3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoNoite().getPratosSelecionados(pratos);
        
        assertEquals("carne, batata (x3), vinho, bolo", pratosSelecionados);
        
    }
    
    @Test
    public void testGetPratosSelecionadosErro() {
        
        String entrada = "Noite,  1  ,4, 2, 5, 5,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoNoite().getPratosSelecionados(pratos);
        
        assertEquals("carne, batata, vinho, bolo, erro", pratosSelecionados);
        
    }

    @Test
    public void testIsPedidoValidoErro() {
        
        String entrada = "Noite,  1  ,4, 2, 5, 5,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        boolean pedidoValido = new PratoNoite().isPedidoValido(pratos);
        
        assertFalse(pedidoValido);
    }
    
    @Test
    public void testIsPedidoValidoSucesso() {
        
        String entrada = "Noite,  1  ,4, 2,2,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        boolean pedidoValido = new PratoNoite().isPedidoValido(pratos);
        
        assertTrue(pedidoValido);
    }
    
}
