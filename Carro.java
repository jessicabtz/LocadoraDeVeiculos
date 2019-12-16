package trabalho;
public class Carro extends Veiculos {
    private int qtd_portas;

    public Carro(String placa, int ano, String cor, float km, String marca, float valor, boolean status, int qtd)
    {
        super.setPlaca(placa);
        super.setAno(ano);
        super.setCor(cor);
        super.setKm(km);
        super.setMarca(marca);
        super.setValor(valor);
        super.setStatus(status);
        this.qtd_portas = qtd;
    }
    
    @Override
    public String toString(){
        String saida = super.getMarca() + " " + super.getCor()+
                " " +this.getQtd_portas() + " portas " +
                " placa " + super.getPlaca() + " tem " + 
                super.getKm() + " km rodados " + "custa "+
                super.getValor() + " (diária)" + " e está " +
                (super.getStatus()? "alugado" : "disponível");
        return saida;
    }
    
    public String mostrarCorERoda(){
        String imprime = "Rodas: 4 Cor: " + super.getCor();
        return imprime;
    }

    public int getQtd_portas() {
        return qtd_portas;
    }

    public void setQtd_portas(int qtd_portas) {
        this.qtd_portas = qtd_portas;
    }
 }
