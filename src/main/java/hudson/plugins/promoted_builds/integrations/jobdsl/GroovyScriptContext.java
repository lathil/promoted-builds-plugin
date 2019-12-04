package hudson.plugins.promoted_builds.integrations.jobdsl;

import javaposse.jobdsl.dsl.Context;

import javax.annotation.CheckForNull;
import java.util.ArrayList;
import java.util.List;

public class GroovyScriptContext implements Context {

    List<String> classpathEntries = new ArrayList<>();

    private boolean sandbox = false;

    /**
     * Specifies the script classpath. Can be called multiple times to add more entries.
     */
    void classpaths(String... classpaths)  {

        if( classpaths != null && classpaths.length > 0){
            for( String classpath: classpaths){
                classpathEntries.add(classpath);
            }
        }
    }


    void sandbox(@CheckForNull Boolean sandbox){
        if( sandbox != null && sandbox){
            this.sandbox = true;
        }
    }

    public List<String> getClassPathEntries(){
        return classpathEntries;
    }

    public boolean isSandbox() {
        return sandbox;
    }
}
