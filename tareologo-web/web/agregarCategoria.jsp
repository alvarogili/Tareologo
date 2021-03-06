<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<!DOCTYPE html>
<html>
    <f:view>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Agregar categor�a</title>
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
                    <b style="font-size: 20px;">Agregando una categor�a</b>            
                    <br>
                    <br>
                    <br>
                        <h:form  id="addCategoria" >                        
                            <br>
                            <div>
                                <h:outputLabel for="nombre" value="Nombre:" />
                            </div>
                            <div>
                                <h:inputText styleClass="campo" id="nombre" value="#{CategoriaBean.nombre}" 
                                             requiredMessage="El campo \"Nombre\" es obligatorio." required="true" />
                                <h:message for="nombre" style="color:red; font-size:15px;" />
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
                            <h:commandButton value="Limpiar campos" type="reset" immediate="true" />
                            <h:commandButton value="  Cancelar  "  action="categorias" immediate="true" />
                            <br>
                            <br>
                        </h:form>
                    </center>
                </div>
            </body>
    </f:view>
</html>