package Controladores;

/**
 *
 * @author gu_sc
 */
import Entidades.Funcionarios;

import exceptions.CampoVazioException;
import java.util.ArrayList;

public class ControladorLoja extends ControladorPrincipal {
    
    public final ArrayList<Funcionarios> listaFuncionarios = new ArrayList<>();
    private static ControladorLoja instance;
    
    
    public static ControladorLoja getInstance() {
	if (instance == null){
            instance = new ControladorLoja();
        }
        return instance;
    }
    
    public void contrataFuncionario(Funcionarios funcionario) throws CampoVazioException{
        verificaCampoVazio(funcionario.getNomeFuncionario(), "Nome funcionario");
       
        listaFuncionarios.add(funcionario); 
    }
    
    public void demiteFuncionario(Funcionarios funcionario) throws CampoVazioException{
        verificaCampoVazio(funcionario.getNomeFuncionario(), "Nome funcionario");
       
        listaFuncionarios.remove(funcionario);
    }

    public ArrayList<Funcionarios> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static void setInstance(ControladorLoja instance) {
        ControladorLoja.instance = instance;
    }
    
    public Funcionarios getFuncionarioPeloNome(String nomeFuncionario) {
        return listaFuncionarios.stream()
            .filter((funcionario) -> funcionario.nomeFuncionario.equalsIgnoreCase(nomeFuncionario))
            .findFirst()
            .orElse(null);
    }
    
    public void exibeListaFuncionarios(){
        for(Funcionarios x : listaFuncionarios){
            System.out.print(x.getNomeFuncionario());
        }
    }
    
    
}
