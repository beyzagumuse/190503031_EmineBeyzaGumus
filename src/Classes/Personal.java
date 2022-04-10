public class Personal extends Person{
    private String personalnummer;


    public void addPersonal(String personalnummer, Person a){
        this.personalnummer = personalnummer;

    }

    public void deletePersonal(String personalnummer){

    }

    public void searchPersonal(String personalnummer){

    }

    public void editPersonal(String personalnummer){

    }


    /*@Override
    public String getName(){
        return "Personal: " + name;
    }

    @Override
    public String toString(){
        String s = "PersonalId: " + id + "\nName: " + name + "\nNachname: " + nachname;
        return super.toString();
    }*/



    public void setPersonalnummer(String personalnummer) {
        this.personalnummer = personalnummer;
    }

    public String getPersonalnummer() {
        return personalnummer;
    }


}
