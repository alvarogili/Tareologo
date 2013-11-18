<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<!DOCTYPE html>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Tareólogo</title>
            <style type="text/css" media="screen">
                <%@ include file="css/common.css" %>
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
                contenido
            </div>
        </body>
    </html>
</f:view>
