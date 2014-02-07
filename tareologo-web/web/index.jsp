<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Tareólogo</title>
            <style type="text/css" media="screen">
                <%@ include file="css/common.css" %>
            </style>
            <style type="text/css" media="screen">
                <%@ include file="css/tareas.css" %>
            </style>
        </head>    
        <body>
            <nav>                                         
                <h:form>
                    <h:commandLink styleClass="logo" action="index" value="Tareólogo" />
                </h:form>
                <h:form id="formMenu">                    
                    <h:commandLink styleClass="menu" action="index" value="Inicio" style="background-color: #333333; color:white; font-style: italic;"/>
                    <h:commandLink styleClass="menu" action="responsables" value="Responsables"  />
                    <h:commandLink styleClass="menu" action="categorias" value="Categorías" />
                </h:form> 
            </nav>
            <div id="contenido">
                <center>
                    <b style="font-size: 20px;">Lista de tareas</b>
                    <br>
                </center>
                <h:form id="nuevo">
                    <h:commandButton styleClass="boton" value="Agregar nueva" action="agregarTarea" />  
                </h:form>
                <br />
                <br />
                <h:form id="buscar">
                    Buscar:
                    <h:inputText id="buscar" style="margin-right:10px; width:150px;" value="#{TareasBean.filter}" />
                    Responsable
                    <h:selectOneMenu style="margin-right:10px;" value="#{TareasBean.responsable}">
                        <f:selectItem itemLabel="Todos" itemValue=""/>
                        <f:selectItems value="#{ResponsablesBean.responsablesItems}" />
                    </h:selectOneMenu>
                    <h:selectBooleanCheckbox id="completadas" label="Completadas" value="#{TareasBean.completadas}" />
                    Sólo completadas...
                    <h:commandButton type="submit" styleClass="boton" value="Aplicar" action="index" style="margin-left:10px;" />
                    <h:commandLink id="quitarFiltro" styleClass="link" value="Quitar filtro" action="#{TareasBean.removeFilter()}" /> 
                </h:form>       
                <br>
                <center>                
                    <br>
                    <table id="lista-tareas">  
                        <c:choose>
                            <c:when test="${empty TareasBean.tareas}">       
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <b style="font-size: 20px;">No se cargaron tareas aún.</b>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td class="columna-titulo">Título</td>
                                    <td class="cabecera">Responsable</td>     
                                    <td class="cabecera">Categoría</td>     
                                    <td class="cabecera">Vencimiento</td>     
                                    <td class="cabecera">Completado</td>     
                                    <td class="cabecera-check">Administración</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="${TareasBean.tareas}" var="tarea" varStatus="status">
                            <tr class="fila">                                
                                <td class="${status.count % 2 == 0? "fila-titulo-par": "fila-titulo-impar"}">${tarea.titulo}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${tarea.responsable.nombre}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${tarea.categoria.nombre}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${tarea.vencimiento}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${tarea.completado}%</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}-check">                                     
                                    <h:form>                 
                                        <h:commandLink action="#{EditResponsableBean.edit(tarea.responsable)}" value="Editar" />
                                        <h:commandLink action="#{TareasBean.remove(tarea.id)}" onclick="if(!confirm('¿Realmente desea borrar este tarea?')) return false">
                                             <h:outputText value="Eliminar" />   
                                        </h:commandLink>
                                    </h:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </center>
            </div>
        </body>
    </html>
</f:view>
