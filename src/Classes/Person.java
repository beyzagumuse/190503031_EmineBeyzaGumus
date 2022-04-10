public class Person {
    private String id;
    private String name;
    private String nachname;
    private String telno;
    private String adresse;
    private String email;

    /*public Person(String a) {



    }


    public boolean checkId(String id){
        if ((id.length() == 7) && id.matches("[0-9]+")) {
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o){
        Person p = (Person) o;
        if(id.equals(p.id) ==true){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String s = "Id: " + id + "\nName: " + name + "\nNachname: " + nachname;
        return s;
    }

    public void setAll(String n, String a, int al){
        name = n;
        adresse = a;
        alter = al;
    }*/


    //public abstract void printinfo();

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelno(String telno){
        this.telno = telno();
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setNachname(String nachname){
        this.nachname = nachname;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAlter() {
        return alter;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getNachname() {
        return nachname;
    }
}
