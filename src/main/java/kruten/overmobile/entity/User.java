package kruten.overmobile.entity;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


public class User {
    @Id
    @NotBlank
    private String id;
    @Positive
    private long userId;
    @Positive
    private double sum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public User() {
    }

    public User(long userId, double sum) {
        this.userId = userId;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", sum=" + sum +
                '}';
    }
}
