package com.mycompany.ud4_p4_banco;

public class CCuenta {

    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInteres;

    public CCuenta() {
    }

    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
    }

    public double estado() {
        return saldo;
    }

    public void ingresar(double x) throws Exception {
        if (x < 0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        saldo = saldo + x;
    }

    public void retirar(double x) throws Exception {
        if (x <= 0)
            throw new Exception("No se puede retirar una cantidad negativa");
        if (estado() < x)
            throw new Exception("No se hay suficiente saldo");
        saldo = saldo - x;
    }

    public boolean transferencia(Cuenta c, double n) {
        boolean temp = true;
        if (n < 0) {
            temp = false;
        } else if (saldo >= (n+n*0.06523)) {
            if (n <= 0){
                throw new Exception("No se puede transferir una cantidad negativa");
            } 
            if (estado() < n){
                throw new Exception("No se hay suficiente saldo");
            }    
            saldo = saldo - n;
            c.ingresar(n);
        } else {
            temp = false;
        }
        return temp;
    }
}
