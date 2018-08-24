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
public class PratoManha implements Prato {
    
    private final Map<String, String> pratos = new HashMap<>();

    public PratoManha() {
        pratos.put("1", "ovos");
        pratos.put("2", "torrada");
        pratos.put("3", "café");
    }
    
    @Override
    public String getPratosSelecionados(List<String> pedido) {
        
        
        if(isPedidoValido(pedido)) {
            long quantidadeDeBebidas = pedido.stream().filter(p -> p.equals("3")).count();
            if(quantidadeDeBebidas > 1) pratos.put("3", "café (x"+quantidadeDeBebidas+")");
        }else{
            pedido.addAll(pratos.keySet());
        }
        return pedido.stream().sorted().map(p -> pratos.getOrDefault(p, "erro")).distinct().collect(Collectors.joining(", "));
    }
    
    @Override
    public boolean isPedidoValido(List<String> pedidos) {
        
        return !pedidos
                .stream()
                .anyMatch(prato ->  Integer.valueOf(prato) > 3);
    }
    
}
