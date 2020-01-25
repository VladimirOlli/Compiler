package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String filetext = Files.readString(Paths.get("src/Main/TestProgram.pas"));
        Tokenizer tokenizer = new Tokenizer(filetext);
        Token token = tokenizer.next();
        while (token.getType() != TokenType.EOF) {
            System.out.println(token);
            token = tokenizer.next();   //вывод и переход к следующему токену
        }

        System.out.println("Выполнено!");
    }
}
