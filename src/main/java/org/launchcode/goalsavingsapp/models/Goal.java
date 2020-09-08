package org.launchcode.goalsavingsapp.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Goal extends AbstractEntity {

    @NotNull
    private String title;

    @NotNull
    private int cost;

    private int amountSaved;

    private boolean isPublic;


    private boolean isCompleted;

    public Goal() {}

    public Goal(@NotNull String title, @NotNull int cost, boolean isPublic) {
        this.title = title;
        this.cost = cost;
        this.isPublic = isPublic;
    }

    public Goal(@NotNull String title, @NotNull int cost, int amountSaved, boolean isPublic) {
        this.title = title;
        this.cost = cost;
        this.isPublic = isPublic;
        this.amountSaved = amountSaved;
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    private void setIsCompleted() {
        isCompleted = cost == amountSaved;
    }
}
