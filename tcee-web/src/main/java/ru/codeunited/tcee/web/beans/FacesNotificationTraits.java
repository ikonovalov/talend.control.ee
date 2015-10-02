package ru.codeunited.tcee.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 02.10.15.
 */
public interface FacesNotificationTraits {

    default void notification(String summary, String detail) {
        message(summary, detail, FacesMessage.SEVERITY_INFO);
    }

    default void message(String summary, String detail, FacesMessage.Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
