/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.pilacola;

/**
 *
 * @author liamy
 */

public class Empleado {
    String codigo;
    String nombre;
    String apPaterno;
    String apMaterno;
    double sueldoBase;
    int ventasRealizadas;
    String estadoCivil;
    int numHijos;
    double sueldoNeto;
    
    double comisionVenta;
    double dsctoImpuesto;
    double dsctoSeguro;

    public Empleado(String codigo, String nombre, String apPaterno, String apMaterno, double sueldoBase, int ventasRealizadas, String estadoCivil, int numHijos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.sueldoBase = sueldoBase;
        this.ventasRealizadas = ventasRealizadas;
        this.estadoCivil = estadoCivil;
        this.numHijos = numHijos;
        
        calcularSueldoNeto();
    }
    
    private void calcularSueldoNeto(){
        double comisionVentas = 0.05 * ventasRealizadas;
        this.comisionVenta = comisionVentas;
        double dsctoSeguro = 0;
        if (estadoCivil.equalsIgnoreCase("soltero")){
            dsctoSeguro = 100;
        }
        else if (estadoCivil.equalsIgnoreCase("casado")){
            if (numHijos > 0){
                dsctoSeguro = 50 + 70 * numHijos;
            }else{
                dsctoSeguro = 120;                
            }
        }
        this.dsctoSeguro = dsctoSeguro;
        double TA = sueldoBase + comisionVentas;
        double dsctoImpuesto = 0;
        if (TA >= 3001){
            dsctoImpuesto = 0.06;
        }
        else if(TA >= 2301){
            dsctoImpuesto = 0.04;            
        }
        else if(TA >= 1500){
            dsctoImpuesto = 0.03;            
        }
        else{
            dsctoImpuesto = 0;            
        }
        double montoDsctoImpuesto = dsctoImpuesto * TA;
        this.dsctoImpuesto = montoDsctoImpuesto;
        this.sueldoNeto = sueldoBase + comisionVentas - montoDsctoImpuesto - dsctoSeguro;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getDsctoSeguro(){
        return dsctoSeguro;
    }
    
    public double getComisionVenta() {
        return comisionVenta;
    }

    public double getDsctoImpuesto() {
        return dsctoImpuesto;
    }    
    
    public double getSueldoNeto(){
        return getSueldoNeto();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }
        
}


//private void mostrarResumen(){
//        double sueldosTotal = 0;
//        double comisionVentasTotal = 0;
//        double dsctoImpuestosTotal = 0;
//        double dsctoPorSeguroTotal = 0;
//        Nodo aux = frente;
//        while (aux != null){
//            sueldosTotal += aux.empleado.sueldoNeto;
//            comisionVentasTotal += aux.empleado.getComisionVenta();
//            dsctoImpuestosTotal += aux.empleado.getDsctoImpuesto();
//            dsctoPorSeguroTotal += aux.empleado.getDsctoSeguro();
//            aux = aux.siguiente;
//        }
//
//        String mensaje = "----- TOTAL A PAGAR POR CONCEPTO DE -----\n";
//        mensaje += "Sueldos: " + sueldosTotal + "\n";
//        mensaje += "Comision ventas: " + comisionVentasTotal + "\n";
//        mensaje += "Descuento por impuestos: " + dsctoImpuestosTotal+ "\n";
//        mensaje += "Descuento por seguros: " + dsctoPorSeguroTotal+ "\n";
//        
//        JOptionPane.showMessageDialog(null, mensaje, "Resumen usando Colas", JOptionPane.INFORMATION_MESSAGE);
//    }    
//
//    private String formatear2Decimales(double valor){
//        DecimalFormat df2 = new DecimalFormat("####.00");
//        return df2.format(valor);
//    }  
//
//        frente = null;
//        fin = null;
//        Object[][] data = {};
//        String[] cabeceras = {"Cod","Nombre","ApPaterno","ApMaterno","SueldoBase","Ventas","EstadoCivil","NumHijos","SueldoNeto"};
//        modeloTablaCola = new DefaultTableModel(data,cabeceras);
//        jTableCola.setModel(modeloTablaCola);