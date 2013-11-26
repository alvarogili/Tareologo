<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:p="http://primefaces.prime.com.tr/ui">
    <f:view>
        <h:head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Agregar Tarea</title>
            <style type="text/css" media="screen">
                <%@ include file="css/common.css" %>
            </style>
            <style type="text/css" media="screen">
                <%@ include file="css/tareas.css" %>
            </style>
        </h:head>
        <h:body>
            <h:nav>  
                <h:form>
                    <h:commandLink styleClass="logo" action="index" value="Tareólogo" />
                </h:form>
                <h:form id="formMenu">                    
                    <h:commandLink styleClass="menu" action="index" value="Inicio" style="background-color: #333333; color:white; font-style: italic;" />
                    <h:commandLink styleClass="menu" action="responsables" value="Responsables" />
                    <h:commandLink styleClass="menu" action="categorias" value="Categorías" />
                </h:form>                
            </h:nav>
            <div id="contenido">
                <center>
                    <b style="font-size: 20px;">Agregando una tarea</b>            
                    <br />
                    <br />
                    <br />
                    <h:form  id="addTarea" >                        
                        <br />
                        <div>
                            <h:outputLabel for="titulo" value="Titulo:" />
                        </div>
                        <div>
                            <h:inputText styleClass="campo" id="titulo" value="#{TareaBean.titulo}" 
                                         requiredMessage="El campo \"Titulo\" es obligatorio." required="true" />
                            <h:message for="nombre" style="color:red; font-size:15px;" />
                        </div>
                        <hr />
                        <div>
                            <h:outputLabel for="prioridad" value="Prioridad: " />
                            <h:selectOneMenu id="prioridad" value="#{TareaBean.prioridad}">
                                <f:selectItems value="#{TareasBean.itemsPrioridad}" />                                
                            </h:selectOneMenu>
                        </div>
                        <div>
                            <h:outputLabel for="vencimiento" value="Vencimiento:" />
                            <p:calendar value="#{TareaBean.vencimiento}" id="popupCal" />  
                        </div>
                        <hr />                                    
                        <h:commandButton type="submit" value="  Guardar  " actionListener="#{CategoriaBean.guardarCategoria()}" action="categorias" />                        
                        <h:commandButton value="Limpiar campos" type="reset" immediate="true" />
                        <h:commandButton value="  Cancelar  "  action="index" immediate="true" />
                        <br />
                        <br />
                    </h:form>
                </center>
            </div>
        </body>
    </f:view>
</h:html>