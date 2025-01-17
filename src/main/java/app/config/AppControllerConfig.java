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

import app.controllers.CertificationsController;
import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;



/**
 * @author Igor Polevoy
 */
public class AppControllerConfig extends AbstractControllerConfig {

    public void init(AppContext context) {
        add(new DBConnectionFilter("default", true));
        add(new DBConnectionFilter("AS2_db", true)).to(CertificationsController.class);
        add(new DBConnectionFilter("trans_db", false)).to(CertificationsController.class);
        add(new DBConnectionFilter("DESKTOP-UVS825B:1433", false)).to(CertificationsController.class);
        add(new DBConnectionFilter("easyroad_db", false)).to(CertificationsController.class);

    }
}
