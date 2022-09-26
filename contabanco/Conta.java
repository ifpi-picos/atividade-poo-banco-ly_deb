package contabanco;

import java.util.Random;

public class Conta {
    private static int digitoConta = 1;
    private int numAgencia;
    private int numConta;
    private int digito;
    public int getDigito() {
        return digito;
    }
    public void setDigito(int digito) {
        this.digito = digito;
    }
    private Cliente cliente;
    private double saldo = 0.00f;
    Random random = new Random();
    
    
    public Conta(Cliente cliente){

        this.numConta = random.nextInt(99999)+1000;
        this.digito = digitoConta;
        this.cliente = cliente;
        digitoConta += 1;
    }
    public int getNumAgencia() {
        return numAgencia;
    }
    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String toString(){
        return  "\nNUmero da conta: " + this.getNumConta() +
                "\nDigito: " + this.getDigito() +
                "\nNome: " + this.cliente.getNomeCliente() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nSaldo: " + this.getSaldo();
    }
    
}
