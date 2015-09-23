package ru.codeunited;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 22.09.15.
 */
@Remote
@Local
public interface NewSessionBusiness {
    void businessMethod();
}
