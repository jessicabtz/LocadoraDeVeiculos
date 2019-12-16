package trabalho;
public class Cliente {
    private String nome;
    private String endereco;
    private int idade;
    private int cpf;
    private int cnh;
    private int limite;
    private float renda_mensal;
    private Aluguel aluguel;

    
    public Cliente(String nome, String endereco, int idade, int cpf, int cnh, float renda)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.cpf = cpf;
        this.cnh = cnh;
        this.renda_mensal = renda;
    }
    
    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public float getRenda_mensal() {
        return renda_mensal;
    }

    public void setRenda_mensal(float renda_mensal) {
        this.renda_mensal = renda_mensal;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
    
    
}
