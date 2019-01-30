package Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dvd {

   private String title;
    private String type;
    private boolean isavailable;
    private int id;

    public Dvd(){}

    public Dvd(String title, String type, int id) {
        this.title = title;
        this.type = type;
        this.id = id;
        this.isavailable=true; //przy tworzeniu płyty jest ona domyslnie dostępna
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }



    public void setType(String type) {
        this.type = type;
    }

    public boolean getisIsavailable() {
        return isavailable;
    }

    public void setIsavailable(boolean isavailable) {
        this.isavailable = isavailable;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Dvd{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", isavailable=" + isavailable +
                ", id=" + id +
                '}';
    }
}
