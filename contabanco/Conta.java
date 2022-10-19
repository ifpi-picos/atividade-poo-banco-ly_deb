package contabanco;
public class Conta {
    private static int digitoConta = 1;
    private String numAgencia = "0123";
    private int numConta;
    private int digito;
    private Cliente cliente;
    private double saldo = 0.00f;
    
    public Conta(int numConta,Cliente cliente){
        this.numConta = numConta;
        this.digito = digitoConta;
        this.cliente = cliente;
        digitoConta += 1;
    }
    public String getNumAgencia() {
        return numAgencia;
    }
    public void setNumAgencia(String numAgencia) {
        this.numAgencia = numAgencia;
    }
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public int getDigito() {
        return digito;
    }
    public void setDigito(int digito) {
        this.digito = digito;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String toStringpub(){
        return "\nNUmero da conta: " + this.getNumConta() +
                "\nNome: " + this.cliente.getNomeCliente() +
                "\nCPF: " + this.cliente.getCpf();
    }
    public String toString(){
        return  "\nNUmero da conta: " + this.getNumConta() +
                "\nDigito: " + this.getDigito() +
                "\nNome: " + this.cliente.getNomeCliente() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nSaldo: " + this.getSaldo();
    }
    public void transferir(Conta contaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("Transferencia Realizada com sucesso! ");
        } else {
            System.out.println("Não foi possivel realizar a transferencia!");
        }
    }
    public void sacar(Double valor){
        if(valor >0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realisado com sucesso!");
        } else {
            System.out.println("Não foi possivel realisa o saque!");
        }
    }
    
    public void depositar(Double valor){
        if(valor >0 ){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu Deposito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possive4l realizar o seu deposito!");
        }
    }
    
}
