<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Categorías</title>
            <style type="text/css" media="screen">
                <%@ include file="css/common.css" %>
            </style>
            <style type="text/css" media="screen">
                <%@ include file="css/categorias.css" %>
</style>
        </head>
        <body>
            <nav>                                         
                <h:form>
                    <h:commandLink styleClass="logo" action="index" value="Tareólogo" />
                    <h:commandLink styleClass="menu" action="index" value="Inicio"/>
                    <h:commandLink styleClass="menu" action="responsables" value="Responsables" />
                    <h:commandLink styleClass="menu" action="categorias" value="Categorías" style="background-color: #333333; color:white; font-style: italic;" />
                </h:form>
            </nav>
            <div id="contenido">
                <center>
                    <b style="font-size: 20px;">Lista de categorías</b>
                    <br>
                    <br>
                </center>
                <h:form id="buscar">
                    <h:inputText id="filtro" label="Buscar" value="" />
                    <h:commandButton type="submit" styleClass="boton" value="Buscar por nombre" />
                </h:form>
                <h:form id="nuevo">
                    <h:commandButton styleClass="boton" value="Agregar nueva" action="agregarCategoria" />  
                </h:form>
                <br>
                <center>                
                    <br>
                    <table id="lista-categorias">  
                        <c:choose>
                            <c:when test="@{CategoriasBean.categorias.size() == 0}">                        
                                <b style="font-size: 20px;">No se cargaron categorías aún.</b>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td class="cabecera">Nombre</td>
                                    <td class="cabecera">Descripción</td>     
                                    <td class="cabecera-check">Administración</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="#{CategoriasBean.categorias}" var="categoria" varStatus="status">
                            <tr class="fila">
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${categoria.nombre}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${categoria.descripcion}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}-check"> 
                                    <h:form>
                                        <h:commandLink action="CategoriasBean.edit" value="Editar"  >
                                            <f:param name="action" value="edit" />
                                            <f:param name="id" value="#{categoria.id}" />
                                        </h:commandLink>
                                        <h:commandLink action="#{CategoriasBean.remove(categoria.id)}" onclick="if(!confirm('¿Realmente desea borrar este categoría?')) return false">
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