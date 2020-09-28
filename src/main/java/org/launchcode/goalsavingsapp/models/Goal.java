package org.launchcode.goalsavingsapp.models;



import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

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

    private LocalDate startDate;

    private LocalDate goalDate;

    private LocalDate completeDate;

//    LocalDate localDate_Norway = zdt_Norway.toLocalDate();


    public Goal() {}

    public Goal(@NotNull String title, @NotNull int cost, boolean isPublic, User user) {
        this.title = title;
        this.cost = cost;
        this.isPublic = isPublic;
        this.user = user;
        this.startDate = LocalDate.now();
        this.goalDate = LocalDate.of(2020, Month.DECEMBER, 15);
        this.completeDate = null;
    }

    public Goal(@NotNull String title, @NotNull int cost, int amountSaved, boolean isPublic, User user) {
        this.title = title;
        this.cost = cost;
        this.isPublic = isPublic;
        this.amountSaved = amountSaved;
        this.user = user;
        this.startDate = LocalDate.now();
        this.goalDate = LocalDate.of(2020, Month.DECEMBER, 15);
        this.completeDate = null;
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

    public User getUser() {
        return user;
    }

    public void setIsCompleted() {
        completed = cost == amountSaved; if(completed) {completeDate = LocalDate.now();}
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //decimals and negatives not dealt this yet
}
