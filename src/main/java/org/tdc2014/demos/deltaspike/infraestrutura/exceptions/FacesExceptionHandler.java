package org.tdc2014.demos.deltaspike.infraestrutura.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;

import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;

@ApplicationScoped
@ExceptionHandler
public class FacesExceptionHandler {

    // Mostra a mensagem de erro no JSF
    void showFacesMessage(@Handles ExceptionEvent<Throwable> evt, FacesContext facesContext) {
        facesContext.addMessage(null, new FacesMessage(evt.getException().getMessage()));
        evt.handledAndContinue();
    }

}