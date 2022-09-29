package contabanco;
import java.time.LocalDate;
public class Cliente {
    private String nomeCliente;
    private LocalDate dataDeNasc;
    private String cpf;



    public Cliente (String nomeCliente, LocalDate dataDeNasc, String cpf){
        this.nomeCliente = nomeCliente;
        this.dataDeNasc = dataDeNasc;
        this.cpf = cpf;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public LocalDate getDataDeNasc() {
        return dataDeNasc;
    }
    public void setDataDeNasc(LocalDate dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String toString(){
        return "\nNome: " + this.getNomeCliente() +
                "\nCPF: " + this.getCpf() +
                "\nData de Nascimento: " + this.getDataDeNasc();
    }
}
