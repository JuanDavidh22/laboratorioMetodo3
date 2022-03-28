/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.servlet;

import co.edu.unipiloto.curso.Curso;
import co.edu.unipiloto.curso.session.CursoFacadeLocal;

import co.edu.unipiloto.student.Estudiante;
import co.edu.unipiloto.student.session.EstudianteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanc
 */
public class StudentServlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

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

        int estudianteID = 0;
        int sem = 0;
        String estId = request.getParameter("studentId");
        String nombreEstudiante = request.getParameter("firstName");
        String apellido = request.getParameter("lastName");
        String semestre = request.getParameter("yearLevel");

        if (estId != null && !"".equals(estId)) {
            estudianteID = Integer.parseInt(estId);
        }
        if (semestre != null && !"".equals(semestre)) {
            sem = Integer.parseInt(semestre);
        }
        
        Estudiante est = new Estudiante();
        String acStudent = request.getParameter("actionStudent");

        if (acStudent.equals("Add")) {
            est.setEstudianteid(estudianteID);
            est.setApellido(apellido);
            est.setNombre(nombreEstudiante);
            est.setSemestre(sem);
            estudianteFacade.create(est);
        } else if (acStudent.equals("Edit")) {
            est.setApellido(apellido);
            est.setEstudianteid(estudianteID);
            est.setNombre(nombreEstudiante);
            est.setSemestre(sem);
            estudianteFacade.edit(est);
        } else if (acStudent.equals("Delete")) {
            est.setApellido(apellido);
            est.setEstudianteid(estudianteID);
            est.setNombre(nombreEstudiante);
            est.setSemestre(sem);
            estudianteFacade.remove(est);
        } else if (acStudent.equals("Search")) {
            est.setApellido(apellido);
            est.setEstudianteid(estudianteID);
            est.setNombre(nombreEstudiante);
            est.setSemestre(sem);
            estudianteFacade.findAll();
        }

        request.setAttribute("student", est);
        request.setAttribute("allStudents", estudianteFacade.findAll());
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
