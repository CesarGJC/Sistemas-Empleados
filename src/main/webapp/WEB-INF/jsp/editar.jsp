<%@ include file="common/head.jsp"%>
    
<%@ include file="common/nav.jsp"%>

<div class="container">
    <div class="text-center" style="margin: 30px;">
        <h3>Editar Empleado</h3>
    </div>
    <div>
        <form action="${urlEditar}" modelAttribute="empleadoForma" method="post">
            <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}">
            <div class="mb-3">
              <label for="nombreEmpleado" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="nombreEmpleado" name="nombreEmpleado" required="true" 
              value="${empleado.nombreEmpleado}">
            </div>
            <div class="mb-3">
              <label for="departamento" class="form-label">Departamento</label>
              <input type="text" class="form-control" id="departamento" name="departamento" 
              value="${empleado.departamento}">
            </div>
            <div class="mb-3">
                <label for="sueldo" class="form-label">Sueldo</label>
                <div class="input-group">
                    <span class="input-group-text">$</span>
                    <input type="text" id="sueldo" name="sueldo" class="form-control" 
                    value="${empleado.sueldo}">
                </div>
            </div>
            <div class="d-flex justify-content-center gap-2 mb-3">
                <button type="submit" class="btn btn-primary">Editar</button>
                <a href="${urlInicio}" class="btn btn-danger">Cancelar</a>
            </div>
        </form>
    </div>
</div>

<%@ include file="common/footer.jsp"%>