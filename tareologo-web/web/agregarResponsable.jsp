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
                    <b style="font-size: 20px;">Agregando un responsable</b>            
                    <br>
                    <br>
                    <br>
                    <h:form  id="addResponsable" enctype="multipart/form-data">
                        <br>
                        <div>
                            <h:outputLabel for="nombre" value="Nombre:" />
                        </div>
                        <div>
                            <h:inputText styleClass="campo" id="nombre" value="#{ResponsableBean.nombre}" requiredMessage="El campo \"Nombre\" es obligatorio." required="true" />
                                <h:message for="nombre" style="color:red; font-size:15px;" />
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
                            <h:inputText styleClass="campo" id="email" value="#{ResponsableBean.email}" requiredMessage="El campo \"Email\" es obligatorio." required="true" />
                                <h:message for="email" style="color:red; font-size:15px;" />
                        </div>
                        <hr>    
                        <div>
                            <h:outputLabel for="foto" value="Imagen:" />
                        </div>
                        <div>              
                            <h:inputFile id="foto" value="#{ResponsableBean.pathFoto}" />
                        </div>                    
                        <hr>  
                        <h:commandButton type="submit" value="  Guardar  " actionListener="#{ResponsableBean.guardarResponsable()}" action="responsables" />                        
                        <h:commandButton value="Limpiar campos" type="reset" immediate="true" />
                        <h:commandButton value="  Cancelar  "  action="responsables" immediate="true" />
                        <br>
                        <br>
                    </h:form>
                </center>
            </div>
        </body>    
    </html>
</f:view>