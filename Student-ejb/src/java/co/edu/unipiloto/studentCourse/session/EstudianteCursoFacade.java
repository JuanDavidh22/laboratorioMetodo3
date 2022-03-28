/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.studentCourse.session;

import co.edu.unipiloto.studentCourse.EstudianteCurso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juanc
 */
@Stateless
public class EstudianteCursoFacade extends AbstractFacade<EstudianteCurso> implements EstudianteCursoFacadeLocal {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteCursoFacade() {
        super(EstudianteCurso.class);
    }
    
}
