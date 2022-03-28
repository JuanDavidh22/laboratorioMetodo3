/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.studentCourse.servlet;

import co.edu.unipiloto.studentCourse.EstudianteCurso;
import co.edu.unipiloto.studentCourse.EstudianteCursoPK;
import co.edu.unipiloto.studentCourse.session.EstudianteCursoFacadeLocal;
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
public class studentCourseServlet extends HttpServlet {
    
    @EJB
    private EstudianteCursoFacadeLocal estudianteCursoFacade;

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
        int estudianteID = 0;
        double notas = 0;
        
        String curId = request.getParameter("cursoid");
        String estID = request.getParameter("estudianteid");
        String nota = request.getParameter("notas");
        
        if (estID != null && !"".equals(estID)) {
            estudianteID = Integer.parseInt(estID);
        }
        if (nota != null && !"".equals(nota)) {
            notas = Double.parseDouble(nota);
        }
        
        if (curId != null && !"".equals(curId)) {
            cursoId = Integer.parseInt(curId);
        }
        
        EstudianteCursoPK estudianteCurso = new EstudianteCursoPK(estudianteID, cursoId);
        EstudianteCurso estudianteCalificacion = new EstudianteCurso(estudianteCurso);
        String actionStudentCourse = request.getParameter("actionCourseStudent");
        
        if (actionStudentCourse.equals("Add")) {
            estudianteCalificacion.setNotas(notas);
            estudianteCursoFacade.create(estudianteCalificacion);
        } else if (actionStudentCourse.equals("Edit")) {
            estudianteCalificacion.setNotas(notas);
            estudianteCursoFacade.edit(estudianteCalificacion);
        } else if (actionStudentCourse.equals("Delete")) {
            estudianteCalificacion.setNotas(notas);
            estudianteCursoFacade.remove(estudianteCalificacion);
        } else if (actionStudentCourse.equals("Search")) {
            estudianteCursoFacade.findAll();
        }
        request.setAttribute("studentCourse", estudianteCalificacion);
        request.setAttribute("allStudentCourses", estudianteCursoFacade.findAll());
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
