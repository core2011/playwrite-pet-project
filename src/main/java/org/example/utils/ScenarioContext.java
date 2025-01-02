package org.example.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> context;

    public ScenarioContext() {
        this.context = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        context.put(key, value);
    }

    public Object getContext(String key) {
        return context.get(key);
    }

    public Map<String, Object> getContexts() {
        return new HashMap<>(context);
    }
}
