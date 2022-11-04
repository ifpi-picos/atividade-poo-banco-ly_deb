package contabanco;
import java.time.LocalDate;
import java.util.Calendar;
public class Cliente {
    private String nomeCliente;
    private LocalDate dataDeNasc;
    private String cpf;
    private Endereco endereco;
   
    //ver o tipo de notificação com o equals depois chamar o metodo com o tipo
    //static no sistema(obs. colocar o endereço eletronico do remetente(bancoMaut) e do destinatario)

    public Cliente (){   
    }
    
    public Cliente (String nomeCliente, LocalDate dadDeNasc, String cpf, Endereco endereco){
        this.nomeCliente = nomeCliente;
        this.dataDeNasc = dadDeNasc;
        this.cpf = cpf;
        this.endereco = endereco;
       
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
    public String checaData(LocalDate dataDeNasc){
        Calendar c = Calendar.getInstance();
        if ((c.get(Calendar.YEAR) - dataDeNasc.getYear()) >= 18 && (c.get(Calendar.YEAR) - dataDeNasc.getYear()) < 100){
            return "Y";
        } else if (c.get(Calendar.YEAR) - dataDeNasc.getYear() < 18){
            return "M";
        } else{
            return "I";
        }
    }
    public String checaCPF(String cpf){
        cpf = cpf.trim();
        cpf = cpf.replace("-", "");
        cpf = cpf.replace(".", "");
        cpf = cpf.replace(",", "");
        boolean isnum = cpf.matches("[+-]?\\d*(\\.\\d+)?");
        if(cpf.length() == 11 && isnum == true){
            return "V";
        } else if (cpf.length() == 11 && isnum == false){
            return "Il";
        } else if (isnum == true && (cpf.length() > 11 || cpf. length() < 11)){
            return "In";
        }else{
            return "I";
        }
    }
    public boolean checarString(String nome){
      boolean isletra = nome.matches(nome);
        return isletra;
    }
   
}