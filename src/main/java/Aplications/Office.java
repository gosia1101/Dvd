package Aplications;

import Models.Client;
import Models.Dvd;
import Models.Rent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@XmlRootElement(name = "Office")
@XmlAccessorType (XmlAccessType.FIELD)
@XmlSeeAlso(ArrayList.class)

public class Office {

    @XmlElement(name="Dvd")
    List<Dvd> dvds=new ArrayList<Dvd>();
    List<Client> clients=new ArrayList<Client>();
    List<Rent> rentals=new ArrayList<Rent>();
    Scanner sc=new Scanner(System.in);
   // static   Office office=new Office();

    public List<Dvd> getDvds() {
        return dvds;
    }

    public void setDvds(List<Dvd> dvds) {
        this.dvds = dvds;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Rent> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rent> rentals) {
        this.rentals = rentals;
    }




public void addDvd(){

    Dvd dvd=new Dvd();

    System.out.println("Podaj id");
    dvd.setId(sc.nextInt());

    System.out.println("Podaj tytul");
    String t;
    t=sc.next();
    dvd.setTitle(t);
    dvd.setIsavailable(true);

    System.out.println("Podaj rodzaj");
    dvd.setType(sc.next());
    System.out.println(dvd.toString());

    dvds.add(dvd);
    /*try {
        marshalingExample();
    } catch (JAXBException e) {
        e.printStackTrace();
    }*/
}
public void getListDvd(){
    jaxbXmlFileToObject("Dvd.xml");
    for (Dvd d: dvds){
        System.out.println(d.toString());
    }
}
    public void getListRent(){

        for (Rent r: rentals){
            System.out.println(r.toString());
        }
    }
public void addClient(){
    Client c=new Client();

    System.out.println("Podaj id");
    c.setId(sc.nextInt());

    System.out.println("Podaj imie");

   c.setFirstName(sc.next());

    System.out.println("Podaj nazwisko");
    c.setLastName(sc.next());
    System.out.println("Podaj date urodzenia");
    c.setBirthDate(sc.next());
    clients.add(c);
}

    public void getListClients(){

        for (Client c: clients){
            System.out.println(c.toString());
        }
    }

   public Dvd searchDvd(int id){

    for(Dvd d:dvds){
        if(d.getId()==id)
            return d;
    }return null;

   }
    public Client searchClient(int id){

        for(Client c:clients){
            if(c.getId()==id)
                return c;
        }return null;

    }

    public void addRent(){

    Rent rent=new Rent();
        System.out.println("Podaj id wypozyczenia");
    rent.setIdRent(sc.nextInt());
    System.out.println("Lista dvd");
        getListDvd();
        System.out.println("Wybierz id dvd");
        int idDvd;
        idDvd=sc.nextInt();

        Dvd dvd= searchDvd(idDvd);
        System.out.println(dvd.toString());
        System.out.println("Lista klintów");

        System.out.println("Wybierz id klienta");
        int idKlient;
        idKlient=sc.nextInt();
        Client client=searchClient(idKlient);
       // System.out.println(client.t);
rent.setIdClient(client.getId());

       rent.setIdDvd(dvd.getId());
        System.out.println("Podaj date wypozyczenia");
        rent.setDateFrom(sc.next());
        System.out.println("Podaj date zwrotu");
        rent.setDateTo(sc.next());
        dvd.setIsavailable(false);
        System.out.println(dvd.getisIsavailable());
        rentals.add(rent);
    }

    private static void jaxbObjectToXML(Dvd dvd)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Office.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File("Dvd.xml");

            //Writes XML file to file-system
            jaxbMarshaller.marshal(dvd, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

    private static void jaxbXmlFileToObject(String fileName) {
//https://howtodoinjava.com/jaxb/jaxb-exmaple-marshalling-and-unmarshalling-list-or-set-of-objects/
        //https://howtodoinjava.com/jaxb/write-object-to-xml/
        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Dvd.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Dvd dvd = (Dvd) jaxbUnmarshaller.unmarshal(xmlFile);

            System.out.println(dvd);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
    private  void marshalingExample() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Models.Dvd.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        //jaxbMarshaller.marshal(dvds, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(dvds, new File("Dvd.xml"));
    }
public void getData(){
    SimpleDateFormat sdf = new SimpleDateFormat("7" +
            "MM-dd-yyyy");
    Scanner sc = new Scanner(System.in);

      System.out.println("Eample: 12-25-2103");
      System.out.print("Enter date: ");
    String str = sc.nextLine();

      try {
        Date date = sdf.parse(str);

        sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        System.out.println("Date: " + sdf.format(date));
    } catch (ParseException e) {
        System.out.println("Parse Exception");
    }}
}
