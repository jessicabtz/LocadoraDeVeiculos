package trabalho;

import java.util.HashMap;
import java.util.Scanner;

public class Aluguel{
    private float valor_total = 0;
    private String data_aluguel;
    private String data_prazo;
    private static HashMap<String, Veiculos> veiculos = new HashMap<>();
    private static HashMap<Integer,Cliente> clientes = new HashMap<>();
    
    private Cliente cliente;
    private Veiculos veiculo;
    
    Scanner s = new Scanner(System.in);
    Scanner d = new Scanner(System.in);
    
    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public String getData_aluguel() {
        return data_aluguel;
    }

    public void setData_aluguel(String data_aluguel) {
        this.data_aluguel = data_aluguel;
    }

    public String getData_prazo() {
        return data_prazo;
    }

    public void setData_prazo(String data_prazo) {
        this.data_prazo = data_prazo;
    }
                   
    public void addVeiculo(int op, String placa, int ano, String cor, float km, String marca, float valor, int porta_cilindradas){
        Veiculos veiculo1 = Veiculos.criarVeiculo(op, placa, ano, cor, km, marca, valor, porta_cilindradas);        
        this.veiculos.put(placa, veiculo1);
    }
    
     public void removeVeiculo (String placa){
        this.veiculos.remove(placa);
    }
    
    public void imprimirVeiculos()
    {
        this.veiculos.values().forEach(veiculo -> {
            System.out.println(veiculo);
        });
    }
    
    public void addCliente(String nome, String endereco, int idade, int cpf, int cnh, float renda){
        Cliente cliente1 = new Cliente(nome, endereco, idade, cpf, cnh, renda);         
        this.clientes.put(cpf, cliente1); 
    }
    
    public String alterarCliente(String nome, String endereco, int idade, int cpf, int cnh, float renda){

        for(Cliente c : clientes.values())
        {
            int cpf1 = c.getCpf();
            Cliente c1 = c;
            
            if(cpf1 == cpf)
            {
                c1.setNome(nome);
                c1.setEndereco(endereco);
                c1.setIdade(idade);
                c1.setCpf(cpf);
                c1.setCnh(cnh);
                c1.setRenda_mensal(renda);
                
                return "Cliente alterado com sucesso";
            }
             
        }
        return "Erro ao alterar cliente";
    }
    
    public void imprimirClientes()
    {
                this.clientes.values().forEach(cliente -> {
                    System.out.println(cliente);
                });
    }
    
    public Cliente verificaCondicoesDeAluguel(int cpf)
    {
        for(Cliente c: clientes.values())
        {
            int cpf1 = c.getCpf();
            Cliente c2 = c;

            if(cpf1 == cpf)
            {
                if(c2.getIdade()>=18) //ver se a idade do cliente é maior que 18
                {
                    if(c2.getRenda_mensal()>15000) //verificar a renda mensal do cliente(cada renda da direito a um limite em aluguel)
                    {
                        c2.setLimite(3000);
                    } 
                    else if(c2.getRenda_mensal()>5000)
                    {
                        c2.setLimite(1000);
                    }
                    else
                    {
                        c2.setLimite(100); 
                    }
                    return c2;
                }
                else
                {
                    return null;
                }
            }
            
        }
        return null;
    }
    
    public String alugar(String placa, String data1, String data2, int dias, Cliente c){
        
        for(Veiculos v : veiculos.values()){
//        this.veiculos.values().forEach(v -> {
            String placa1 = v.getPlaca();
            Veiculos v1 = v;
            
            if(placa1.equals(placa))
            {
                if(v1.getStatus() == false)//ver se o status alugado do veiculo é false
                {
                    if(v1.getValor()<= c.getLimite())// se o valor estiver dentro do limite de aluguel de acordo com a renda esta tudo certo
                    {
                        setData_aluguel(data1);

                        setData_prazo(data2);
                        
                        float valor_total = (v1.getValor()* dias);
                        
                        setValor_total(valor_total + getValor_total()); // pegar o valor do veiculo e multiplicar pela quantidade de dias e adicionar em valor total
                        
                        v1.setStatus(true); //trocar status para true
                        
                        this.cliente = c;
                        this.veiculo = v1; 
                        
                        return "Alugado com sucesso";
                                              
                    } else {
                        
                        return "O carro desejado está cima de seu limite"; 
                    }
                                         
                }
                else
                {
                    return "O veiculo encontra-se alugado";
                }
            }
        }
        
        return "Não foi possível alugar" ;     
    }
    
    public void mostrarVeiculosAlugados(HashMap<String, Veiculos> veiculos){
    //rodar a lista de veiculos, se status == true imprime veiculo         
    // caso a lista esteja vazia?

        for(Veiculos v : veiculos.values())
        {
            String placa1 = v.getPlaca();
            Veiculos v1 = v;
            boolean estado = v1.getStatus();
            
            if(estado == true)
            {
                System.out.println(v1);
            }
        }
    }
    
    public static String desalugar(String placa){

        for(Veiculos v : veiculos.values())
        {
            String placa1 = v.getPlaca();
            Veiculos v1 = v;
            
            if(placa1.equals(placa))
            {
                v1.setStatus(false); //mudar o status de true para false
            }
            return "Carro desalugado com sucesso";
        }
        return "Carro não encontrado";
    }
    
    @Override
    public String toString()
    {
        return "Cliente: " + this.cliente.getNome() + "\nVeiculo: " + this.veiculo.getPlaca();
    }
    
}