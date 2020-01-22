package gerenciador;

import java.util.ArrayList;
import java.util.Scanner;






public class Mesas{
	Scanner input = new Scanner(System.in);
	private String identificacao, pedidos;


	private boolean ocupada, pendente;
	private double conta;
	
	public Mesas(String id, String pedidos, boolean oc, double conta, boolean pendente) 
	{
		this.identificacao=id;
		this.pedidos=pedidos;
		this.ocupada=oc;
		this.conta=conta;
		this.pendente=pendente;
	}
	
	public String toString() {
        String info;
        info="\n"+"identificacao: "+identificacao+"\nPedidos: "+pedidos+"conta: "+ Double.toString(conta)+"\n";
        return info;
    }
	

	public void criarMesa(Mesas mesasdobar[], ArrayList<Mesas> mesa){
		String id;
		
		
		int i;
    	for(i=0; i<=99; i++)
		{
			
			if(mesasdobar[i].getidentificacao()==null)
			{
				break;
			}
		}
		System.out.println("Insira o Registro da mesa");
		id=input.nextLine();
		
		for (Mesas s : mesa ) 
		{
			if(s.getidentificacao().equals(id))
			{
				System.out.println("ja existe uma mesa com esse registro, operacao cacelada!");
				return;
			}
		}
		mesasdobar[i].setidentificacao(id);
		mesa.add(mesasdobar[i]);	
		return;
	}
	
	public boolean getPendente()
	{
		return this.pendente;
	}
	
	public void setPendente(boolean status)
	{
		this.pendente=status;
		return;
	}
	

	
	public void refreshall()
	{
		this.identificacao=null;
		this.pedidos=" ";
		this.ocupada=false;
		
		this.conta=0;
	}
	
	public double getConta()
	{
		return this.conta;
	}
	
	public double fecharMesa(ArrayList<Mesas> mesa, double caixa)
	{
		String id;
		double dinheiro;
		System.out.println("digite a identificacao da mesa que voce quer fechar a conta");
		id=input.nextLine();	
		for (Mesas s : mesa ) {
			if(s.getidentificacao().equals(id))
			{
				if(s.verOcupada()==false)
				{
					System.out.println("nao tem ninguem nessa mesa");
					return caixa;
				}
				if(s.pendente)
				{
					System.out.println("os pedidos dessa mesa nao foram entregues logo voce nao pode fecha-la");
					return caixa;
				}
				dinheiro=s.getConta();
				System.out.println("essa mesa pagou " + Double.toString(dinheiro) + " reais\n");
				caixa=caixa+dinheiro;
				s.refreshall();
				return caixa;
				
			}
		}
		System.out.println("Nao foi encontrada mesa com essa identificacao");
		return caixa;
	}
	


	private void setidentificacao(String id) {
		this.identificacao=id;
		return;
		
	}
	
	public void setConta(double c)
	{
		this.conta=this.conta+c;
		return;
	}
	
	
	
	public void setPedidos(String pedido) {
		this.pedidos=this.pedidos.concat(pedido);
		this.pedidos=this.pedidos.concat("  ");
		return;
		
	}
	
	public String getPedido()
	{
		return this.pedidos;
	}


	public String getidentificacao() {
		return this.identificacao;
	}


	public void removerMesa(ArrayList<Mesas> mesa)
	{
		String id;
		System.out.println("digite a identificacao da mesa");
		id=input.nextLine();	
		for (Mesas s : mesa ) {
			if(s.getidentificacao().equals(id))
			{
				
				mesa.remove(s);
				System.out.println("mesa removida");
				return;
			}
		}
		System.out.println("Nao foi encontrada mesa com essa identificacao");
		return;
	}
	
	

	

	public boolean verOcupada()
	{
		return this.ocupada;
	}
	
	private void ocupar()
	{
		this.ocupada=true;
		return;
	}
	

	
	public void ocuparMesa(ArrayList<Mesas> mesa)
	{
		String str;
		System.out.println("insira a identificacao da mesa que os clientes irao sentar");
		str=input.nextLine();
		for (Mesas s : mesa ) 
		{
			
			if(s.getidentificacao().equals(str))
			{
				
				if(s.verOcupada())
				{
					System.out.println("essa mesa esta ocupada e nao pode ser usada.");
					return;
				}
				else
				{
					s.ocupar();
					System.out.println("Os clientes estao na mesa!");
					return;
				}
			}
		}
	}
}