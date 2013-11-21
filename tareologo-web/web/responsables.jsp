<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Responsables</title>
            <style type="text/css" media="screen">
                <%@ include file="css/common.css" %>
            </style>
            <style type="text/css" media="screen">
                <%@ include file="css/responsables.css" %>
            </style>
        </head>
        <body>
            <nav>                                         
                <h:form>
                    <h:commandLink styleClass="logo" action="index" value="Tareólogo" />
                </h:form>
                <h:form id="formMenu">                    
                    <h:commandLink styleClass="menu" action="index" value="Inicio"/>
                    <h:commandLink styleClass="menu" action="responsables" value="Responsables" style="background-color: #333333; color:white; font-style: italic;" />
                    <h:commandLink styleClass="menu" action="categorias" value="Categorías" />
                </h:form> 
            </nav>
            <div id="contenido">
                <center>
                    <b style="font-size: 20px;">Lista de responsables</b>
                    <br>
                    <br>
                </center>
                <h:form id="buscar">
                    Filtrar por 
                    <h:selectOneMenu id="tipoFiltro" value="#{ResponsablesBean.selectedItem}">
                        <f:selectItems value="#{ResponsablesBean.items}" />                                
                    </h:selectOneMenu>                    
                    <h:inputText id="filtro" label="Buscar" value="#{ResponsablesBean.filter}" />
                    <h:commandButton type="submit" styleClass="boton" value="Filtrar" action="responsables" />                   
                    <h:commandLink id="quitar-filtro" styleClass="link" value="Quitar filtro" action="#{ResponsablesBean.removeFilter()}" />
                </h:form>                    
                <h:form id="nuevo">
                    <h:commandButton styleClass="boton" value="Agregar nuevo" action="agregarResponsable" />  
                </h:form>
                <br>
                <center>                
                    <br>
                    <table id="lista-responsables">  
                        <c:choose>
                            <c:when test="${empty ResponsablesBean.responsables}">  
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <b style="font-size: 20px;">No se cargaron responsables aún.</b>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td class="cabecera">Nombre</td>
                                    <td class="cabecera">Apodo</td>
                                    <td class="cabecera">Email</td>                    
                                    <td class="cabecera-check">Administración</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="#{ResponsablesBean.responsables}" var="responsable" varStatus="status">
                            <tr class="fila">
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${responsable.nombre}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${responsable.apodo}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${responsable.email}</td>    
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}-check"> 
                                    <h:form>
                                        <h:commandLink action="#{EditResponsableBean.edit(responsable)}" value="Editar" />
                                        <h:commandLink action="#{ResponsablesBean.remove(responsable.id)}" onclick="if(!confirm('¿Realmente desea borrar este responsable?')) return false">
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