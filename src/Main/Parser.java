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
        reqTokenValue(KeywordType.BEGIN);
        Token token = tokenizer.next();
        ArrayList<Node> statements = new ArrayList<Node>();
        while (tokenCheckValue(token, KeywordType.END)) {
            if (tokenCheckType(nextBack(), TokenType.IDENT)) {
                Token name = reqTokenType(TokenType.IDENT);
                if (tokenCheckValue(nextBack(), OpType.EQUAL)) {
                    reqTokenValue(OpType.EQUAL);
                    statements.add(new NodeInit(new NodeIdent(name), nodeExpr(new NodeToken(name))));
                }else if(tokenCheckValue(nextBack(),SepType.SEMI)){
                    statements.add(new NodeProcedureCall(new NodeToken(name), null));
                }else if(tokenCheckValue(nextBack(),SepType.F_PARENT)) {
                    statements.add(new NodeProcedureCall(new NodeToken(name), paramProcedureList()));
                }
            }else if (tokenCheckValue(nextBack(),KeywordType.IF)){
                reqTokenValue(KeywordType.IF);
                reqTokenValue(SepType.F_PARENT);
                NodeExpr exr = nodeExpr(new NodeToken(token));
                reqTokenValue(SepType.S_PARENT);



            }
        }
        reqTokenValue(KeywordType.END);
        reqTokenValue(SepType.POINT);
        return null;
    }
    private NodeArray paramProcedureList(){
        ArrayList<Node> sectionList = new ArrayList<>();
        Token token = reqTokenValue(TokenType.IDENT);
        NodeToken name = new NodeToken(token);
        sectionList.add(name);
        while (tokenCheckValue(nextBack(), SepType.COMMA)) {
            reqTokenValue(SepType.COMMA);
            sectionList.add(nodeExpr(new NodeToken(token)));
        }
        return new NodeArray(sectionList);
    }
    private NodeDeclaratPart declaratPart() {
        NodeSectionList sectionList = sectionList();
        return new NodeDeclaratPart(sectionList);
    }

    private NodeSectionList sectionList() {
        ArrayList<Node> sectionList = new ArrayList<>();
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
    private NodeArray nodeVarDeclarationList(){
        ArrayList<Node> sectionList = new ArrayList<>();
        while (tokenCheckType(nextBack(), TokenType.IDENT)) {
            sectionList.add(varDeclaration());
            reqTokenValue(SepType.SEMI);
        }
        return new NodeArray(sectionList);
    }

    private NodeSection varDeclaration() {
        ArrayList<Node> varList = new ArrayList<>();
        varList.add(new NodeToken(reqTokenType(TokenType.IDENT)));
        while (tokenCheckValue(nextBack(),SepType.COMMA)) {
            reqTokenValue(SepType.COMMA);
            varList.add(new NodeToken(reqTokenType(TokenType.IDENT)));
        }
        reqTokenValue(OpType.COLON);
        NodeType type = new NodeType(next());
        return new NodeSection(new NodeArray(varList), type);
    }

    private NodeProcedure procedure() {
        reqTokenValue(KeywordType.PROCEDURE);
        NodeIdent name = new NodeIdent(reqTokenType(TokenType.IDENT));
        reqTokenValue(SepType.F_PARENT);
        NodeArray paramList = nodeVarDeclarationList();
        reqTokenValue(SepType.S_PARENT);
        reqTokenValue(SepType.SEMI);
        NodeProgramBlock block = programBlock();
        reqTokenValue(SepType.SEMI);
        return new NodeProcedure(name, paramList, block);
    }
    private NodeExpr nodeExpr(NodeToken name){
        return null;
    }

}


