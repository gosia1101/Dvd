package Models;

import java.util.Date;

public class Rent {

    private int idDvd;
    private int idClient;
    private int idRent;
    private String dateFrom;
    private String dateTo;
public Rent(){}
    public Rent(int idDvd, int idClient, int idRent, String dateFrom, String dateTo) {
        this.idDvd = idDvd;
        this.idClient = idClient;
        this.idRent = idRent;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getIdDvd() {
        return idDvd;
    }

    public void setIdDvd(int idDvd) {
        this.idDvd = idDvd;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdRent() {
        return idRent;
    }

    public void setIdRent(int idRent) {
        this.idRent = idRent;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "idDvd=" + idDvd +
                ", idClient=" + idClient +
                ", idRent=" + idRent +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
