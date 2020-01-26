package Main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class LexTester {
    private  int testAmount = 101;
    private String testStr;
    private String textProgram;
    public LexTester() throws IOException {
        for (int i =1 ; i <= testAmount; i++){
            String url = "src/Tests/Lexer/" + String.format("%03d", i) + ".pas";
            String url2 = "src/Tests/Lexer/" + String.format("%03d", i) + "_answ.txt";
            File testFile = new File(url);
            File answFile = new File(url2);
            String test = Files.readString(testFile.toPath()) + "\n";
            test = test.substring(1);
            Tokenizer tokenizer = new Tokenizer(test);
            StringBuilder s = new StringBuilder();
            Token token = tokenizer.next();
            while (token.getType() != TokenType.EOF){
                s.append(token).append("\n");
                token = tokenizer.next();
            }
            FileWriter out = new FileWriter(answFile);
            String result = s.toString().substring(0, s.toString().length() - 1);
            out.write(result);
            out.flush();
            out.close();
            String answ = Files.readString(answFile.toPath());

            if (result.equals(answ)) {
                System.out.println(String.format("%03d", i) + " -> Ok");
            } else {
                System.out.println(String.format("%03d", i) + " -> Error");
            }

        }

    }
    public boolean checkTest(String url1, String url2) throws IOException {
        FileReader fileReader1 = new FileReader(url1);
        FileReader fileReader2 = new FileReader(url2);
        Scanner scan1 = new Scanner(fileReader1);
        Scanner scan2 = new Scanner(fileReader2);

        while (scan1.hasNext()){
            String s1 = scan1.next();
            String s2 = scan2.next();
            if (!s1.equals(s2)){
                return false;
            }
        }
        return true;
    }

}
