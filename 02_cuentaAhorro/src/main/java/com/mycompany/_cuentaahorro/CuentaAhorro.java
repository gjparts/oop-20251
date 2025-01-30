package com.mycompany._cuentaahorro;

/**
 * Describe a una cuenta de ahorro de una institucion bancaria
 * @author Gerardo Portillo
 * @since  2025-01-30
 */
public class CuentaAhorro {
    //atributos
    public String nombreCliente;
    public String numeroCuenta;
    public float saldo;
    //constructores
    /**
     * Construye un objeto de clase Cuenta de Ahorro
     * @param nombreCliente el nombre del cuenta-habiente
     * @param numeroCuenta  el numero de la cuenta bancaria
     */
    public CuentaAhorro(String nombreCliente, String numeroCuenta){
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.00f;
    }
    //metodos
    /**
     * Retorna el saldo actual de la cuenta
     * @return un valor float
     */
    public float getSaldo(){
        return this.saldo;
    }
    /**
     * Deposita un monto determinado en la cuenta de ahorro aumentando su saldo
     * @param monto un valor float >= 0
     */
    public void depositar(float monto){
        if( monto >= 0 )
            this.saldo += monto; //se acepta
        else
            throw new IllegalArgumentException("No se puede depositar montos negativos.");
    }
    /**
     * Retira un monto determinado de la cuenta de ahorro, disminuyendo su saldo.
     * @param monto un valor float >= 0
     */
    public void retirar(float monto){
        if( monto < 0 )
            throw new IllegalArgumentException("No se puede retirar montos negativos");
        else
            if( monto > this.saldo )
                throw new IllegalArgumentException("No se puede retirar mas del saldo disponible.");
            else
                this.saldo -= monto; //se ascepta
    }
}
