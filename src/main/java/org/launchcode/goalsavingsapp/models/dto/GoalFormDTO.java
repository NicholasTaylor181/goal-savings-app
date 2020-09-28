package org.launchcode.goalsavingsapp.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class GoalFormDTO {

    @NotNull
    @NotBlank(message="Must not be blank")
    @Size(min=3, max=50, message="Username must be between 3 and 50 characters")
    private String title;

    @NotNull(message="Must not be blank")
    private int cost;

    private int amountSaved;

    private boolean isPublic;

    private boolean completed;

    private LocalDate goalDate;

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

    public LocalDate getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(String goalDate) {
        String[] goalDateArr = goalDate.split("-");
        int year = Integer.parseInt(goalDateArr[0]);
        int month = Integer.parseInt(goalDateArr[1]);
        int day = Integer.parseInt(goalDateArr[2]);
        this.goalDate = LocalDate.of(year, month, day);
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

    public void setIsPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;


    }
}
