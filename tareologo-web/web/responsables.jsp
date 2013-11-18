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
                <h:form id="buscar-responsable">
                    <h:inputText id="filtro" label="Buscar" value="#{ResponsablesBean.filter}" />
                    <h:commandButton type="submit" styleClass="boton" value="Filtrar" action="responsables" />
                    <h:commandLink id="quitar-filtro" styleClass="link" value="Quitar filtro" action="responsables" />
                </h:form>
                <h:form id="nuevoResp">
                    <h:commandButton styleClass="boton" value="Agregar nuevo" action="agregarResponsable" />  
                </h:form>
                <br>
                <center>                
                    <br>
                    <div id="lista-responsables">  
                        <c:choose>
                            <c:when test="@{ResponsablesBean.responsables.size() == 0}">                        
                                <b style="font-size: 20px;">No se cargaron responsables aún.</b>
                            </c:when>
                            <c:otherwise>
                                <div class="cabecera">Nombre</div>
                                <div class="cabecera">Apodo</div>
                                <div class="cabecera">Email</div>                    
                                <div class="cabecera-check">Administración</div>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="#{ResponsablesBean.responsables}" var="responsable" varStatus="status">
                            <div class="fila">
                                <div class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${responsable.nombre}</div>
                                <div class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${responsable.apodo}</div>
                                <div class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${responsable.email}</div>    
                                <div class="${status.count % 2 == 0? "fila-par": "fila-impar"}-check"> 
                                    <h:form>
                                        <h:commandLink action="ResponsablesBean.edit" value="Editar"  >
                                            <f:param name="action" value="edit" />
                                            <f:param name="id" value="#{responsable.id}" />
                                        </h:commandLink>
                                        <h:commandLink action="#{ResponsablesBean.remove(responsable.id)}" onclick="if(!confirm('¿Realmente desea borrar este responsable?')) return false">
                                            <h:outputText value="Eliminar" />                                           
                                        </h:commandLink>
                                    </h:form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </center>
            </div>
        </body>
    </html>
</f:view>