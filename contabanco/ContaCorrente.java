package contabanco;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numAgencia, int numConta, Double saldo, Cliente cliente) {
        super(numAgencia, numConta, saldo, cliente);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void depositar(Double valor) {
        valor += (valor * 10)/100;
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
