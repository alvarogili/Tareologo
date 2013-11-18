<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <f:view>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Agregar categoría</title>
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
                </h:form>
                <h:form id="formMenu">                    
                    <h:commandLink styleClass="menu" action="index" value="Inicio"/>
                    <h:commandLink styleClass="menu" action="responsables" value="Responsables" />
                    <h:commandLink styleClass="menu" action="categorias" value="Categorías" style="background-color: #333333; color:white; font-style: italic;" />
                </h:form>                
            </nav>
            <div id="contenido">
                <center>
                    <%--<c:choose>
                        <c:when test="${categoría != null}">
                            <b style="font-size: 20px;">Editando categoría</b>            
                        </c:when>
<c:otherwise>      --%>
                    <b style="font-size: 20px;">Agregando una categoría</b>            
                    <%-- </c:otherwise>
</c:choose>--%>
                    <br>
                    <br>
                    <br>
                    <%--action="#{categoría != null?'/tareologo/categorías?action=update':'/tareologo/categorías'}"--%>
                    <h:form  id="addCategoria">
                        <%--<c:if test="${categoría != null}">
                            <h:inputHidden id="id" value="#{categoría.id}" />
                        </c:if>--%>
                        <br>
                        <div>
                            <h:outputLabel for="nombre" value="Nombre:" />
                        </div>
                        <div>
                            <h:inputText styleClass="campo" id="nombre" value="#{CategoriaBean.nombre}" required="true" />
                        </div>
                        <hr>
                        <div>
                            <h:outputLabel for="descripcion" value="Descripcion:" />
                        </div>
                        <div>
                            <h:inputText styleClass="campo" id="descripcion" value="#{CategoriaBean.descripcion}" />
                        </div>
                        <hr>                                    
                        <h:commandButton type="submit" value="  Guardar  " actionListener="#{CategoriaBean.guardarCategoria()}" action="categorias" />                        
                        <%-- ver de ocultarlo en edición --%>
                        <h:commandButton value="Limpiar campos" type="reset" />
                        <br>
                        <br>
                    </h:form>
                </center>
            </div>
        </body>
    </f:view>
</html>