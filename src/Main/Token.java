package Main;

public class Token {
    private int line;
    private int pos;
    private TokenType type;
    private String strName;
    public Object value;

    public Token(int line, int pos, TokenType type, String strName) {   //параметры токена
        this.line = line;
        this.pos = pos;
        this.type = type;
        this.strName = strName;
    }

    @Override
   public String toString() {
      return String.format("%d\t%d\t%s\t%s\t%s", line, pos, type.name(), strName, value);
    }

    public int getLine() {
        return line;
    }

    public int getPos() {
        return pos;
    }

    public TokenType getType() {
        return type;
    }

    public String getStrName() {
        return strName;
    }

    public Object getValue() {
        return value;
    }
}

class TokenInt extends Token {                  // распределение токенов по значению value
    public TokenInt(int line, int pos, TokenType type, String strName) {
        super(line, pos, type, strName);
        value = Integer.parseInt(strName);
    }
}
class TokenReal extends Token {
    public TokenReal(int line, int pos, TokenType type, String strName) {
        super(line, pos, type, strName);
        value = Double.parseDouble(strName);
    }
}
class TokenStr extends Token {
    public TokenStr(int line, int pos, TokenType type, String strName) {
        super(line, pos, type, strName);
        value = strName.substring(1, strName.length()-1);
    }
}
class TokenBool extends Token {
    public TokenBool(int line, int pos, TokenType type, String strName) {
        super(line, pos, type, strName);
        value = Boolean.parseBoolean(strName);
    }
}
class TokenSep extends Token {
    public TokenSep(int line, int pos, TokenType type, String strName) {
        super(line, pos, type, strName);
        value = SepType.getItem(strName);
    }
}
class TokenOp extends Token {
    public TokenOp(int line, int pos, TokenType type, String strName) {
        super(line, pos, type, strName);
        value = OpType.getItem(strName);
    }
}
class TokenKeyword extends Token {
    public TokenKeyword(int line, int pos, TokenType type, String strName) {
        super(line, pos, type, strName);
        value = KeywordType.getItem(strName);
    }
}
class TokenIdent extends Token {
    public TokenIdent(int line, int pos, TokenType type, String strName) {
        super(line, pos, type, strName);
        value = strName;
    }
}