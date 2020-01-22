package funcionarios;

import java.util.ArrayList;
import java.util.Scanner;

import gerenciador.Cardapio;
import gerenciador.Mesas;
import gerenciador.cozinha;

@SuppressWarnings("unused")
public class Garcom extends Funcionario
{

	public Garcom(String nm, String registro, double sal, String clas) {
		super(nm, registro, sal, clas);
		
	}

	public void entregarPedido(ArrayList<cozinha> pedidos, ArrayList<Funcionario> funcionarios, ArrayList<Mesas> mesa) {
		boolean flag=false;
		boolean mesaStatus=false;
		for (Funcionario s : funcionarios )
		{
			if(s.getClasse().equals("Garcom"))
			{
				flag=true;
			}
		}
		if(flag==false)
		{
			System.out.println("Voce nao tem Garcoms, contrate algum");
			return;
		}
		String id;
		System.out.println("digite a identificacao da mesa que voce deseja servir");
		id=input.nextLine();
		for(cozinha s : pedidos)
		{
			if(s.getIdMesa().equals(id))
			{
				if(s.getStatus().equals("Pronto"))
				{
			
					mesaStatus=true;
					if (mesaStatus==true)
					{
						for(Mesas a : mesa)
						{
							if(a.getidentificacao().equals(id))
							{
								a.setPendente(false);
								System.out.println("pedido entregue na mesa");
							}
						}
						return;
					}				
					
				}
				else
				{
					
					System.out.println("o pedido nao esta pronto");
				}
				return;
			}
		}
		System.out.println("esse pedido nao esta na cozinha");
		return;
		
	}
	

	
	
	public void anotarPedido(ArrayList<Mesas> mesa, ArrayList<Cardapio> cardapio,  ArrayList<Funcionario> funcionarios)
	{
		boolean pedindo = true;
		
		boolean flag=false;
		
		for (Funcionario s : funcionarios )
		{
			if(s.getClasse().equals("Garcom"))
			{
				flag=true;
			}
		}
		if(flag==false)
		{
			System.out.println("Voce nao tem Garcoms, contrate algum");
			return;
		}
		while(pedindo)
		{
			String prato, str, digito;
			double preco=0;
			boolean achou =false;
			boolean mesaExiste=false;
			System.out.println("insira o nome da comida que a mesa quer");
	    	prato=input.nextLine();
	    	for (Cardapio s : cardapio ) 
			{
				if(s.getnomeDoPrato().equals(prato))
				{
					achou=true;
					preco=s.getPreco();
					
				}
			}
	    	if(achou==false)
	    	{
	    		System.out.println("essa comida nao foi achada no cardapio.");
	        	
	    	}
	 
	    	else
	    	{
	    		System.out.println("insira a identificacao da mesa que esta pedindo a comida");
		    	str=input.nextLine();
				for (Mesas s : mesa ) 
				{
					if(s.getidentificacao().equals(str))
					{
						mesaExiste=true;
						s.setPedidos(prato);
						s.setConta(preco);
						System.out.println("pedido adicionado");
						
					}
				}
				if(!mesaExiste)
				{
					System.out.println("essa mesa nao foi encontrada");
				}
				
	    	}
	    	
			
			System.out.println("se ainda deseja continuar pedindo digite 1");
			digito=input.nextLine();
			if(digito.equals("1"))
			{
				pedindo=true;
			}
			else
			{
				pedindo=false;
			}
		}
		
		return;
		
	}
	
	
	
	
}