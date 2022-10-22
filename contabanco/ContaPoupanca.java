package contabanco;

public class ContaPoupanca extends Conta{
   

    public ContaPoupanca(int numAgencia, int numConta, Double saldo, Cliente cliente) {
        super(numAgencia, numConta, saldo, cliente);
        //TODO Auto-generated constructor stub
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
        // TODO Auto-generated method stub
        super.sacar(valor);
    }
    public void taxaDeTransferencia(ContaPoupanca contaRemetente, Double valor){
            Double taxa = (valor * 5)/100; 
            setSaldo(getSaldo() - taxa);
    }


    @Override
    public void transferir(Conta contaDeposito, Double valor) {
        // TODO Auto-generated method stub
        super.transferir(contaDeposito, valor);
    }

    

}
