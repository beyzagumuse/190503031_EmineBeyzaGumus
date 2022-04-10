public class Sportler extends Person{
    private String sportlernummer;
    private int schuld;
    private String krankenheit; //arraylist or array
    private int muskelv;
    private int fettrate;
    //private Kurse[];


    public void addSportler(String sportlernummer, Person a){
        this.sportlernummer = sportlernummer;

    }

    public void deleteSportler(String sportlernummer){

    }

    public void searchSportler(String sportlernummer){

    }

    public void editSportler(String sportlernummer){

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


    public void setSportlernummer(String sportlernummer) {
        this.sportlernummer = sportlernummer;
    }

    public void setSchuld(int schuld) {
        this.schuld = schuld;
    }

    public void setMuskelv(int muskelv) {
        this.muskelv = muskelv;
    }

    public void setKrankenheit(String krankenheit) {
        this.krankenheit = krankenheit;
    }

    public void setFettrate(int fettrate) {
        this.fettrate = fettrate;
    }

    public String getSportlernummer() {
        return sportlernummer;
    }

    public String getKrankenheit() {
        return krankenheit;
    }

    public int getSchuld() {
        return schuld;
    }

    public int getMuskelv() {
        return muskelv;
    }

    public int getFettrate() {
        return fettrate;
    }




}
