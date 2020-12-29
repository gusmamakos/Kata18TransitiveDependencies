import java.util.*;

public class DependencyCalculator {
    Map<String, HashSet<String>> dependencyList = new HashMap<>();

    public DependencyCalculator(){
    }

    public void addDepenency(String name, HashSet<String> depenencies){
        this.dependencyList.put(name, depenencies);
    }

    public HashSet<String> dependenciesFor(String name){
        HashSet<String> result = this.dependencyList.get(name);
        HashSet<String> processing = (HashSet<String>) result.clone();

        for (String s : processing) {
            if(dependencyList.containsKey(s)){
                result.addAll(dependenciesFor(s));
            }
        }
        return result;
    }
}
