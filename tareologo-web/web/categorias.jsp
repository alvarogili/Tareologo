<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<!DOCTYPE html>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <title>Tare�logo</title>
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
                    <h:commandLink styleClass="logo" action="index" value="Tare�logo" />
                </h:form>
                <h:form id="formMenu">                    
                    <h:commandLink styleClass="menu" action="index" value="Inicio"/>
                    <h:commandLink styleClass="menu" action="responsables" value="Responsables" />
                    <h:commandLink styleClass="menu" action="categorias" value="Categor�as" style="background-color: #333333; color:white; font-style: italic;" />
                </h:form>
            </nav>
            <div id="contenido">
                <center>
                    <b style="font-size: 20px;">Lista de categor�as</b>
                    <br>
                    <br>
                </center>
                <h:form id="buscar">
                    Filtrar por nombre:
                    <h:inputText id="filtro" label="Buscar" value="#{CategoriasBean.filter}" />
                    <h:commandButton type="submit" styleClass="boton" value="Aplicar" action="categorias" />
                    <h:commandLink id="quitarFiltro" styleClass="link" value="Quitar filtro" action="#{CategoriasBean.removeFilter()}" /> 
                </h:form>
                <h:form id="nuevo">
                    <h:commandButton styleClass="boton" value="Agregar nueva" action="agregarCategoria" />  
                </h:form>
                <br>
                <center>                
                    <br>
                    <table id="lista-categorias">  
                        <c:choose>
                            <c:when test="${empty CategoriasBean.categorias}">       
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <br>
                                <b style="font-size: 20px;">No se cargaron categor�as a�n.</b>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td class="cabecera">Nombre</td>
                                    <td class="cabecera">Descripci�n</td>     
                                    <td class="cabecera-check">Administraci�n</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach items="#{CategoriasBean.categorias}" var="categoria" varStatus="status">
                            <tr class="fila">
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${categoria.nombre}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}">${categoria.descripcion}</td>
                                <td class="${status.count % 2 == 0? "fila-par": "fila-impar"}-check"> 
                                    <h:form>
                                        <h:commandLink action="#{EditCategoriaBean.edit(categoria)}" value="Editar" />
                                        <h:commandLink action="#{CategoriasBean.remove(categoria.id)}" onclick="if(!confirm('�Realmente desea borrar este categor�a?')) return false">
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