/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import exceptions.*;

/**
 *
 * @author gu_sc
 */
public class ControladorPrincipal {
    
    public void verificaCampoVazio(String campo, String nomeCampo) throws CampoVazioException{
        if (campo == null || campo.isEmpty())
            throw new exceptions.CampoVazioException("Erro: nao é permitido campo vazio (" + nomeCampo + ")");
    }
    
    
    
    
     
}
