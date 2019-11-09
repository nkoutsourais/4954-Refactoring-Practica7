package es.urjccode.mastercloudapps.adcs.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import es.urjccode.mastercloudapps.adcs.draughts.checkers.AllCheckerTest;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.AllControllerTest;
import es.urjccode.mastercloudapps.adcs.draughts.models.AllModelTest;
import es.urjccode.mastercloudapps.adcs.draughts.views.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllCheckerTest.class,
    AllModelTest.class, 
    AllControllerTest.class, 
    AllViewTest.class } )
public final class AllTest {
}