public class Partie {

    private Joueur joueur1 = new Joueur("Maxime");
    private Joueur joueur2 = new Joueur("Nicolas");
    private Joueur JoueurVainqueur;

    private int pointJoueur1 = 0;
    private int pointJoueur2 = 0;

    private int setJoueur1 = 0;
    private int setJoueur2 = 0;

    private int jeuxJoueur1 = 0;
    private int jeuxJoueur2 = 0;


    public Partie() {
    }

    public Partie(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public Joueur getJoueurVainqueur() {
        return JoueurVainqueur;
    }

    public void setJoueurVainqueur(Joueur joueurVainqueur) {
        JoueurVainqueur = joueurVainqueur;
    }

    public int getPointJoueur1() {
        return pointJoueur1;
    }

    public void setPointJoueur1(int pointJoueur1) {
        this.pointJoueur1 = pointJoueur1;
    }

    public int getPointJoueur2() {
        return pointJoueur2;
    }

    public void setPointJoueur2(int pointJoueur2) {
        this.pointJoueur2 = pointJoueur2;
    }

    public int getSetJoueur1() {
        return setJoueur1;
    }

    public void setSetJoueur1(int setJoueur1) {
        this.setJoueur1 = setJoueur1;
    }

    public int getSetJoueur2() {
        return setJoueur2;
    }

    public void setSetJoueur2(int setJoueur2) {
        this.setJoueur2 = setJoueur2;
    }

    public int getJeuxJoueur1() {
        return jeuxJoueur1;
    }

    public void setJeuxJoueur1(int jeuxJoueur1) {
        this.jeuxJoueur1 = jeuxJoueur1;
    }

    public int getJeuxJoueur2() {
        return jeuxJoueur2;
    }

    public void setJeuxJoueur2(int jeuxJoueur2) {
        this.jeuxJoueur2 = jeuxJoueur2;
    }

}
