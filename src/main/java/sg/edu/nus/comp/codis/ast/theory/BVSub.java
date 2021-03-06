package sg.edu.nus.comp.codis.ast.theory;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import sg.edu.nus.comp.codis.ast.BottomUpMemoVisitor;
import sg.edu.nus.comp.codis.ast.BottomUpVisitor;
import sg.edu.nus.comp.codis.ast.Node;
import sg.edu.nus.comp.codis.ast.TopDownVisitor;

import java.util.ArrayList;

/**
 * Created by Sergey Mechtaev on 30/4/2016.
 */
public class BVSub extends BinaryOp {

    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public BVSub(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(BottomUpVisitor visitor) {
        left.accept(visitor);
        right.accept(visitor);
        visitor.visit(this);
    }

    @Override
    public void accept(TopDownVisitor visitor) {
        visitor.visit(this);
        left.accept(visitor);
        right.accept(visitor);
    }

    @Override
    public void accept(BottomUpMemoVisitor visitor) {
        if (visitor.alreadyVisited(this)) {
            visitor.visitAgain(this);
        } else {
            left.accept(visitor);
            right.accept(visitor);
            visitor.visit(this);
        }
    }


    @Override
    public ArrayList<Node> getArgs() {
        ArrayList<Node> result = new ArrayList<>();
        result.add(left);
        result.add(right);
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BVSub))
            return false;
        if (obj == this)
            return true;

        BVSub rhs = (BVSub) obj;
        return new EqualsBuilder().
                append(left, rhs.left).
                append(right, rhs.right).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(left).
                append(right).
                toHashCode();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + "-" + right.toString() + ")";
    }

}
