package cuentas;

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
        return getSaldo();
    }

    public void ingresar(double x) throws Exception {
        if (x < 0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        setSaldo(getSaldo() + x);
    }

    public void retirar(double x) throws Exception {
        if (x <= 0)
            throw new Exception("No se puede retirar una cantidad negativa");
        if (estado() < x)
            throw new Exception("No se hay suficiente saldo");
        setSaldo(getSaldo() - x);
    }

    public boolean transferencia(CCuenta c, double n) throws Exception {
        boolean temp = true;
        if (n < 0) {
            temp = false;
        } else if (getSaldo() >= (n+n*0.06523)) {
            if (n <= 0){
                throw new Exception("No se puede transferir una cantidad negativa");
            } 
            if (estado() < n){
                throw new Exception("No se hay suficiente saldo");
            }    
            setSaldo(getSaldo() - n);
            c.ingresar(n);
        } else {
            temp = false;
        }
        return temp;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the tipoInteres
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * @param tipoInteres the tipoInteres to set
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
}
