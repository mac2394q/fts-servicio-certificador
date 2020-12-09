/*
Copyright 2009-2010 Igor Polevoy 

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License. 
*/
package app.config;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;
import static org.javalite.app_config.AppConfig.p;

/**
 * @author Igor Polevoy
 */
public class DbConfig extends AbstractDBConfig {

    public void init(AppContext context) {

    configFile("/app_config/development.properties");
    if(p("development.tipo_host").equals("1")){
        environment("development", true).db("AS2_db").jdbc(p("carril.fel.driver"), p("carril.fel.url"),p("carril.fel.username"),p("carril.fel.password"));
        environment("development", true).db("trans_db").jdbc(p("carril.dw.driver"), p("carril.dw.url"),p("carril.dw.username"),p("carril.dw.password"));
    }else{
        environment("development", true).db("AS2_db").jdbc(p("servidor.fel.driver"), p("servidor.fel.url"),p("servidor.fel.username"),p("servidor.fel.password"));
        environment("development", true).db("trans_db").jdbc(p("servidor.dw.driver"), p("servidor.dw.url"),p("servidor.dw.username"),p("servidor.dw.password"));
       }
    
    //only migration vas 
    environment("development", true).db("easyroad_db").jdbc(
            p("migration_end.driver"),
            p("migration_end.url"),
            p("migration_end.username"),
            p("migration_end.password"));
    
    environment("development", true).db("DESKTOP-UVS825B:1433").jdbc(
            p("migration_end.driver"), 
            p("migration_end.url"),
            p("migration_end.username"),
            p("migration_end.password"));
    }
    
    
    
    
}
