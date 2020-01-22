package funcionarios;
import java.util.ArrayList;
import java.util.Scanner;
import gerenciador.* ;

public  class Funcionario
{
	private String nome, CPF, classe;
	private double salario;
	static Scanner input = new Scanner(System.in);
	
	public Funcionario(String nm, String registro, double sal, String clas)
	{
		this.nome=nm;
		this.CPF=registro;
		this.salario=sal;
		this.classe=clas;
	}
	
	public void addFuncionario(Funcionario[] funcionario, ArrayList<Funcionario> funcionarios, String classe) {
		
		String test;
			
		int i;
    	for(i=0; i<=99; i++)
		{
			test=funcionario[i].getNome();
			if(test==null)
			{
				break;
			}
		}
		
		String nome, CPF;
		double salario=0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Insira o nome do empregado");
		nome=input.nextLine();
		System.out.println("Insira o Registro do empregado");
		CPF=input.nextLine();
		for (Funcionario s : funcionarios ) {
			if(s.getID().equals(CPF))
			{
				System.out.println("ja existe um funcionario com esse registro, operacao cacelada!");
				return;
			}
			
		}
		boolean erro=true;
		do
		{
			try
			{
				System.out.println("Insira o Salaraio do Empregado");
				salario=input.nextDouble();
				input.nextLine();
				while(salario<998)
				{
					System.out.println("Voce nao pode pagar menos que 998 Rs(salario minimo) para os seus funcionarios!! Insira um novo salario");
					salario=input.nextDouble();
					input.nextLine();
				}
				erro=false;
			}
			catch(Exception e)
			{
				System.out.println("voce precisa digitar um numero");
				 input.next();
			}
			
		}while(erro);
		
		
		funcionario[i]= new Funcionario(nome, CPF, salario, classe);
		funcionarios.add(funcionario[i]);
		
		
	}
	
	public void setNome(String nome)
	{
		this.nome=nome;
		return;
	}
	
	public void trabalhar(Garcom gerenciador, ArrayList<cozinha> pedidos, ArrayList<Funcionario> funcionarios, ArrayList<Mesas> mesa)
	{
		 gerenciador.entregarPedido(pedidos, funcionarios, mesa);
		return;
	}
	

	
	public void trabalhar(Cozinheiro gerenciador, ArrayList<Mesas> mesa, ArrayList<cozinha> pedidos, cozinha pedidoarray[], ArrayList<Funcionario> funcionarios)
	{
		 gerenciador.colocarEmAndamento(mesa, pedidos, pedidoarray, funcionarios);
		return;
	}
	
	public void demitirFuncionario(ArrayList<Funcionario> funcionarios)
	{
		String id;
		System.out.println("digite a identificacao do funcionario");
		id=input.nextLine();	
		for (Funcionario s : funcionarios ) {
			if(s.getID().equals(id))
			{
				
				s.setNome(null);
				funcionarios.remove(s);
				System.out.println("Funcionario demitido");
				return;
			}
		}
		System.out.println("Nao foi encontrado funcionario com essa identificacao");
		return;
	}

	
	public void mudarSalario(ArrayList<Funcionario> funcionarios)
	{
		
		String id;
		System.out.println("digite a identificacao do funcionario");
		id=input.nextLine();	
		for (Funcionario s : funcionarios ) {
			if(s.getID().equals(id))
			{
				System.out.println("digite o novo salario para o funcionario");
				s.salario=input.nextDouble();
				input.nextLine();
				while(salario<998)
				{
					System.out.println("Voce nao pode pagar menos que 998 Rs(salario minimo) para os seus funcionarios!! Insira um novo salario");
					salario=input.nextDouble();
					input.nextLine();
				}
				return;
			}
			
		}
		System.out.println("Nao foi encontrado funcionario com essa identificacao");
		return;
	}
	
	public String getID() {
		return this.CPF;
	}
	public String getNome() {
		
		return this.nome;
	}
	public String getClasse() {
		
		return this.classe;
	}
	public double getSalaraio() {
		return this.salario;
	}
	
	@Override
    public String toString() {
        String info;
        info="\n"+ nome +"\n"+"identificacao: "+CPF+"\nSalario: "+Double.toString(salario)+"R$"+"\n"+"Funcao: "+classe+"\n";
        return info;
    }

	
}