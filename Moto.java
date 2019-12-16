package trabalho;
public class Moto extends Veiculos{
    private int cilidradas;
    
    public Moto(String placa, int ano, String cor, float km, String marca, float valor, boolean status, int cilindradas)
    {
        super.setPlaca(placa);
        super.setAno(ano);
        super.setCor(cor);
        super.setKm(km);
        super.setMarca(marca);
        super.setValor(valor);
        super.setStatus(status);
        
        this.cilidradas = cilindradas;
    }
    
    @Override
    public String toString(){
        String saida = super.getMarca() + " " + super.getCor()+
                " " + this.getCilidradas() + " cilindradas " +
                " placa " + super.getPlaca() + " tem " + 
                super.getKm() + " km rodados " + "custa "+
                super.getValor() + " (diária)" + " e está " +
                (super.getStatus()? "alugado" : "disponível");
        return saida;
    }
    
    public String mostrarCorERodas(){
        String imprime = "Rodas: 2 Cor: " + super.getCor();
        return imprime;
    }

    public int getCilidradas() {
        return cilidradas;
    }

    public void setCilidradas(int cilidradas) {
        this.cilidradas = cilidradas;
    }
    
}
