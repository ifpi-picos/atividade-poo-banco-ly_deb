package contabanco;
public class Conta {
    private static int digitoConta = 1;
    private int numAgencia;
    private int numConta;
    private int digito;
    private Cliente cliente;
    private double saldo;
    
    public Conta(int numAgencia, int numConta,Double saldo, Cliente cliente){
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.saldo = saldo;
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
        return "\nNúmero da conta: " + this.getNumConta() +
                "\nNome: " + this.cliente.getNomeCliente() +
                "\nCPF: " + this.cliente.getCpf();
    }
    public String toString(){
        return  "\nNúmero da agencia: " + this.getNumAgencia() + 
                "\nNúmero da conta: " + this.getNumConta() +
                "\nDigito: " + this.getDigito() +
                "\nSaldo: " + this.getSaldo();
    }
    public void transferir(Conta contaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("Transferencia Realizada com sucesso!");
        } else {
            System.out.println("Não foi possivel realizar a transfêrencia!");
        }
    }
    public void sacar(Double valor){
        if(valor >0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possivel realizar o saque!");
        }
    }
    
    public void depositar(Double valor){
        if(valor > 0 ){
            setSaldo(getSaldo() + valor);
        }else {
            System.out.println("Não foi possivel realizar o seu deposito!");
        }
    }
    
}