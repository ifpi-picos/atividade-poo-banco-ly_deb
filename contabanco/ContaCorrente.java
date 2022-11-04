package contabanco;

public class ContaCorrente extends Conta {
    Double chequeSepecial = 0.00;
    private int contador;
    
    public ContaCorrente(int contador, Double chequeSepecial, int numAgencia, int numConta, Double saldo, Cliente cliente, String tipoNotif, String enderecoVitual) {
        super(numAgencia, numConta, saldo, cliente, tipoNotif, enderecoVitual);
        this.contador = 0;
        this.chequeSepecial = 0.00;
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
        if(valor > 0 ){
            setChequeSepecial(getChequeSepecial() + valor);
        }else {
            System.out.println("Não foi possivel realizar o seu deposito!");
        }
    }
    
    
    public void sacarCheque(Double valor) {
        if(this.chequeSepecial == -6000.00){
            System.out.println("Não foi possivel realisa o saque!");
        } else {
            setChequeSepecial(getChequeSepecial() - valor);
            System.out.println("Saque Realisado com sucesso!");
        }
    }
    
    public void contadorTransferencia(ContaCorrente contaRemetente, Double valor){
        this.contador += 1;
        if(this.contador > 2){
            Double taxa = (valor * 5)/100; 
            setChequeSepecial(getChequeSepecial() - taxa);
        }
    }
    @Override
    /*public void transferir(Conta contaDeposito, Double valor) {
        super.transferir(contaDeposito, valor);

    }*/
    public void transferir(Conta contaDeposito, Double valor){
        if(valor > 0 && this.getChequeSepecial() <= -6000){
            System.out.println("Não foi possivel realizar a transfêrencia!");
        } else {
            setChequeSepecial(getChequeSepecial() -valor);
            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("Transfêrencia Realizada com Sucesso!");
        }
    }

    public void transferirCP(ContaPoupanca contaDeposito, Double valor){
        if(valor > 0 && this.getChequeSepecial() <= -6000){
            System.out.println("Não foi possivel realizar a transfêrencia!");
        } else {
            setChequeSepecial(getChequeSepecial() -valor);
            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("Transfêrencia Realizada com Sucesso!");
        } 
    }
    public void transferirCC(ContaCorrente contaDeposito, Double valor){
        if(valor > 0 && this.getChequeSepecial() <= -6000){
            System.out.println("Não foi possivel realizar a transfêrencia!");
        } else {
            setChequeSepecial(getChequeSepecial() -valor);
            contaDeposito.chequeSepecial = contaDeposito.getChequeSepecial() + valor;
            System.out.println("Transfêrencia Realizada com sucesso!");
        }
    }
  
}
