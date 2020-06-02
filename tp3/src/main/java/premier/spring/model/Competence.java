package premier.spring.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class   Competence {

    private String intituleC;
    private String descriptionC;
    private Collection<Projet> requisePour=new ArrayList<>();
    private Collection<CompetenceMenbre> comprend=new ArrayList<>();

    // Constructeurs

    public Competence() {
        this.requisePour=new ArrayList<>();
    }

    public Competence(String intituleC, String descriptionC) {
        this();
        this.intituleC = intituleC;
        this.descriptionC = descriptionC;
    }


    public void comprend(CompetenceMenbre competenceMenbre){
        this.comprend.add(competenceMenbre);
    }
    // Getters et setters

    public String getIntituleC() {
        return intituleC;
    }

    public void setIntituleC(String intituleC) {
        this.intituleC = intituleC;
    }

    public String getDescriptionC() {
        return descriptionC;
    }

    public void setDescriptionC(String descriptionC) {
        this.descriptionC = descriptionC;
    }

    public Collection<Projet> getRequisePour() {
        return requisePour;
    }

    public void setRequisePour(Collection<Projet> requisePour) {
        this.requisePour = requisePour;
    }

    public Collection<CompetenceMenbre> getComprend() {
        return comprend;
    }

    public void setComprend(Collection<CompetenceMenbre> comprend) {
        this.comprend = comprend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competence that = (Competence) o;
        return intituleC.equals(that.intituleC) &&
                descriptionC.equals(that.descriptionC) &&
                requisePour.equals(that.requisePour) &&
                comprend.equals(that.comprend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intituleC, descriptionC, requisePour, comprend);
    }
}
