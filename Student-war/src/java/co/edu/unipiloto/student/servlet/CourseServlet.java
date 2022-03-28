/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.servlet;

import co.edu.unipiloto.curso.Curso;
import co.edu.unipiloto.curso.session.CursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanc
 */
public class CourseServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cursoId = 0;
        int numCreditos = 0;
        int semCurso = 0;
        int estudiantesAdmitidos = 0;

        String curId = request.getParameter("cursoid");
        String nombreCurso = request.getParameter("nombre");
        String numeroCreditos = request.getParameter("numerocreditos");
        String semestreCurso = request.getParameter("semestre");
        String estAdmitidos = request.getParameter("estudiantesadmitidos");

        if (numeroCreditos != null && !"".equals(numeroCreditos)) {
            numCreditos = Integer.parseInt(numeroCreditos);
        }
        if (semestreCurso != null && !"".equals(semestreCurso)) {
            semCurso = Integer.parseInt(semestreCurso);
        }
        if (estAdmitidos != null && !"".equals(estAdmitidos)) {
            estudiantesAdmitidos = Integer.parseInt(estAdmitidos);
        }
        if (curId != null && !"".equals(curId)) {
            cursoId = Integer.parseInt(curId);
        }
        
        Curso curso = new Curso();
        String acCourse = request.getParameter("actionCourse");
        
        if (acCourse.equals("Add")) {
            curso.setCursoid(cursoId);
            curso.setEstudiantesadmitidos(estudiantesAdmitidos);
            curso.setNombre(nombreCurso);
            curso.setNumerocreditos(numCreditos);
            curso.setSemestre(semCurso);
            cursoFacade.create(curso);
        } else if (acCourse.equals("Edit")) {
            curso.setCursoid(cursoId);
            curso.setEstudiantesadmitidos(estudiantesAdmitidos);
            curso.setNombre(nombreCurso);
            curso.setNumerocreditos(numCreditos);
            curso.setSemestre(semCurso);
            cursoFacade.edit(curso);
        } else if (acCourse.equals("Delete")) {
            curso.setCursoid(cursoId);
            curso.setEstudiantesadmitidos(estudiantesAdmitidos);
            curso.setNombre(nombreCurso);
            curso.setNumerocreditos(numCreditos);
            curso.setSemestre(semCurso);
            cursoFacade.remove(curso);
        } else if (acCourse.equals("Search")) {
            curso.setCursoid(cursoId);
            curso.setEstudiantesadmitidos(estudiantesAdmitidos);
            curso.setNombre(nombreCurso);
            curso.setNumerocreditos(numCreditos);
            curso.setSemestre(semCurso);
            cursoFacade.findAll();
        }
        request.setAttribute("course", curso);
        request.setAttribute("allCourses", cursoFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
