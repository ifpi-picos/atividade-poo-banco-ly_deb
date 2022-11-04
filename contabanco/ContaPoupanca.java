package contabanco;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(int numAgencia, int numConta, Double saldo, Cliente cliente,String tipoNotif, String enderecoVitual) {
        super(numAgencia, numConta, saldo, cliente, tipoNotif, enderecoVitual);
    }
    public String toString() {
        return super.toString();
    }
    @Override
    public void depositar(Double valor) {
        valor += (valor * 10)/ 100;
        super.depositar(valor);
    }
    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
    }
    public void taxaDeTransferencia(ContaPoupanca contaRemetente, Double valor){
            Double taxa = (valor * 5)/100; 
            setSaldo(getSaldo() - taxa);
    }
    @Override
    public void transferir(Conta contaDeposito, Double valor) {
        super.transferir(contaDeposito, valor);
    }
    public void transferirpC(ContaCorrente contaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaDeposito.chequeSepecial = contaDeposito.getChequeSepecial() + valor;
            System.out.println("Transferencia Realizada com sucesso!");
        } else {
            System.out.println("Não foi possivel realizar a transfêrencia!");
        }
    }
    

}
