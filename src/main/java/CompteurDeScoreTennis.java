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

    // TODO à supprimer plus tard si  vraiment on le decide et que on s'est mis d'accord par rapport à ça et q'on a signé
    public int AjoutDepointTest(int PointsJoueur) {
        if (PointsJoueur == 0) {
            PointsJoueur = 15;
        } else if (PointsJoueur == 15) {
            PointsJoueur = 30;
        } else if (PointsJoueur == 30) {
            PointsJoueur = 40;
        } else if (PointsJoueur == 40) {

        }
        return PointsJoueur;
    }

    public void ajoutDepoint(Joueur joueur, Partie partie) {
        Joueur adversaire = null;
        if (joueur == partie.getJoueur1()) {
            adversaire = partie.getJoueur2();
        } else if (joueur == partie.getJoueur2()) {
            partie.getJoueur1().setAvantage(false);
            adversaire = partie.getJoueur1();
        }
        // ajout de points
        if (joueur.getPoint() == 0) {
            joueur.setPoint(15);
        } else if (joueur.getPoint() == 15) {
            joueur.setPoint(30);
        } else if (joueur.getPoint() == 30) {
            joueur.setPoint(40);
            // si il y a 40 pts
        } else if (joueur.getPoint() == 40) {
            // si je le joueur a 40 points et que l'adversaire a moins de 40 points => +1 jeu pour le joueur
            if (adversaire.getPoint() < 40) {
                joueur.setJeux(joueur.getJeux()+1);
            }
            // si le joueur a 40 point + un avantage et que l'adversaire a aussi 40 points => +1 jeux pour le joueur
            else if (adversaire.getPoint() == 40) {
                if (joueur.isAvantage()) {
                    joueur.setJeux(joueur.getJeux()+1);
                }
                // si le joueur a 40 pts sans avantage et que l'adversaire a aussi 40 pts => avantage =true pour la joueur
                if (!joueur.isAvantage()) {
                    joueur.setAvantage(true);
                    // si le joueur a 40 pts sans avantage et que l'adversaire a 40 pts et un avantage => avantage=true pour le joueur et avantage=false pour l'adversaire
                    if (adversaire.isAvantage()) {
                        adversaire.setAvantage(false);
                    }
                }
            }
        }
    }


    public void gestionAvantage(Joueur joueur) {
        joueur.setAvantage(true);
    }


}

