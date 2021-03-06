/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Exo
 */
@Entity
@Table(name = "tbexpediente")
@NamedQueries({
    @NamedQuery(name = "Tbexpediente.findAll", query = "SELECT t FROM Tbexpediente t"),
    @NamedQuery(name = "Tbexpediente.findByIdtbExpediente", query = "SELECT t FROM Tbexpediente t WHERE t.idtbExpediente = :idtbExpediente"),
    @NamedQuery(name = "Tbexpediente.findByNombre", query = "SELECT t FROM Tbexpediente t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tbexpediente.findByFojas", query = "SELECT t FROM Tbexpediente t WHERE t.fojas = :fojas"),
    @NamedQuery(name = "Tbexpediente.findByTipo", query = "SELECT t FROM Tbexpediente t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tbexpediente.findByEstado", query = "SELECT t FROM Tbexpediente t WHERE t.estado = :estado")})
public class Tbexpediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbExpediente")
    private Integer idtbExpediente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fojas")
    private String fojas;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;

    public Tbexpediente() {
    }

    public Tbexpediente(Integer idtbExpediente) {
        this.idtbExpediente = idtbExpediente;
    }

    public Tbexpediente(Integer idtbExpediente, String nombre, String fojas, String tipo, String estado) {
        this.idtbExpediente = idtbExpediente;
        this.nombre = nombre;
        this.fojas = fojas;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Integer getIdtbExpediente() {
        return idtbExpediente;
    }

    public void setIdtbExpediente(Integer idtbExpediente) {
        this.idtbExpediente = idtbExpediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFojas() {
        return fojas;
    }

    public void setFojas(String fojas) {
        this.fojas = fojas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
