package org.tdc2014.demos.deltaspike.infrastrutura;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;

@ExceptionHandler
public class FacesExceptionHandler {

    // Mostra a mensagem de erro no JSF
    void showFacesMessage(@Handles ExceptionEvent<Throwable> evt, FacesContext facesContext) {
        facesContext.addMessage(null, new FacesMessage(evt.getException().getMessage()));
        evt.handledAndContinue();
    }

}