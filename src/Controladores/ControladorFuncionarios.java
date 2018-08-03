package Controladores;

import Entidades.Carros;
import Entidades.Cliente;
import exceptions.CampoVazioException;
import java.util.ArrayList;
/**
 *
 * @author gu_sc
 */
public class ControladorFuncionarios extends ControladorPrincipal {
    
    public final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static ControladorFuncionarios instance;
    
    public static ControladorFuncionarios getInstance() {
	if (instance == null){
            instance = new ControladorFuncionarios();
        }
        return instance;
    }
   
    
    public void cadastraCliente(Cliente cliente) throws CampoVazioException{
        verificaCampoVazio(cliente.getNomeCliente(), "Nome Cliente");
       
        listaClientes.add(cliente);
    }
   
    public void removeCliente(Cliente cliente) throws CampoVazioException{
        verificaCampoVazio(cliente.getNomeCliente(), "Nome funcionario");
        
        listaClientes.remove(cliente);
    }
    
    public Cliente getClientePeloNome(String nomeCliente) {
        return listaClientes.stream()
            .filter((cliente) -> cliente.nomeCliente.equalsIgnoreCase(nomeCliente))
            .findFirst()
            .orElse(null);
    }
    
    public void exibeListaClientes(){
        for(Cliente x : listaClientes){
            System.out.print(x.getNomeCliente());
        }
    }
    
}
