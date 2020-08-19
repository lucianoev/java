/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import entidad.Tbexpediente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Exo
 */
public class TbexpedienteJpaController implements Serializable {

    public TbexpedienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbexpediente tbexpediente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tbexpediente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbexpediente tbexpediente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tbexpediente = em.merge(tbexpediente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbexpediente.getIdtbExpediente();
                if (findTbexpediente(id) == null) {
                    throw new NonexistentEntityException("The tbexpediente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbexpediente tbexpediente;
            try {
                tbexpediente = em.getReference(Tbexpediente.class, id);
                tbexpediente.getIdtbExpediente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbexpediente with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbexpediente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbexpediente> findTbexpedienteEntities() {
        return findTbexpedienteEntities(true, -1, -1);
    }

    public List<Tbexpediente> findTbexpedienteEntities(int maxResults, int firstResult) {
        return findTbexpedienteEntities(false, maxResults, firstResult);
    }

    private List<Tbexpediente> findTbexpedienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbexpediente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tbexpediente findTbexpediente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbexpediente.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbexpedienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbexpediente> rt = cq.from(Tbexpediente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
