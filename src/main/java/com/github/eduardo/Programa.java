package com.github.eduardo;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eduardo Morgon <eduardo.morgon at gmail.com>
 */
public class Programa {

    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in, "ISO-8859-1");

        System.out.println("Digite sua refeição separado por virgula: ");
        

        String entrada = NormalizacaoDePedido.normalizar(scanner.nextLine());
        
        if(ValidarPedido.isPedidoInvalido(entrada)) {
            System.err.println("Pedido informado não é valido, favor validar!");
            System.exit(0);
        }
        PedidoUtil pedidoUtil = new PedidoUtil(entrada);
        TipoRefeicao refeicao = pedidoUtil.getTipoRefeicaoDaEntrada();
        List<String> pratos = pedidoUtil.extrairPratosPedido();
        
        String pedido = refeicao.getPrato().getPratosSelecionados(pratos);
        
        System.out.println(pedido);


    }

}
