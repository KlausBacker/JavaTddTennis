public class Joueur {

    String nom;
    int point = 0;
    boolean avantage = false;
    int jeux = 0;
    int set = 0;


    public Joueur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isAvantage() {
        return avantage;
    }

    public void setAvantage(boolean avantage) {
        this.avantage = avantage;
    }

    public int getJeux() {
        return jeux;
    }

    public void setJeux(int jeux) {
        this.jeux = jeux;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }
}
