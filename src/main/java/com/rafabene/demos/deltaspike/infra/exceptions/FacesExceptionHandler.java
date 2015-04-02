package com.rafabene.demos.deltaspike.infra.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.apache.deltaspike.security.api.authorization.AccessDeniedException;

import com.rafabene.demos.deltaspike.infra.i18n.Messages;

@ApplicationScoped
@ExceptionHandler
public class FacesExceptionHandler {

    @Inject
    private Messages applicationMessages;

    // Mostra a mensagem de erro no JSF
    void showFacesMessage(@Handles ExceptionEvent<Throwable> evt, FacesContext facesContext) {
        facesContext.addMessage(null, new FacesMessage(evt.getException().getMessage()));
        evt.handledAndContinue();
    }

    // Propaga a exception
    void handleAccessDenied(@Handles ExceptionEvent<AccessDeniedException> evt, FacesContext facesContext) {
        facesContext.addMessage(null, new FacesMessage(applicationMessages.accessDenied()));
        evt.rethrow(evt.getException());
    }
}