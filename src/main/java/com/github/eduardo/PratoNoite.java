package com.github.eduardo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class PratoNoite implements Prato {
    
    private final Map<String, String> pratos = new HashMap<>();

    public PratoNoite() {
        pratos.put("1", "carne");
        pratos.put("2", "batata");
        pratos.put("3", "vinho");
        pratos.put("4", "bolo");
    }
    
    @Override
    public String getPratosSelecionados(List<String> pedido) {
        
        
        if(isPedidoValido(pedido)) {
            long quantidadesDeAcompanhamentos = pedido.stream().filter(p -> p.equals("2")).count();
            if(quantidadesDeAcompanhamentos > 1) pratos.put("2", "batata (x"+quantidadesDeAcompanhamentos+")");
        }else{
            pedido.addAll(pratos.keySet());
        }
        return pedido.stream().sorted().map(p -> pratos.getOrDefault(p, "erro")).distinct().collect(Collectors.joining(", "));
    }
    
    @Override
    public boolean isPedidoValido(List<String> pedidos) {
        
        return !pedidos
                .stream()
                .anyMatch(prato ->  Integer.valueOf(prato) > 4);
    }
    
}
