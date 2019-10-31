package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

    public static void main(String[] args) {

        Collection<Integer> numeros = new ArrayList<Integer>();

        long inicioIN = System.currentTimeMillis();

        for (int i = 1; i <= 1000000; i++) {
            numeros.add(i);
        }
        long fimIN = System.currentTimeMillis();
        long tempoDeExecucaoIN = fimIN - inicioIN;

        System.out.println("Tempo gasto para inserçao: " + tempoDeExecucaoIN);

        long inicioBUS = System.currentTimeMillis();
        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fimBUS = System.currentTimeMillis();

        long tempoDeExecucaoBUS = fimBUS - inicioBUS;

        System.out.println("Tempo gasto BUSCA: " + tempoDeExecucaoBUS);

    }
//    Tempo gasto para inserçao: 12 HASH
//    Tempo gasto BUSCA: 8

//    Tempo gasto para inserçao: 5 list
//    Tempo gasto BUSCA: 1152

}