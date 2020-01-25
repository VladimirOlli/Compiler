package Main;


import java.util.ArrayList;

class NodeToken extends Node {

    private Token token;

    public NodeToken(Token token) {

        this.token = token;
    }
    
}
class Node {

}
class NodeIdent extends NodeToken {

    public NodeIdent(Token token) {
        super(token);
    }
}

class NodeLiteral extends NodeToken {

    public NodeLiteral(Token token) {
        super(token);
    }
}

class NodeOp extends NodeToken {

    public NodeOp(Token token) {
        super(token);
    }
}


class NodeBinOp extends NodeToken {
    NodeToken left;
    NodeToken right;
    public NodeBinOp(Token token, NodeToken left, NodeToken right) {
        super(token);


    }
}
class NodeNone extends Node {

}
class NodeUnOp extends NodeToken {

    public NodeUnOp(Token token) {
        super(token);
    }

}
class NodeProgram extends Node {
    private NodeIdent name;

    private NodeProgramBlock block;
    public NodeProgram(NodeIdent name, NodeProgramBlock block) {
        this.name = name;
        this.block = block;
    }

}
class NodeProgramBlock extends Node {
    private NodeDeclaratPart declaratPart;

    private NodeCompoundStatement compoundStatement;
    public NodeProgramBlock(NodeDeclaratPart declaratPart, NodeCompoundStatement compoundStatement) {
        this.declaratPart = declaratPart;
        this.compoundStatement = compoundStatement;
    }
}
class NodeDeclaratPart extends Node{

    private NodeSectionList sectionList;

    public NodeDeclaratPart(NodeSectionList sectionList) {
        this.sectionList = sectionList;
    }


}
class NodeCompoundStatement extends Node{

}
class NodeSectionList extends Node{
    ArrayList<Node> sectionList;

    public NodeSectionList(ArrayList<Node> sectionList) {
        this.sectionList = sectionList;
    }
}

class NodeType extends NodeToken{

    public NodeType(Token token) {
        super(token);
    }
}

class  NodeVar extends NodeToken{

    private NodeType type;

    public NodeVar(Token token, NodeType type) {
        super(token);
        this.type = type;
    }
}

class NodeSection extends Node{
    private NodeProcedure procedure;

}
class NodeProcedure extends Node{

}