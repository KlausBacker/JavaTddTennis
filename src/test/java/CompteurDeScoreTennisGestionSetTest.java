import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CompteurDeScoreTennisGestionSetTest {

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
    public void RemiseAZeroJeux_JeuxRemporteRemisAZeroDesPts() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        nouvellePartie.getJoueur1().setPoint(40);
        nouvellePartie.getJoueur2().setPoint(40);
        compteur.remiseAZeroPts(nouvellePartie);
        assertEquals(0, nouvellePartie.getJoueur1().getPoint());
        assertEquals(0, nouvellePartie.getJoueur2().getPoint());
    }

    @Test
    public void RemiseAZeroJeux_AvantageRemporteRemisAZeroDesPts() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        nouvellePartie.getJoueur1().setAvantage(true);
        nouvellePartie.getJoueur2().setPoint(40);
        compteur.remiseAZeroAvantage(nouvellePartie);
        assertFalse(nouvellePartie.getJoueur1().isAvantage());
    }

    @Test
    public void AttributionDeSets_AttributUnSetSiUnJoueurObtient6JeuxEtQueSonAdversaireEnAMoinsDe5() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        Joueur j1 = nouvellePartie.getJoueur1();
        Joueur j2 = nouvellePartie.getJoueur2();

        // joueur 2
        j1.setPoint(40);
        j1.setAvantage(true);
        j1.setJeux(5);
        j1.setSet(0);
        // joueur 2
        j2.setPoint(30);
        j2.setJeux(4);
        j2.setSet(0);

        compteur.ajoutDepoint(j1,nouvellePartie);
        System.out.println(j1.getSet());
        assertEquals(1,j1.getSet());
        assertEquals(0,j2.getSet());
    }


}
