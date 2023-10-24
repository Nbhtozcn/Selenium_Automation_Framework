package step_definitions;

import javax.naming.Context;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> scenarioContext;
    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }


    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }


    public Object getContext(String key){
        return scenarioContext.get(key);
    }


    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key);
    }
}
