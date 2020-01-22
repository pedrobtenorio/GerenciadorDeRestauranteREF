package funcionarios;

import java.util.ArrayList;
import java.util.Scanner;

import gerenciador.Mesas;
import gerenciador.cozinha;




public class Cozinheiro extends Funcionario
{

	public Cozinheiro(String nm, String registro, double sal, String clas) {
		super(nm, registro, sal, clas);
		
	}

	
	public void mudarParaPronto(ArrayList<cozinha> pedidos, ArrayList<Funcionario> funcionarios)
	{
		boolean flag=false;
		for (Funcionario s : funcionarios )
		{
			if(s.getClasse().equals("Cozinheiro"))
			{
				flag=true;
			}
		}
		if(flag==false)
		{
			System.out.println("Voce nao tem cozinheiros, contrate algum");
			return;
		}
		String id;
		System.out.println("digite a identificacao da mesa quer mudar o status do prato");
		id=input.nextLine();
		for(cozinha s : pedidos)
		{
			if(s.getIdMesa().equals(id))
			{
				if(s.getStatus().equals("Pronto"))
				{
					System.out.println("o pedido ja esta pronto");
					
				}
				else
				{
					s.setStatus("Pronto");
					System.out.println("o pedido  esta pronto");
				}
				return;
			}
		}
		System.out.println("esse pedido nao esta na cozinha");
		return;
	}
	
	public void colocarEmAndamento(ArrayList<Mesas> mesa, ArrayList<cozinha> pedidos, cozinha pedidoarray[], ArrayList<Funcionario> funcionarios)
	{
		String id;
		
		boolean flag=false;
		for (Funcionario s : funcionarios )
		{
			if(s.getClasse().equals("Cozinheiro"))
			{
				flag=true;
			}
		}
		if(flag==false)
		{
			System.out.println("Voce nao tem cozinheiros, contrate algum");
			return;
		}
		System.out.println("digite a identificacao da mesa que voce quer por o pedido em andamento");
		id=input.nextLine();	
		for (Mesas s : mesa ) {
			if(s.getidentificacao().equals(id))
			{
				if(s.verOcupada())
				{
					if(s.getPedido().equals(" "))
					{
						System.out.println("A mesa ainda nao pediu nada");
						return;
					}
					else
					{
						int i;
				    	for(i=0; i<=99; i++)
						{
							
							if(pedidoarray[i].getPedido()==null)
							{
								pedidoarray[i].setIdMesa(s.getidentificacao());
								pedidoarray[i].setPedido(s.getPedido());
								pedidoarray[i].setStatus("Em andamento");
								pedidos.add(pedidoarray[i]);
								System.out.println("pedido em andamento");
								return;
								
							}
							
						}
					}
				}
				
			}
			
		}
		System.out.println("Nao tem ninguem nessa mesa");
		return;
	}


	
	public void addCozinheiro(Cozinheiro cozinheiros[], ArrayList<Funcionario> funcionarios) {
		String test;
		int i;
    	for(i=0; i<=99; i++)
		{
			test=cozinheiros[i].getNome();
			if(test==null)
			{
				break;
			}
		}
		
		String nome, CPF;
		double salario=0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Insira o nome do Cozinheiro");
		nome=input.nextLine();
		System.out.println("Insira o Registro do cozinheiro");
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
				System.out.println("Insira o Salaraio do Cozinheiro");
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
		
		
		cozinheiros[i]= new Cozinheiro(nome, CPF, salario, "Cozinheiro");
		funcionarios.add(cozinheiros[i]);

	}
					
}
	