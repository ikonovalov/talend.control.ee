package ru.codeunited;

import javax.ejb.Remote;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 22.09.15.
 */
@Remote
public interface NewSessionBusiness {
    String businessMethod();
}
