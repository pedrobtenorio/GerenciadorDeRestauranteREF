package gerenciador;


import java.util.Scanner;





/*pode parecer que esta classe é desnecessaria pois ela poderia ser checada pela mesa, porem é importante ter em mente
 *  os pedidos nas comandas dos garcom(mesas) e os da cozinha
 */
public class cozinha
{
	private String pedido, idMesa, Status;
	Scanner input = new Scanner(System.in);
	
	public cozinha(String pedido, String idMesa, String Status )
    {
        this.pedido=pedido;
        this.idMesa=idMesa;
        this.Status=Status;
    }
	
	
	public void refresCozinha()
	{
		this.pedido=null;
		this.idMesa=null;
		this.Status=null;
		
	}

	public String getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(String idMesa) {
		this.idMesa = idMesa;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	

}