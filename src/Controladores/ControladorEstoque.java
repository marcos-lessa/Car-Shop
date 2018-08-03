package Controladores;

import Entidades.Carros;
import exceptions.CampoVazioException;
import exceptions.CarroInexistenteException;
import exceptions.ValoresAbsurdosException;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author gu_sc
 */
public class ControladorEstoque extends ControladorPrincipal{
    
    private static ControladorEstoque instance;
    public  ArrayList<Carros> listaCarros = new ArrayList<>();
    public ArrayList<Carros> carrosVendidos = new ArrayList<>();
    public double caixaLoja;
    
    public static ControladorEstoque getInstance(){
        if (instance == null){
            instance = new ControladorEstoque();
        }
        return instance;
    }
    
    public void setCarrosVendidos(ArrayList<Carros> carrosVendidos){
        this.carrosVendidos = carrosVendidos;
    }
    
    public ArrayList getCarrosVendidos(){
        return carrosVendidos;
    }
    
    public void setListaCarros(ArrayList<Carros> listaCarros){
        this.listaCarros = listaCarros;
    }
    
    public ArrayList getListaCarros(){
        return listaCarros;
    }
    
    public Carros cadastraCarroNaLista(Carros carro)
            throws CampoVazioException, ValoresAbsurdosException{
        //verifica
        verificaCampoVazio(carro.getNomeCarro(), "Nome carro");
        verificaCampoVazio(carro.getModelo(), "Modelo carro");
        verificaCampoVazio(carro.getCor(), "Cor carro");
        verificaCampoVazio(carro.getMarca(), "Marca carro");
        
        if(carro.getPreco()< 0){
            throw new ValoresAbsurdosException("Digite um valor maior que zero");
        }
        
        if(carro.getAnoFabricacao() > 2018){
            throw new ValoresAbsurdosException("Digite um valor menor ou igual a 2018");
        }
        
        if (carro.getNomeCarro() == null || carro.getModelo() == null || carro.getMarca() == null
        || carro.getCor() == null) {
            throw new CampoVazioException("Erro: Você deixou algum campo em branco");
        }
        
        listaCarros.add(carro);
        return carro;
    }
    
    
    public void removeCarroDaLista(Carros carro){
        listaCarros.remove(carro);
    }
    
    public Carros getCarroPeloNome(String nomeCarro) {
		return listaCarros.stream()
			.filter(carro -> carro.nomeCarro.equals(nomeCarro))
			.findFirst()
                        .orElse(null);
    }
    
    public Carros getCarroPeloPreco(double preco) {
		return listaCarros.stream()
			.filter(carro -> carro.preco == preco)
			.findFirst()
                        .orElse(null);
    }
    
    public Carros getCarroPeloModelo(String modelo) {
		return listaCarros.stream()
			.filter(carro -> carro.modelo.equals(modelo))
			.findFirst()
                        .orElse(null);
    }
    
    public Carros getCarroPeloAno(double anoFabricacao) {
		return listaCarros.stream()
			.filter(carro -> carro.anoFabricacao == anoFabricacao)
			.findFirst()
                        .orElse(null);
    }
    
    public Carros getCarroPelaCor(String cor) {
		return listaCarros.stream()
			.filter(carro -> carro.cor.equals(cor))
			.findFirst()
                        .orElse(null);
    }
    
    public Carros getCarroPelaMarca(String marca) {
		return listaCarros.stream()
			.filter(carro -> carro.marca.equals(marca))
			.findFirst()
                        .orElse(null);
    }
    
    public void verificaCarroNaLista(String campo, String nomeCampo) throws CarroInexistenteException{
        if (campo == null || !this.listaCarros.contains(campo))
            throw new exceptions.CarroInexistenteException("A loja não possui este modelo ou está em falta");
    }  
    
    public String exibeListaCarros(){
       int tam = listaCarros.size();
       String [] nomes = new String [tam];
        
       for (int i = 0; i < tam; i++) {
           nomes[i] = listaCarros.get(i).getNomeCarro()+"/"+listaCarros.get(i).getAnoFabricacao();
       }
       
       String carros = "";
       
       int j = 0;
       
       while ( j < nomes.length){
           
           carros = carros + nomes[j]+"\n";
           
           j++;
       }
       
       return carros;
    }
    
    public void setCaixaLoja(double caixaLoja){
        this.caixaLoja = caixaLoja;
    }
    
    public double getCaixaLoja(){
        return caixaLoja;
    }
    
    public void vendeCarro(Carros carro){
        listaCarros.remove(carro);
        carrosVendidos.add(carro);
        caixaLoja += carro.getPreco();
    }
}
