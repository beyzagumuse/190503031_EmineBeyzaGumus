public class  Kurse extends Trainer,Sportler{
    private String kursenummer;
    private int preis;
    private String tage; //arraylist or array
    private String kursename;
    private int anzahlSportler;

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setAnzahlSportler(int anzahlSportler) {
        this.anzahlSportler = anzahlSportler;
    }

    public void setKursename(String kursename) {
        this.kursename = kursename;
    }

    public void setKursenummer(String kursenummer) {
        this.kursenummer = kursenummer;
    }

    public void setTage(String tage) {
        this.tage = tage;
    }

    public int getPreis() {
        return preis;
    }

    public int getAnzahlSportler() {
        return anzahlSportler;
    }

    public String getKursename() {
        return kursename;
    }

    public String getKursenummer() {
        return kursenummer;
    }

    public String getTage() {
        return tage;
    }

    public void addKurse(){


    }

    public void deleteKurse(String kursenummer){

    }

    public void searchKurse(String kursenummer){

    }

    public void editKurse(String kursenummer){

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






}
