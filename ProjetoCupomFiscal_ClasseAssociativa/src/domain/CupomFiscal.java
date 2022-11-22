/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mpisc
 */
public class CupomFiscal {
    private int numero;
    private Date data;
    private Date hora;
    
    private List<ItemCupom> itensCupom;

    public List<ItemCupom> getItensCupom() {
        return itensCupom;
    }
    
    public void add(ItemCupom item) {
        if (itensCupom == null) {
            itensCupom = new ArrayList<>();
        }
        itensCupom.add(item);
        item.setCupomFiscal(this);
    }
    
    public void remove(ItemCupom item) {
        itensCupom.remove(item);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    public String getCupom() {
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("**** CUPOM FISCAL ****").append("\n");
        sb.append("Data: " ).append(sdfData.format(data)).append("  Hora: ").
                append(sdfHora.format(hora)).append("  COD: ").append(numero).
                append("\n");
        sb.append("=============================================").append("\n");
        int i = 0;
        for (ItemCupom ic: itensCupom) {
            sb.append(++i).append(" ").append(ic.getProduto().getCodigo()).append(" ").
                    append(ic.getProduto().getDescricao()).
                    append("\t").append(ic.getQuantidade()).append("\t").
                    append(ic.getPrecoComDesconto()).append("\t\t").
                    append(ic.calcularTotal()).append("\n");
        }
        sb.append("=============================================").append("\n");
        sb.append("TOTAL\t\t\t\t\t").append(calcularTotalCupom()).append("\n");
        sb.append("Obrigado pela preferência!!!").append("\n");
        return sb.toString();
    }
    
    public double calcularTotalCupom() {
        double total = 0.0;
        for (ItemCupom ic: itensCupom) {
            total += (ic.getPrecoComDesconto() * ic.getQuantidade());
        }
        return total;
    }
    
}
