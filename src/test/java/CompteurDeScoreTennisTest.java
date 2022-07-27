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
        assertEquals(0, nouvellePartie.getPointJoueur1());
        assertEquals(0, nouvellePartie.getPointJoueur2());
    }

    @Test
   public void initialisatioDesSets_InitialisationDesSetsAZero() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        assertEquals(0, nouvellePartie.getSetJoueur1());
        assertEquals(0, nouvellePartie.getSetJoueur2());
    }

    @Test
   public void initialisatioDesJeux_InitialisationDesJeuxAZero() {
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        assertEquals(0, nouvellePartie.getJeuxJoueur1());
        assertEquals(0, nouvellePartie.getJeuxJoueur2());
    }

    @Test
    public void ajoutDeScore_ajoute15PointsAuxJoueur(){
        Partie nouvellePartie = compteur.creationPartieAvec2joueurs(joueur1, joueur2);
        compteur.AjoutDepoint(joueur1);

        assertEquals(15, nouvellePartie.getPointJoueur1());

    }


}
