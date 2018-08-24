/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.eduardo;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class PedidoUtilTest {

    public PedidoUtilTest() {
    }

    @Test
    public void testExtrairPratosPedidoNoite() {

        String entrada = "Noite,  1  ,4, 2,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        assertEquals("1", pratos.get(0));
        assertEquals("2", pratos.get(1));
        assertEquals("3", pratos.get(2));
        assertEquals("4", pratos.get(3));

    }
    
    @Test
    public void testExtrairPratosPedidoManha() {

        String entrada = "Manhã,  1  ,4, 2,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        assertEquals("1", pratos.get(0));
        assertEquals("2", pratos.get(1));
        assertEquals("3", pratos.get(2));
        assertEquals("4", pratos.get(3));

    }

    @Test
    public void testGetTipoRefeicaoDaEntradaManha() {
        
        String entrada = "Manhã,  1  ,4, 2,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        TipoRefeicao tipoRefeicao = pedidoUtil.getTipoRefeicaoDaEntrada();
        
        assertEquals("MANHA", tipoRefeicao.name());
        assertTrue(tipoRefeicao.equals(TipoRefeicao.MANHA));
    }
    
    @Test
    public void testGetTipoRefeicaoDaEntradaNoite() {
        
        String entrada = "Noite,  1  ,4, 2,   3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        TipoRefeicao tipoRefeicao = pedidoUtil.getTipoRefeicaoDaEntrada();
        
        assertEquals("NOITE", tipoRefeicao.name());
        assertTrue(tipoRefeicao.equals(TipoRefeicao.NOITE));
        
    }

}
