package LexicalAnalyser.BaseModels;

import LexicalAnalyser.NFA.NFA;
import LexicalAnalyser.Regex.RegularDefinition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateGraphTest {
    static StateGraph g;
    static State start;
    static State end;
    static State temp;
    @BeforeAll
    static void createTestGraph(){
        g = new StateGraph();
        start = new State("start" );
        end  = new State("end");
        temp = new State("temp");
        start.addTransition("a", end);
        start.addTransition("b", end);
        start.addTransition("a",temp);
        temp.addTransition("e",end);
        g.addState(start);
        g.addState(end);
        g.addState(temp);
    }

    @Test
    void getEdges() {
        System.out.println(g);
    }

    @Test
    void duplicateStateNames(){
        State s1 =  new State("start" );
        State s2 = new State();
        start.addTransition("a",s1);
        start.addTransition("c",s2);

        s1.addTransition("a", end);
        s2.addTransition("b", end);
        g.addState(s1);
        g.addState(s2);
        System.out.println(g);
    }

}