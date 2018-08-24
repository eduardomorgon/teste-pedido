package com.github.eduardo;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class TesteExemplo {
    
    @Test
    public void testarEntradasPropostasExemplos1() {
        
        String entrada = "manhã, 1, 2, 3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoManha().getPratosSelecionados(pratos);
        
        assertEquals("ovos, torrada, café", pratosSelecionados);
        
    }
    
    @Test
    public void testarEntradasPropostasExemplos2() {
        
        String entrada = "manhã, 2, 1, 3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoManha().getPratosSelecionados(pratos);
        
        assertEquals("ovos, torrada, café", pratosSelecionados);
        
    }
    
    @Test
    public void testarEntradasPropostasExemplos3() {
        
        String entrada = "manhã, 1, 2, 3, 4";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoManha().getPratosSelecionados(pratos);
        
        assertEquals("ovos, torrada, café, erro", pratosSelecionados);
        
    }
    
    @Test
    public void testarEntradasPropostasExemplos4() {
        
        String entrada = "manhã, 1, 2, 3, 3, 3";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoManha().getPratosSelecionados(pratos);
        
        assertEquals("ovos, torrada, café (x3)", pratosSelecionados);
        
    }
    
    @Test
    public void testarEntradasPropostasExemplos5() {
        
        String entrada = "noite, 1, 2, 3, 4";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoNoite().getPratosSelecionados(pratos);
        
        assertEquals("carne, batata, vinho, bolo", pratosSelecionados);
        
    }
    
    @Test
    public void testarEntradasPropostasExemplos6() {
        
        String entrada = "noite, 1, 2, 2, 4";
        String entradaNormalizada = NormalizacaoDePedido.normalizar(entrada);
        
        PedidoUtil pedidoUtil = new PedidoUtil(entradaNormalizada);
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pratosSelecionados = new PratoNoite().getPratosSelecionados(pratos);
        
        assertEquals("carne, batata (x2), bolo", pratosSelecionados);
        
    }
    
}
