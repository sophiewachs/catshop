package fr.aruku.catshop.api.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Notepad {

    @XmlTransient
    private String content;

    public Notepad() {
    }

    public Notepad(String content) {
        this.content = content;
    }

    @XmlElement
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
