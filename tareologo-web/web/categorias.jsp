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
            <div id="titulo">
                <h1>Tareólogo</h1>        
            </div>
            <nav>
                <h:form>
                    <h:commandLink action="index" value="Inicio" />
                    <h:commandLink action="responsables" value="Responsables" />
                    <h:commandLink action="categorias" value="Categorías"  style="color:blanchedalmond;" />
                </h:form>
            </nav>
            <div id="contenido">
                <center>
                    <b style="font-size: 20px;">Lista de categorías</b>
                    <br>
                    <br>
                </center>
                <h:form id="buscar-categoria">
                    <h:inputText id="filtro" label="Buscar" value="" />
                    <h:commandButton type="submit" styleClass="boton" value="Filtrar" />
                </h:form>
                <h:form id="nuevaCat">
                    <h:commandButton styleClass="boton" value="Agregar nueva" action="agregarCategoria" />  
                </h:form>
                <br>
                <center>                
                    <br>
                    <div id="lista-categorias">  
                        <c:choose>
                            <c:when test="@{CategoriasBean.categorias.size() == 0}">                        
                                <b style="font-size: 20px;">No se cargaron categorías aún.</b>
                            </c:when>
                            <c:otherwise>
                                <div class="cabecera">Nombre</div>
                                <div class="cabecera">Descripción</div>     
                                <div class="cabecera-check">Administración</div>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="#{CategoriasBean.categorias}" var="categoria" varStatus="status">
                            <div class="fila">
                                <div class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${categoria.nombre}</div>
                                <div class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${categoria.descripcion}</div>
                                <div class="${status.count % 2 == 0? "fila-par": "fila-impar"}-check"> 
                                    <h:form>
                                        <h:commandLink action="CategoriasBean.edit" value="Editar"  >
                                            <f:param name="action" value="edit" />
                                            <f:param name="id" value="#{categoria.id}" />
                                        </h:commandLink>
                                        <h:commandLink action="#{CategoriasBean.remove(categoria.id)}" onclick="if(!confirm('¿Realmente desea borrar este categoría?')) return false">
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