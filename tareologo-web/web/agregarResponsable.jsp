<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<f:view>
    <html>    
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Agregar responsable</title>
            <style type="text/css" media="screen">
                <%@ include file="css/common.css" %>
            </style>
            <style type="text/css" media="screen">
                <%@ include file="css/responsables.css" %>
            </style>
        </head>
        <body>
            <div id="titulo">
                <h1>Tareólogo</h1>        
            </div>
            <nav>
                <h:form>
                    <h:commandLink action="index" value="Inicio" />
                    <h:commandLink action="responsables" value="Responsables" style="color:blanchedalmond;" />
                    <h:commandLink action="categorias" value="Categorías" />
                </h:form>
            </nav>
            <div id="contenido">
                <center>
                    <%--<c:choose>
                        <c:when test="${responsable != null}">
                            <b style="font-size: 20px;">Editando responsable</b>            
                        </c:when>
<c:otherwise>      --%>
                    <b style="font-size: 20px;">Agregando un responsable</b>            
                    <%-- </c:otherwise>
</c:choose>--%>
                    <br>
                    <br>
                    <br>
                    <%--action="#{responsable != null?'/tareologo/responsables?action=update':'/tareologo/responsables'}"--%>
                    <h:form  id="addResponsable" enctype="multipart/form-data">
                        <%--<c:if test="${responsable != null}">
                            <h:inputHidden id="id" value="#{responsable.id}" />
                        </c:if>--%>
                        <br>
                        <div>
                            <h:outputLabel for="nombre" value="Nombre:" />
                        </div>
                        <div>
                            <h:inputText styleClass="campo" id="nombre" value="#{ResponsableBean.nombre}" required="true" />
                        </div>
                        <hr>
                        <div>
                            <h:outputLabel for="apodo" value="Apodo:" />
                        </div>
                        <div>
                            <h:inputText styleClass="campo" id="apodo" value="#{ResponsableBean.apodo}" />
                        </div>
                        <hr>                                    
                        <div>
                            <h:outputLabel for="email" value="Email:" />
                        </div>
                        <div>
                            <h:inputText styleClass="campo" id="email" value="#{ResponsableBean.email}" required="true" />
                        </div>
                        <hr>    
                        <div>
                            <h:outputLabel for="foto" value="Imagen:" />
                        </div>
                        <div>
                            <%--<c:if test="${responsable.pathFoto != null && !responsable.pathFoto.isEmpty()}">
                                Foto: ${responsable != null?responsable.pathFoto:''}
                            </c:if>                        --%>
                            <h:inputFile id="foto" value="#{ResponsableBean.pathFoto}" />
                        </div>                    
                        <hr>  
                        <h:commandButton type="submit" value="  Guardar  " actionListener="#{ResponsableBean.guardarResponsable()}" action="responsables" />                        
                        <%-- ver de ocultarlo en edición --%>
                        <h:commandButton value="Limpiar campos" type="reset" />
                        <br>
                        <br>
                    </h:form>
                </center>
            </div>
        </body>    
    </html>
</f:view>