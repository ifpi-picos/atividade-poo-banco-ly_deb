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
        // TODO Auto-generated method stub
        super.depositar(valor);
    }
    @Override
    public void sacar(Double valor) {
        // TODO Auto-generated method stub
        super.sacar(valor);
    }
    @Override
    public void transferir(Conta contaDeposito, Double valor) {
        // TODO Auto-generated method stub
        super.transferir(contaDeposito, valor);
    }

    

}
