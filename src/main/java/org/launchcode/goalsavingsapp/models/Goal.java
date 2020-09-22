package org.launchcode.goalsavingsapp.models;



import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Goal extends AbstractEntity {

    @NotNull
    private String title;

    @NotNull
    private int cost;

    private int amountSaved;

    private boolean isPublic;


    private boolean completed;


    @ManyToOne
    private User user;


    public Goal() {}

    public Goal(@NotNull String title, @NotNull int cost, boolean isPublic, User user) {
        this.title = title;
        this.cost = cost;
        this.isPublic = isPublic;
        this.user = user;
    }

    public Goal(@NotNull String title, @NotNull int cost, int amountSaved, boolean isPublic, User user) {
        this.title = title;
        this.cost = cost;
        this.isPublic = isPublic;
        this.amountSaved = amountSaved;
        this.user = user;
        setIsCompleted();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAmountSaved() {
        return amountSaved;
    }

    public void setAmountSaved(int amountSaved) {
        this.amountSaved = amountSaved;
    }

    public boolean getIsPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public void setIsCompleted() {
        completed = cost == amountSaved;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //decimals and negatives not dealt this yet
}
