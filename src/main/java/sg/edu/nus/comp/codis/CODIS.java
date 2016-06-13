package sg.edu.nus.comp.codis;

import com.google.common.collect.Multiset;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sg.edu.nus.comp.codis.ast.*;

import java.util.*;

/**
 * Created by Sergey Mechtaev on 7/4/2016.
 */
public class CODIS extends Synthesis {

    private Logger logger = LoggerFactory.getLogger(CEGIS.class);

    private List<Triple<Node, TestCase, Map<Integer, Node>>> path;
    private int bound;

    public CODIS(Solver solver, int bound) {
        this.bound = bound;
    }

    public static List<Component> getLeafs(Program p) {
        throw new UnsupportedOperationException();
    }

    public static Program substitute(Program p, Map<Component, Program> mapping) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Pair<Program, Map<Parameter, Constant>>> synthesize(List<TestCase> testSuite,
                                                                        Multiset<Node> components) {
        throw new UnsupportedOperationException();
    }

}
