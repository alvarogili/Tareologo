<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<!DOCTYPE html>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                    <br>
                    <br>
                    <br>
                    <br>
                    <b style="font-size: 20px;color: red;">La categor�a que desea borrar tiene tareas asociadas</b>    
                    <br>
                    <br>
                </center>                
                <center>                
                    <br>
                    <h:form>
                        <h:commandButton action="categorias" value="Volver a Categor�as" />
                    </h:form>
                </center>
            </div>
        </body>
    </html>
</f:view>