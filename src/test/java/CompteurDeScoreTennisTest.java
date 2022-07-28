import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompteurDeScoreTennisTest {

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
    public void creationPartie_NouvellePartie() {
        //GIVEN
        //WHEN
        Partie newPartie = CompteurDeScoreTennis.creationPartie();
        //THEN
        assertNotNull(newPartie);
        assertInstanceOf(Partie.class, newPartie);
    }

    @Test
    public void choixJoueur_JoueursNonNull() {
        //GIVEN
        //THEN WHEN
        assertThrows(RuntimeException.class, () -> compteur.creationPartieAvec2joueurs(null, null));
        assertThrows(RuntimeException.class, () -> compteur.creationPartieAvec2joueurs(joueur1, null));
        assertThrows(RuntimeException.class, () -> compteur.creationPartieAvec2joueurs(null, joueur2));
    }

    @Test
    public void initialisationDesPoints_InitialiseLesPointsAZero() {
        //GIVEN
        //WHEN
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        //THEN //WHEN
        assertEquals(0, nouvellePartie.getJoueur1().point);
        assertEquals(0, nouvellePartie.getJoueur2().point);
    }

    @Test
    public void initialisatioDesSets_InitialisationDesSetsAZero() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        assertEquals(0, nouvellePartie.getJoueur1().set);
        assertEquals(0, nouvellePartie.getJoueur2().set);
    }

    @Test
    public void initialisatioDesJeux_InitialisationDesJeuxAZero() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        assertEquals(0, nouvellePartie.getJoueur1().jeux);
        assertEquals(0, nouvellePartie.getJoueur2().jeux);
    }

    // TODO à supprimer plus tard si  vraiment on le decide et que on s'est mis d'accord par rapport à ça et q'on a signé
    @Test
    public void ajoutDeScore_ajoute15PointsAuxJoueurTest() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        int resultat = compteur.AjoutDepointTest(j1.getPoint());
        assertEquals(15, resultat);
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
