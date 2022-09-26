package contabanco;
import java.util.Date;

public class Cliente {
    private String nomeCliente;
    private Date dataDeNasc;
    private String cpf;



    public Cliente (String nomeCliente, Date dadDeNasc, String cpf){
        this.nomeCliente = nomeCliente;
        this.dataDeNasc = dadDeNasc;
        this.cpf = cpf;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public Date getDataDeNasc() {
        return dataDeNasc;
    }
    public void setDataDeNasc(Date dataDeNasc) {
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
