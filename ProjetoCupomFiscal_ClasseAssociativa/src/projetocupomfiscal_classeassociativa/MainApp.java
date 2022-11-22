/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetocupomfiscal_classeassociativa;

import domain.CupomFiscal;
import domain.ItemCupom;
import domain.Produto;
import java.util.Date;

/**
 *
 * @author mpisc
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Produto p1 = new Produto(1234, "Blusa", "Vestuario", 120.00);
        Produto p2 = new Produto(1235, "Perfume", "Perfumaria", 320.00);
        Produto p3 = new Produto(1236, "Sapato", "Calçados", 220.00);
        
        CupomFiscal cf1 = new CupomFiscal();
        cf1.setData(new Date());
        cf1.setHora(new Date());
        cf1.setNumero(1);
        
        ItemCupom ic1 = new ItemCupom();
        ic1.setProduto(p1);
        ic1.setQuantidade(2);
        cf1.add(ic1);
        
        ItemCupom ic2 = new ItemCupom();
        ic2.setProduto(p3);
        ic2.setQuantidade(1);
        cf1.add(ic2);
        ic2.setPrecoComDesconto(200.0);
        
        imprimir(cf1);
    }

    private static void imprimir(CupomFiscal cf1) {
        System.out.println(cf1.getCupom());
    }
    
}
