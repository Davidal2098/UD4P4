package cuentas;

public class Main {

    public static void main(String[] args) {
        CCuenta cuentaDavidVidal;
        double saldoActual;

        cuentaDavidVidal = new CCuenta("TU_NOMBRE_APELLIDOS","1000-4500-45-1230456789",2500,0);
        saldoActual = cuentaDavidVidal.estado();
        System.out.println("El saldo actual es"+ saldoActual );

        operativa_cuenta(cuentaDavidVidal);
    }

    private static void operativa_cuenta(CCuenta cuentaDavidVidal) {
        try {
            cuentaDavidVidal.retirar(2300);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en cuenta");
            cuentaDavidVidal.ingresar(695);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }
}
