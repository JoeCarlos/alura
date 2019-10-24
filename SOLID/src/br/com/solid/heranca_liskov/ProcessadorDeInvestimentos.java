package br.com.solid.heranca_liskov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessadorDeInvestimentos {

    public static void main(String[] args) {

//        for (ContaComum conta : contasDoBanco()) {
//            conta.rende();
//
//            System.out.println("Novo Saldo:");
//            System.out.println(conta.getSaldo());
//        }
    List<ContaComum> contas = new ArrayList<ContaComum>();
    	contas.add(new ContaComum());
    	contas.add(new ContaDeEstudante());
    	contas.get(0).deposita(20000);
    	System.out.println(contas.get(0).getSaldo() + " ---------- ");
    	System.out.println(contas.get(1).getSaldo() + " ---------- ");
    }

//    private static List<ContaComum> contasDoBanco() {
//        return Arrays.asList(umaContaCom(100), umaContaCom(150), contaDeEstudanteCom(200));
//    }

//    private static ContaComum contaDeEstudanteCom(double amount) {
//        ContaDeEstudante c = new ContaDeEstudante();
//        c.deposita(amount);
//        return c;
//    }
//
//    private static ContaComum umaContaCom(double valor) {
//        ContaComum c = new ContaComum();
//        c.deposita(valor);
//        return c;
//    }
}
