package ru.codeunited;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * codeunited.ru
 * konovalov84@gmail.com
 * Created by ikonovalov on 06.10.15.
 */
@XmlRootElement
public class TalendJobServiceDescriptor {

    private String name;

    private String version;

    public TalendJobServiceDescriptor() {

    }

    public TalendJobServiceDescriptor(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
