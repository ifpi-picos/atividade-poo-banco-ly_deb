package contabanco;

public class ContaCorrente extends Conta {
    private Double chequeSepecial = 6000.00;
    private int contador;

    public ContaCorrente(int contador, Double chequeSepecial, int numAgencia, int numConta, Double saldo, Cliente cliente) {
        super(numAgencia, numConta, saldo, cliente);
        this.contador = 0;
        this.chequeSepecial = 6000.00;
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
        if(this.chequeSepecial < 6000.00){
            double falta = 6000.00 - getChequeSepecial();
            if(valor >= falta){
                setChequeSepecial(getChequeSepecial() + falta);
                double resto = valor - falta;
                if(resto != 0.00){
                    super.depositar(resto);
                    System.out.println("Depositado em conta:");
                    System.out.println(resto);
                }
                System.out.println("Depositado em cheque especial:");
                System.out.println(falta);
            }
            super.depositar(valor);
        }else{
            System.out.println("Depositado em conts:");
            super.depositar(valor);
        }
    }
    
    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
    }
    
    public void sacarCheque(Double valor) {
        if(valor > 0 && this.chequeSepecial >= valor){
            setChequeSepecial(getChequeSepecial() - valor);
            System.out.println("Saque Realisado com sucesso!");
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
        super.transferir(contaDeposito, valor);

    }
  
}
