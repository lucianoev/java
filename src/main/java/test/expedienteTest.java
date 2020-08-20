/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.tbExpedienteDAO;
import static entidad.Tbexpediente_.estado;
import static entidad.Tbexpediente_.tipo;

/**
 *
 * @author Exo
 */
public class expedienteTest {
             
    public static void main(String[] args) {
        
    tbExpedienteDAO edao = new tbExpedienteDAO();
      // System.out.println(edao.actualizarExpediente(1,"Federico Ramayo", "Pago", "Iniciado", "2"));    
       // System.out.println(edao.instertarExpediente("Pablo Aguero", "Proveedor", "En trámite","7"));
        System.out.println(edao.eliminarExpediente(1));
     }
    
}
