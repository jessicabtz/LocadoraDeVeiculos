package trabalho;
public abstract class Veiculos {
    private String cor;
    private String placa;
    private String marca_e_tipo;
    private float valor;
    private float km_rodado;
    private int ano_fabricacao;
    private boolean status;
    
    public static Veiculos criarVeiculo(int op,String placa, int ano, String cor, float km, String marca, float valor, int porta_cilindradas)
    {
        boolean status = false;
        if (op == 1)
            return new Carro(placa, ano, cor, km, marca, valor, status, porta_cilindradas);
        
        return new Moto(placa, ano, cor, km, marca, valor, status, porta_cilindradas);
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public void setPlaca(String p){
        this.placa = p;
    }
    
    public int getAno(){
        return ano_fabricacao;
    }
    
    public void setAno(int a){
        this.ano_fabricacao = a;
    }
    
    public String getMarca(){
        return marca_e_tipo;
    }
    
    public void setMarca(String m){
        this.marca_e_tipo = m;
    }
    
    public float getKm(){
        return km_rodado;
    }
    
    public void setKm(float k){
        this.km_rodado = k;
    }
    
    public boolean getStatus(){
        return status;
    }
    
    public void setStatus(boolean s){
        this.status = s;
    }
    
    public float getValor(){
        return valor;
    }
    
    public void setValor(float v ){
        this.valor = v;
    }
    public String getCor(){
        return cor;
    }
    
    public void setCor(String c){
        this.cor = c;
    }
    
}
