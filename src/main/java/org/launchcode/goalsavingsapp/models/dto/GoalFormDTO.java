package org.launchcode.goalsavingsapp.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GoalFormDTO {

    @NotNull
    @NotBlank(message="Must not be blank")
    @Size(min=3, max=50, message="Username must be between 3 and 50 characters")
    private String title;

    @NotNull
    @NotBlank(message="Must not be blank")
    private int cost;

    private int amountSaved;

    private boolean isPublic;

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
}
