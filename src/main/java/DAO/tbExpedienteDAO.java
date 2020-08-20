/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controlador.TbexpedienteJpaController;
import entidad.Tbexpediente;

/**
 *
 * @author Exo
 */
public class tbExpedienteDAO {
    private TbexpedienteJpaController tjc = new TbexpedienteJpaController();
    private Tbexpediente expediente = new Tbexpediente();
    private String mensaje = "";
    //Código CRUD
    public String instertarExpediente(String nombre, String tipo, String estado, String fojas){
        try{
            expediente.setIdtbExpediente(Integer.BYTES); //id autoincremental en DB
            expediente.setNombre(nombre);
            expediente.setTipo(tipo);
            expediente.setEstado(estado);
            expediente.setFojas(fojas);
            tjc.create(expediente);
            mensaje = "Guardado Correctamente";
        }catch(Exception e){
                System.out.println("Excepción en guardar:"+ e.getMessage() );
            mensaje = "No se pudo guardar la información";
        }
        return mensaje;
    }
    public String actualizarExpediente(int id, String nombre, String tipo, String estado, String fojas){
        
             try{
            expediente.setIdtbExpediente(id); //id autoincremental en DB
            expediente.setNombre(nombre);
            expediente.setTipo(tipo);
            expediente.setEstado(estado);
            expediente.setFojas(fojas);
            tjc.create(expediente);
            mensaje = "Actualizado Correctamente";
        }catch(Exception e){
                System.out.println("Excepción en actualizar:"+ e.getMessage() );
            mensaje = "No se pudo actualizar la información";
        }
        return mensaje;
        
    }
    
    public String eliminarExpediente(int id){
        try {
            tjc.destroy(id);
            mensaje = "Eliminado Correctamente";
        } catch (Exception e) {
             System.out.println("Excepción en eliminar:"+ e.getMessage() );
            mensaje = "No se pudo eliminar";
        }
        return null;
    }
}
