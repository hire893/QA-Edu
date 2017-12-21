import com.welcome.Hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter your name");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Hello name = new Hello();
        name.setupName(reader.readLine());
        name.welcome();
        System.out.println("Hello, World");
        name.byeBye();
    }
}
