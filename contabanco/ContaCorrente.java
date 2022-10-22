package contabanco;

public class ContaCorrente extends Conta {
    private Double chequeSepecial;
    private int contador;

    public ContaCorrente(int contador, Double chequeSepecial, int numAgencia, int numConta, Double saldo, Cliente cliente) {
        super(numAgencia, numConta, saldo, cliente);
        this.contador = 0;
        this.chequeSepecial = 6000.00;
        //TODO Auto-generated constructor stub
    }
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    
    public Double getChequeSepecial() {
        return chequeSepecial;
    }

    public void setChequeSepecial(Double chequeSepecial) {
        this.chequeSepecial = chequeSepecial;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public void depositar(Double valor) {
        super.depositar(valor);
    }
    
    @Override
    public void sacar(Double valor) {
        // TODO Auto-generated method stub
        super.sacar(valor);
    }
    
    public void sacarCheque(Double valor) {
        if(valor > 0 && this.chequeSepecial >= valor){
            setChequeSepecial(getChequeSepecial() - valor);
            System.out.println("Saque realisado com sucesso!");
        } else {
            System.out.println("Não foi possivel realisa o saque!");
        }
    }
    
    public void contadorTransferencia(ContaCorrente contaRemetente, Double valor){
        this.contador += 1;
        if(this.contador > 2){
            Double taxa = (valor * 5)/100; 
            setSaldo(getSaldo() - taxa);
        }
    }
    @Override
    public void transferir(Conta contaDeposito, Double valor) {
        // TODO Auto-generated method stub
        super.transferir(contaDeposito, valor);

    }
  
}
