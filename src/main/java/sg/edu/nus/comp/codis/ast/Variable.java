package sg.edu.nus.comp.codis.ast;

/**
 * Created by Sergey Mechtaev on 7/4/2016.
 */
public abstract class Variable extends Leaf {
    public abstract Type getType();
    public abstract boolean isTestInstantiable();
}
