import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompteurDeScoreTennisInitialisationTest {

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
//



}
