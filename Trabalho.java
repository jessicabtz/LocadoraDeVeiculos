package trabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class Trabalho {
    
    private static ArrayList<Aluguel> alugueis = new ArrayList();
    
    public static void main(String[] args) {
        
        while(true){
        System.out.println("Digite a opcao\n");
        System.out.println("1 - Veiculo");
        System.out.println("2 - Cliente");
        System.out.println("3 - Aluguel");
        System.out.println("4 - Sair");
        
        Scanner s = new Scanner(System.in);
        int op = s.nextInt();
        
        switch(op){
            case 1:
                menuVeiculo();
                break;
            case 2:
                menuCliente();
                break;
            case 3:
                menuAluguel();
                break;
            default:
                return;    
        }
      }
    }
   
    private static void menuAluguel()
    {   
        while(true){
        //como interligar tudo. Ex: inserir um aluguel com um cliente e um carro ter que digitar tudo novamentes
        System.out.println("Digite a opcao\n");
        System.out.println("1 - Novo aluguel");
        System.out.println("2 - Desalugar Veiculo");
        System.out.println("3 - Consultar Alugueis");
        System.out.println("4 - Sair");
        
        Scanner s = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        int op = s.nextInt();
        
        System.out.println("Digite a placa do veiculo que deseja alugar: ");  //quais veiculos o cliente deseja alugar?
        String placa = s.next();
        
        switch(op)
        {
            case 1: 
                Aluguel a1 = new Aluguel();// esse é o lugar certo pra criar isso?
                alugueis.add(a1);
                
                System.out.println("Digite o CPF do cliente: ");
                int cpf = c.nextInt();
                
                Cliente c3 = a1.verificaCondicoesDeAluguel(cpf); 
                
                System.out.println("Digite a data do aluguel:"); //inserir a data do aluguel
                String data1 = s.next();
                
                System.out.println("Digite a data da devolução:"); //inserir a data da devolucao
                String data2 = s.next();
                
                System.out.println("Digite a quantidade de dias do aluguel");//quantos dias sao 
                int dia = c.nextInt();
                        
                System.out.println(a1.alugar(placa, data1, data2, dia, c3)); 
                break;
            
            case 2:
                
                System.out.println(Aluguel.desalugar(placa)); 
                
            case 3: 
                alugueis.forEach(aluguel -> System.out.println(aluguel.toString()));
                
            case 4: 
                return;
        }
    }
    }
    private static void menuVeiculo()
    {
        while(true){
        System.out.println("Digite a opcao\n");
        System.out.println("1 - Cadastrar veiculo");
        System.out.println("2 - Remover Veiculo");
        System.out.println("3 - Imprimir todos os veiculos");
        System.out.println("4 - Sair");
        
        Aluguel a = new Aluguel();
        
        int op, ano, opcao, porta_cilindrada;
        float km_rodado, valor;
        boolean status;
        String cor, marca_e_tipo, placa;
        
        Scanner s = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        
        opcao = s.nextInt();
               
        switch(opcao)
        {
            case 1:
                System.out.println("1 - Carro e 2 - Moto");
                op = s.nextInt();
                
                System.out.println("Digite o ano: ");
                ano = s.nextInt();
                
                System.out.println("Digite a cor: ");
                cor = c.nextLine();
                
                System.out.println("Digite a quilometragem: ");
                km_rodado = s.nextFloat();
                
                System.out.println("Digite o modelo e marca: ");
                marca_e_tipo = c.nextLine();
                
                System.out.println("Digite a placa: ");
                placa = c.nextLine();
                
                System.out.println("Digite o valor de aluguel do veiculo: ");
                valor = s.nextFloat();
                
                System.out.println("Se carro, digite a quantidade de portas.Se moto, digite as cilindradas: ");
                porta_cilindrada = s.nextInt();
                
                status = false;
                
                a.addVeiculo(op, placa, ano, cor, km_rodado, marca_e_tipo , valor, porta_cilindrada);
                break;
                
            case 2:
                System.out.println("Digite a placa: ");
                placa = c.next();
                
                a.removeVeiculo(placa);
                break;
                
            case 3:
                a.imprimirVeiculos();
                break;
                
            default:
                return;
        }
      }
    }
    
    private static void menuCliente()
    {
        while(true){
        System.out.println("Digite a opcao\n");
        System.out.println("1 - Cadastrar cliente ou atualizar cliente");
        System.out.println("2 - Imprimir todos os clientes");
        System.out.println("3 - Sair");
        
        Aluguel a = new Aluguel();
        Integer opcao, idade, cpf, cnh;
        float renda;
        String nome, endereco;
        
        Scanner e = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        
        opcao = e.nextInt();
                
        switch(opcao)
        {
            case 1:
                System.out.println("Digite o nome: ");
                nome = f.nextLine();
                
                System.out.println("Digite o endereco: ");
                endereco = f.nextLine();
                
                System.out.println("Digite a idade: ");
                idade = e.nextInt();
                
                System.out.println("Digite o CPF: ");
                String aux = f.nextLine();
                cpf = Integer.parseInt(aux);
                
                System.out.println("Digite a CNH: ");
                cnh = e.nextInt();
                
                System.out.println("Digite a renda mensal: ");
                renda = e.nextFloat();
                
                System.out.println("1- Cadastrar Cliente 2-Atualizar Cliente: ");
                opcao = e.nextInt();
                
                    if(opcao==1)
                    {

                    a.addCliente(nome, endereco, idade, cpf, cnh, renda);

                    } else {

                        System.out.println(a.alterarCliente(nome, endereco, idade, cpf, cnh, renda));
                    
                    }
                break;
                
            case 2:
                
                a.imprimirClientes();
                break;

            default:
                return;
        }
      }
    }
}
