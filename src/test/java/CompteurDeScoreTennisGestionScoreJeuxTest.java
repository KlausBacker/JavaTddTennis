import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompteurDeScoreTennisGestionScoreJeuxTest {

    CompteurDeScoreTennis compteur;
    Joueur joueur1;
    Joueur joueur2;
    int pointJoueur1 = 0;
    int pointJoueur2 = 0;

    @BeforeEach
    public void Initialize() {
        this.compteur = new CompteurDeScoreTennis();
        this.joueur1 = new Joueur("Maxime");
        this.joueur2 = new Joueur("Nicolas");
    }


    @Test
    public void ajoutDeScore_ajoute15PointsAuxJoueurs() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        compteur.ajoutDepoint(j1, nouvellePartie);
        assertEquals(15, j1.getPoint());
    }

    @Test
    public void ajoutDeScore_ajoute30PointsAuxJoueurs() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j2 = nouvellePartie.getJoueur2();
        j2.setPoint(15);
        compteur.ajoutDepoint(j2, nouvellePartie);
        assertEquals(30, j2.getPoint());
        System.out.println(j2.getPoint());
    }

    @Test
    public void ajoutDeScore_ajoute40PointsAuxJoueurs() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j2 = nouvellePartie.getJoueur2();
        j2.setPoint(30);
        compteur.ajoutDepoint(j2, nouvellePartie);
        assertEquals(40, j2.getPoint());
        System.out.println(j2.getPoint());
    }

    @Test
    public void ajoutDAvantage_ajouteUnAvanteSiPointA40() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        j1.setPoint(40);
        compteur.ajoutDepoint(j1, nouvellePartie);
        assertTrue(j1.isAvantage());
    }

    @Test
    public void ajoutJeux_ajouteUnjeuSiJoueurGagneAvec40PtsEtQueJoueur2AMoinsDe40Pts() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        j1.setPoint(40);
        j1.setJeux(2);
        joueur2.setPoint(30);
        compteur.ajoutDepoint(j1, nouvellePartie);
        assertEquals(3, j1.getJeux());
    }

    @Test
    public void ajoutJeux_ajouteUnjeuSiJoueurGagneAvecAvantage() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        j1.setPoint(40);
        j1.setAvantage(true);
        compteur.ajoutDepoint(j1, nouvellePartie);
        assertTrue(j1.isAvantage());
        assertEquals(1, j1.getJeux());
    }

    @Test
    public void ajoutJeux_ajouteUnjeuSiJoueurGagneAvecAvantageSijoueurADejaUnJeu() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        j1.setPoint(40);
        j1.setAvantage(true);
        j1.setJeux(4);
        System.out.println(j1.getJeux());
        compteur.ajoutDepoint(j1, nouvellePartie);
        System.out.println(j1.getJeux());
        assertTrue(j1.isAvantage());
        assertEquals(5, j1.getJeux());
    }

    @Test
    public void ajoutAvantage_ajouteUnAvantageAuJoueurSiLesDeuxJoueurOnt40Pts() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        j1.setPoint(40);
        joueur2.setPoint(40);
        compteur.ajoutDepoint(j1, nouvellePartie);
        assertTrue(j1.isAvantage());
        assertFalse(joueur2.isAvantage());
    }

    @Test
    public void ajoutAvantage_retireUnAvantageAuJoueurSilperdlechange() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        j1.setPoint(40);
        j1.setAvantage(true);
        joueur2.setPoint(40);
        compteur.ajoutDepoint(joueur2, nouvellePartie);
        assertFalse(j1.isAvantage());
        assertTrue(joueur2.isAvantage());
    }
}
