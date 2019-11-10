package es.urjccode.mastercloudapps.adcs.draughts.checkers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    CoordinatesCheckerTest.class,
    BoardCheckerTest.class,
    PieceCheckerTest.class } )
public final class AllCheckerTest {
}