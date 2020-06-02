package premier.spring.model;

public class CompetenceMenbre {

    private Membre declarePar;
    private Competence deType;
    private int niveau ;
    private String commentaire;

    public CompetenceMenbre(Membre declarePar, Competence deType, int niveau, String commentaire) {
        this.declarePar = declarePar;
        this.deType = deType;
        this.niveau = niveau;
        this.commentaire = commentaire;
    }

    public CompetenceMenbre() {

    }

    public Membre getDeclarePar() {
        return declarePar;
    }

    public void setDeclarePar(Membre declarePar) {
        this.declarePar = declarePar;
    }

    public Competence getDeType() {
        return deType;
    }

    public void setDeType(Competence deType) {
        this.deType = deType;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
