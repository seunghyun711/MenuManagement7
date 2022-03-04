package hi.practice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hi {

    private String name;
    private int age;

    public static void main(String[] args) {
        Hi hi = new Hi();
        hi.setName("wow");

        String name = hi.getName();
        System.out.println("name = " + name);
    }
}
