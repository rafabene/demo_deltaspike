package com.rafabene.demos.deltaspike.infraestrutura.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.apache.deltaspike.security.api.authorization.AccessDeniedException;

import com.rafabene.demos.deltaspike.infraestrutura.i18n.ApplicationMessages;

@ApplicationScoped
@ExceptionHandler
public class FacesExceptionHandler {

    @Inject
    private ApplicationMessages applicationMessages;

    // Mostra a mensagem de erro no JSF
    void showFacesMessage(@Handles ExceptionEvent<Throwable> evt, FacesContext facesContext) {
        facesContext.addMessage(null, new FacesMessage(evt.getException().getMessage()));
        evt.handledAndContinue();
    }

    // Propaga a exception
    void handleAccessDenied(@Handles ExceptionEvent<AccessDeniedException> evt, FacesContext facesContext) {
        facesContext.addMessage(null, new FacesMessage(applicationMessages.acessoNegado()));
        evt.rethrow(evt.getException());
    }
}