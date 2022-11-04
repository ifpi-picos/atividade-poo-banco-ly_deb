package contabanco;
public class Conta {
    private int numAgencia;
    private int numConta;
    private Cliente cliente;
    protected double saldo;
    private String tipoNotif; 
    private String enderecoVitual;

    public Conta(int numAgencia, int numConta,Double saldo, Cliente cliente, String tipoNotif, String enderecoVitual){
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipoNotif = tipoNotif;
        this.enderecoVitual = enderecoVitual;

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
    public String getTipoNotif() {
        return tipoNotif;
    }
    public void setTipoNotif(String tipoNotif) {
        this.tipoNotif = tipoNotif;
    }
    public String getEnderecoVitual() {
        return enderecoVitual;
    }
    public void setEnderecoVitual(String enderecoVitual) {
        this.enderecoVitual = enderecoVitual;
    }

    public String toStringpub(){
        return "\nNúmero da conta: " + this.getNumConta() +
                "\nNome: " + this.cliente.getNomeCliente() +
                "\nCPF: " + this.cliente.getCpf();
    }
    public String toString(){
        return  "\nNúmero da agencia: " + this.getNumAgencia() + 
                "\nNúmero da conta: " + this.getNumConta() +
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