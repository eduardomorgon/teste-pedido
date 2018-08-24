package com.github.eduardo;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class PratoManhaTest {
    
    public PratoManhaTest() {
    }

    @Test
    public void testGetPratosSelecionados() {
        
        String entrada = "Manha,  1  , 2,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoManha().getPratosSelecionados(pratos);
        
        assertEquals("ovos, torrada, café", pratosSelecionados);
        
    }
    
    @Test
    public void testGetPratosSelecionadosComVariosAcompanhamentos() {
        
        String entrada = "Manha,  1 ,3, 2, 3,3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoManha().getPratosSelecionados(pratos);
        
        assertEquals("ovos, torrada, café (x3)", pratosSelecionados);
        
    }
    
    @Test
    public void testGetPratosSelecionadosErro() {
        
        String entrada = "Manha,  1  ,4, 2, 5, 5,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoManha().getPratosSelecionados(pratos);
        
        assertEquals("ovos, torrada, café, erro", pratosSelecionados);
        
    }

    @Test
    public void testIsPedidoValidoErro() {
        
        String entrada = "Manha,  1  ,4, 2, 3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        boolean pedidoValido = new PratoManha().isPedidoValido(pratos);
        
        assertFalse(pedidoValido);
    }
    
    @Test
    public void testIsPedidoValidoSucesso() {
        
        String entrada = "Manha,  1 , 2,2,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        boolean pedidoValido = new PratoManha().isPedidoValido(pratos);
        
        assertTrue(pedidoValido);
    }
    
}
