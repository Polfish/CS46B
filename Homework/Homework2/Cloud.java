package Homework.Homework2;

public class Cloud {
    private float top;
    private float bottom;

    public Cloud(float bottom, float top) {
        this.bottom = bottom;
        this.top = top;
    }

    public float getHeight() {
        return top - bottom;
    }

    public String rain() {
        return "It is raining";
    }


}
