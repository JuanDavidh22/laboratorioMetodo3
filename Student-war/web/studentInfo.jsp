<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">|
        <title>Student</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.estudianteid}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${student.nombre}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${student.apellido}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.semestre}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="actionStudent" value="Add" />
                        <input type="submit" name="actionStudent" value="Edit" />
                        <input type="submit" name="actionStudent" value="Delete" />
                        <input type="submit" name="actionStudent" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.estudianteid}</td>
                    <td>${stud.nombre}</td>
                    <td>${stud.apellido}</td>
                    <td>${stud.semestre}</td>
                </tr>
            </c:forEach> 
        </table>
        <h1>Course Information</h1>

        <form action="CourseServlet" method="POST">
            <table>
                <tr>
                    <td>Course Id</td>
                    <td><input type="text" name="cursoid" value="${course.cursoid}"/></td>
                </tr>
                <tr>
                    <td>Course name</td>
                    <td><input type="text" name="nombre" value="${course.nombre}"/></td>
                </tr>
                <tr>
                    <td>Number of credits</td>
                    <td><input type="text" name="numerocreditos" value="${course.numerocreditos}"/></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="semestre" value="${course.semestre}"/></td>
                </tr>
                <tr>
                    <td>Admitted students</td>
                    <td><input type="text" name="estudiantesadmitidos" value="${course.estudiantesadmitidos}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="actionCourse" value="Add"/>
                        <input type="submit" name="actionCourse" value="Edit"/>
                        <input type="submit" name="actionCourse" value="Delete"/>
                        <input type="submit" name="actionCourse" value="Search"/>
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Curso ID</th>
            <th>Nombre curso</th>
            <th>Numero creditos</th>
            <th>Semestre</th>
            <th>Estudiantes admitidos</th>
                <c:forEach items="${allCourses}" var="cour">
                <tr>
                    <td>${cour.cursoid}</td>
                    <td>${cour.nombre}</td>
                    <td>${cour.numerocreditos}</td>
                    <td>${cour.semestre}</td>
                    <td>${cour.estudiantesadmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>
        
        <h1>Grades Information</h1>
        <form action="studentCourseServlet" method="POST">
            <table>
                <tr>
                    <td>Course Id</td>
                    <td><input type="text" name="cursoid" value="${studentCourse.estudianteCursoPK.cursoid}"/></td>
                </tr>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="estudianteid" value="${studentCourse.estudianteCursoPK.estudianteid}"/></td>
                </tr>
                <tr>
                    <td>Calification</td>
                    <td><input type="text" name="notas" value="${studentCourse.notas}"/></td>
                </tr>
                <td colspan="2">
                    <input type="submit" name="actionCourseStudent" value="Add" />
                    <input type="submit" name="actionCourseStudent" value="Edit" />
                    <input type="submit" name="actionCourseStudent" value="Delete" />
                    <input type="submit" name="actionCourseStudent" value="Search" />
                </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Estudiante ID</th>
            <th>Curso ID</th>
            <th>Notas</th>
                <c:forEach items="${allStudentCourses}" var="estCour">
                <tr>
                    <td>${estCour.estudianteCursoPK.cursoid}</td>
                    <td>${estCour.estudianteCursoPK.estudianteid}</td>
                    <td>${estCour.notas}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
