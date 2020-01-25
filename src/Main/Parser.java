package Main;


import java.util.ArrayList;

public class Parser {
    private Tokenizer tokenizer;

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;


    }

    public Node parseMain() {
        return null;
    }

    public Token next() {
        return tokenizer.next();
    }

    public Token nextBack() {
        Token token = next();
        tokenizer.backToken(token);
        return token;
    }

    public void error(Token token) {
        System.out.println("Ошибка в парсере");
        System.out.println(token);
        System.exit(0);
    }

    public boolean tokenCheckValue(Token token, Enum value) {
        return token.getValue() == value;
    }

    public boolean tokenCheckType(Token token, TokenType type) {
        return token.getType() == type;
    }

    public Token reqTokenValue(Enum value) {
        Token token = next();
        if (tokenCheckValue(token, value)) {
            return token;
        } else {
            error(token);
            return null;
        }
    }

    public Token reqTokenType(TokenType type) {
        Token token = next();
        if (tokenCheckType(token, type)) {
            return token;
        } else {
            error(token);
            return null;
        }
    }

    private NodeProgram program() {
        reqTokenValue(KeywordType.PROGRAM);
        NodeIdent name = new NodeIdent(reqTokenType(TokenType.IDENT));
        reqTokenValue(SepType.SEMI);
        NodeProgramBlock block = programBlock();
        reqTokenValue(SepType.POINT);
        return new NodeProgram(name, block);
    }

    private NodeProgramBlock programBlock() {
        NodeDeclaratPart declaratPart = declaratPart();
        NodeCompoundStatement compoundStatement = compoundStatement();
        return new NodeProgramBlock(declaratPart, compoundStatement);
    }

    private NodeCompoundStatement compoundStatement() {

    }

    private NodeDeclaratPart declaratPart() {
        NodeSectionList sectionList = sectionList();
        return new NodeDeclaratPart(sectionList);
    }

    private NodeSectionList sectionList() {
        ArrayList<Node> sectionList = new ArrayList<Node>();
        if (tokenCheckValue(nextBack(), KeywordType.VAR)) {
            reqTokenValue(KeywordType.VAR);
            while (tokenCheckType(nextBack(), TokenType.IDENT)) {
                sectionList.add(varDeclaration());
                reqTokenValue(SepType.SEMI);
            }
        }
        while (tokenCheckValue(nextBack(), KeywordType.PROCEDURE)){
            sectionList.add(procedure());
        }
        return new NodeSectionList(sectionList);
    }

    private NodeSection varDeclaration() {
        ArrayList<Token> varList = new ArrayList<Token>();
        varList.add(reqTokenType(TokenType.IDENT));
        while (tokenCheckValue(nextBack(),SepType.COMMA)) {
            reqTokenValue(SepType.COMMA);
            varList.add(reqTokenType(TokenType.IDENT));
        }
        reqTokenValue(OpType.COLON);
        NodeType type = new NodeType(next());
        ArrayList<NodeVar> nodeVar = new ArrayList<NodeVar>();
        nodeVar.add(type)

    }

    private NodeProcedure procedure() {
        reqTokenValue(KeywordType.PROCEDURE);
        NodeIdent name = new NodeIdent(reqTokenType(TokenType.IDENT));
        reqTokenValue(SepType.SEMI);
        NodeProgramBlock block = programBlock();
        reqTokenValue(SepType.SEMI);
        return new NodeProcedure();
    }
}


