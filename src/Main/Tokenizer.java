package Main;


import java.util.HashMap;
import java.util.function.Supplier;

public class Tokenizer {
    private String program;

    public Tokenizer(String program){
        this.program = program + "\n";
        generateHash();
    }
    private void generateHash(){    // генерация хэш таблицы
        int j = 0;
        for (StateType state: StateType.values()) {
            HashMap<Character, Supplier> row = new HashMap<>();
            for (int i = 0; i < symbolMass.length; i++) {
                row.put(symbolMass[i], stateTable[j][i]);
            }
            hashMap.put(state, row);
            j++;
        }
    }

    private char[] symbolMass = {'\t', '\r', '\n', ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~'};

    private Supplier[][] stateTable = {{this::nothing, this::nothing, this::plusLine, this::nothing, this::error, this::error, this::error, this::error, this::error, this::error, this::toStr, this::returnSep, this::returnSep, this::toMultiply, this::toPlus, this::returnSep, this::toMinus, this::toPoint, this::toSlash, this::toInt, this::toInt, this::toInt, this::toInt, this::toInt, this::toInt, this::toInt, this::toInt, this::toInt, this::toInt, this::toColon, this::returnSep, this::toLess, this::returnOp, this::toHigh, this::error, this::error, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::returnSep, this::error, this::returnSep, this::error, this::toWord, this::error, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toWord, this::toCommentB, this::error, this::error, this::error},
            {this::addSymbol, this::addSymbol,this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnString, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol},
            {this::returnOpBack, this::returnOpBack,this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::returnOp, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error},
            {this::returnOpBack, this::returnOpBack,this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::error, this::error, this::returnOp, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::returnOp, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error},
            {this::returnOpBack,this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::error, this::error, this::error, this::error, this::returnOp, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::returnOp, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error},
            {this::returnOpBack,this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::toCommentS, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::returnOp, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error},
            {this::returnIntBack,this::returnIntBack, this::returnIntBack, this::returnIntBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnIntBack, this::returnIntBack, this::returnIntBack, this::returnIntBack, this::returnIntBack, this::toDoublePoint, this::returnIntBack, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::error, this::returnIntBack, this::returnIntBack, this::returnIntBack, this::returnIntBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnIntBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnIntBack, this::error, this::error, this::error},
            {this::returnOpBack, this::returnOpBack,this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOp, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error},
            {this::returnOpBack, this::returnOpBack,this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::error, this::error, this::returnOpBack, this::error, this::returnOpBack, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::returnOp, this::returnOp, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error},
            {this::returnOpBack,this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::error, this::error, this::returnOpBack, this::error, this::returnOpBack, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::returnOp, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::returnOpBack, this::error, this::error, this::error, this::error},
            {this::returnWordBack,this::returnWordBack,  this::returnWordBack, this::returnWordBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::returnWordBack, this::error, this::error, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnWordBack, this::error, this::returnWordBack, this::error, this::addSymbol, this::error, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnWordBack, this::error, this::error, this::error},
            {this::addSymbol,this::returnCommentSBack, this::returnCommentSBack, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol},
            {this::returnRealBack, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::error, this::returnRealBack, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::error, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::returnRealBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnRealBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnRealBack, this::error, this::error, this::error},
            {this::addSymbol,this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::addSymbol, this::returnCommentB, this::addSymbol},
            {this::error, this::error,  this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnIntBackBack, this::error, this::toReal, this::toReal, this::toReal, this::toReal, this::toReal, this::toReal, this::toReal, this::toReal, this::toReal, this::toReal, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error},
            {this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnOp, this::returnSepBack, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::error, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::error, this::error, this::error, this::error, this::error, this::error, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::returnSepBack, this::error, this::error, this::error}};

    private Token toStr() {
        addSymbol();
        state = StateType.STRING;
        return null;
    }

    private Token returnRealBack() {
        backIndex();
        return new TokenReal(line, position, TokenType.DOUBLE, word);
    }

    private Token returnCommentB() {
        addSymbol();
        state = StateType.START;
        word = "";
        return null;
    }

    private Token toCommentB() {
        addSymbol();
        state = StateType.COMMENT_B;
        return null;
    }

    private Token toWord() {
        addSymbol();
        state = StateType.WORD;
        return null;
    }

    private Token toHigh() {
        addSymbol();
        state = StateType.HIGH;
        return null;
    }

    private Token toSlash() {
        addSymbol();
        state = StateType.SLASH;
        return null;
    }

    private Token toPoint() {
        addSymbol();
        state = StateType.POINT;
        return null;
    }

    private Token toLess() {
        addSymbol();
        state = StateType.LESS;
        return null;
    }

    private Token toColon() {
        addSymbol();
        state = StateType.COLON;
        return null;
    }

    private Token toInt() {
        addSymbol();
        state = StateType.INT;
        return null;
    }

    private Token toMinus() {
        addSymbol();
        state = StateType.MINUS;
        return null;
    }

    private Token toDoublePoint() {
        addSymbol();
        state = StateType.DOUBLE_POINT;
        return null;
    }

    private Token toReal() {
        addSymbol();
        state = StateType.REAL;
        return null;
    }

    private Token returnIntBackBack() {
        backIndex();
        backIndex();
        word = word.substring(0, word.length() - 1);
        return new TokenInt(line, position, TokenType.INT, word);
    }

    private Token toCommentS() {
        addSymbol();
        state = StateType.COMMENT_S;
        return null;
    }

    private Token toMultiply() {
        addSymbol();
        state = StateType.MULTIPLY;
        return null;
    }

    private Token toPlus() {
        addSymbol();
        state = StateType.PLUS;
        return null;
    }

    private Token returnString() {
        addSymbol();
        return new TokenStr(line, position, TokenType.STRING, word);
    }

    private Token returnOp() {
        addSymbol();
        return new TokenOp(line, position, TokenType.OPERATOR, word);
    }

    private Token returnSep() {
        addSymbol();
        return new TokenSep(line, position, TokenType.SEPARATOR, word);
    }

    private Token returnSepBack() {
        backIndex();
        return new TokenSep(line, position, TokenType.SEPARATOR, word);
    }

    private Token returnCommentSBack() {
        backIndex();
        state = StateType.START;
        word = "";
        return null;
    }

    private Token returnWordBack() {
        backIndex();
        word = word.toLowerCase();
       if (KeywordType.hasItem(word)) {
           return new TokenKeyword(line, position, TokenType.KEYWORD, word);
       }else if (word.equals("true") || word.equals("false")){
           return new TokenBool(line, position, TokenType.BOOLEAN, word);
       }else{
           return new TokenIdent(line, position, TokenType.IDENT, word);
       }
    }

    private Token returnIntBack() {
        backIndex();
        return new TokenInt(line, position, TokenType.INT, word);
    }

    private Token returnOpBack() {
        backIndex();
        return new TokenOp(line, position, TokenType.OPERATOR, word);
    }

    private Token addSymbol() {
        word += symbol;
        return null;
    }

    private Token error() {
        addSymbol();
        System.out.println("Ошибка в токене емерженси ситуэйшн лив зе билдинг эмидиатели");
        System.out.println(word);
        //System.exit(0);
       // return null;
        return new TokenOp(line, position, TokenType.ERROR, word);
    }

    private Token plusLine() {
        line++;
        position = 0;
        return null;
    }

    private Token nothing() {
        return null;
    }

    private void backIndex(){
        index--;
        position--;
    }

    public void backToken(Token token) {
        previous = token;
    }

    Token previous = null;
    String word = "";
    char symbol = ' ';
    int index = 0;
    int position = 0;
    int line = 0;
    StateType state = StateType.START;

    HashMap<StateType, HashMap<Character, Supplier>> hashMap = new HashMap<StateType, HashMap<Character, Supplier>>();

    public Token next(){
        if (previous != null) {
            Token token = previous;
            previous = null;
            return token;
        }
        while (index < program.length()){   //цикл который получает строку, позицию, тип ,имя токена через хэш талицу
            symbol = program.charAt(index);
            index++;
            position++;
            Token token = (Token) hashMap.get(state).get(symbol).get();
            if (token != null){
                state = StateType.START;
                word = "";
                return token;
            }
        }
        return new Token(0, 0, TokenType.EOF, "");
    }
}
