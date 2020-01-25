package Main;

import java.awt.*;

enum StateType {
    START,
    STRING,
    MULTIPLY,
    PLUS,
    MINUS,
    SLASH,
    INT,
    COLON,
    LESS,
    HIGH,
    WORD,
    COMMENT_S,
    REAL,
    COMMENT_B,
    DOUBLE_POINT,
    POINT;

}

enum TokenType {
    IDENT,
    KEYWORD,
    SEPARATOR,
    OPERATOR,
    INT,
    DOUBLE,
    STRING,
    CHAR,
    BOOLEAN,
    ERROR,
    EOF
}

enum SepType {
    POINT("."),
    COMMA(","),
    SEMI(";"),
    F_PARENT("("),
    S_PARENT(")"),
    F_BRACKET("["),
    S_BRACKET("]");
    private String value;

    SepType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SepType getItem(String s) {
        for (SepType item : values()) {
            if (item.getValue().equals(s)) {
                return item;
            }
        }
        return null;
    }
}

enum OpType {
    EQUAL("="),
    MORE(">"),
    LESS("<"),
    ASSIGN(":="),
    MASS(".."),
    MORE_EQUAL(">="),
    LESS_EQUAL("<="),
    COLON(":");
    private String value;

    OpType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OpType getItem(String s) {
        for (OpType item : values()) {
            if (item.getValue().equals(s)) {
                return item;
            }
        }
        return null;
    }
}

enum KeywordType {
    INTEGER("integer"),
    STRING("string"),
    BOOLEAN("boolean"),
    BEGIN("begin"),
    END("end"),
    IF("if"),
    CHAR("char"),
    WHILE("while"),
    OF("of"),
    AND("and"),
    ARRAY("array"),
    BREAK("break"),
    CONST("const"),
    DIV("div"),
    DO("do"),
    ELSE("else"),
    FOR("for"),
    FUNCTION("function"),
    NOT("not"),
    OR("or"),
    REPEAT("repeat"),
    THEN("then"),
    TO("to"),
    TYPE("type"),
    UNTIL("until"),
    VAR("var"),
    PROGRAM("program"),
    PROCEDURE("procedure");

    private String value;

    KeywordType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static KeywordType getItem(String s) {   //оперделение keyword 
        s = s.toLowerCase();
        for (KeywordType item : values()) {
            if (item.getValue().equals(s)) {
                return item;
            }
        }
        return null;
    }
    public static boolean hasItem(String s){
        return getItem(s) != null;
    }
}