<%@ include file="common/head.jsp"%>
    
<%@ include file="common/nav.jsp"%>
    <div class="container">
        <div class="text-center" style="margin: 30px">
            <h3>Sistemas de Empleados</h3>
        </div>
    </div>
    <div class="container">
        <table class="table table-striped table-hover table-bordered align-middle">
            <thead class="table-dark text-center">
                <tr>
                  <th scope="col">ID</td>
                  <td scope="col">Nombre</td>
                  <td scope="col">Departamento</td>
                  <td scope="col">Sueldo</td>
                  <td scope="col"></td>
                </tr>
              </thead>
              <tbody >
                <c:forEach var="empleado" items="${empleados}">
                    <tr>
                        <th scope="row">${empleado.idEmpleado}</th>
                        <td>${empleado.nombreEmpleado}</td>
                        <td>${empleado.departamento}</td>
                        <td>
                            <fmt:setLocale value="en_US"/>
                            <fmt:formatNumber type="currency" value="${empleado.sueldo}"/>
                        </td>
                        <td scope="row" class="text-center">
                            <c:set var="urlEditar">
                                <c:url value="${application.contextPath}/editar">
                                    <c:param name="idEmpleado"
                                            value="${empleado.idEmpleado}"/>
                                    </c:url>
                            </c:set>
                            <a href="${urlEditar}" class="btn btn-warning" style="margin-right: 5px;">Editar</a>
                            <c:set var="urlEliminar">
                                <c:url value="${application.contextPath}/eliminar">
                                    <c:param name="idEmpleado"
                                            value="${empleado.idEmpleado}"/>
                                    </c:url>
                            </c:set>
                            <a href="${urlEliminar}" class="btn btn-danger">Eliminar</a>
                        </td>
                    </tr>   
                </c:forEach>
              </tbody>
        </table>
    </div>
    <%@ include file="common/footer.jsp"%>