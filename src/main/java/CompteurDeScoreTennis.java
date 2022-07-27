public class CompteurDeScoreTennis {

    public static Partie creationPartie() {
        Partie partie = new Partie();
        return partie;
    }

    public Partie creationPartieAvec2joueurs(Joueur joueur1, Joueur joueur2) {
        if (joueur1 == null && joueur2 == null) {
            throw new RuntimeException("Il manque des joueurs pour créer la partie !");
        }
        if (joueur1 == null || joueur2 == null) {
            throw new RuntimeException("Il manque un joueur pour créer la partie !");
        }
        return new Partie(joueur1, joueur2);
    }


    public void AjoutDepoint(Joueur joueur1) {
    }
}
