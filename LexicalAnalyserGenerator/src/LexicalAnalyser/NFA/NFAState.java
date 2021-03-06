package LexicalAnalyser.NFA;

import LexicalAnalyser.BaseModels.State;
import LexicalAnalyser.Regex.EpsilonRegularDefinition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by alyswidan on 16/03/18.
 */
public class NFAState extends State {

    public NFAState(String name) {
        super(name);
    }

    public NFAState(){
        super();
    }

    public static NFAState epsilonSink(Set<NFAState> inStates){
        NFAState thisState = new NFAState();
        inStates.forEach(inState -> inState.addTransition(new EpsilonRegularDefinition(),thisState));
        return thisState;
    }

    public static NFAState epsilonSource(Collection<NFAState> outStates){
        NFAState thisState = new NFAState();
        outStates.forEach(outState -> thisState.addTransition(new EpsilonRegularDefinition(),outState));
        return thisState;
    }
}
