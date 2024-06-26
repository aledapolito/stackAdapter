package myTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

//main class to execute
/**
 * Classe main in cui vengono eseguiti i test.
 *
 * @version JUnit 4.13;
 * @version Harmcrest 1.3;
 * @version JVM from JME CLDC 1.1
 */

public class TestRunner {
    private static int totalTests=0;
    public static void main(String[] args){
        Result res;
        Result classeListAdapter;
        Result classeListIteratorAdapterTest;

        System.out.println("**Test in execution..**\n");

        System.out.println("\nTest of ListAdapter..");
        res = JUnitCore.runClasses(TestList.class);
        classeListAdapter = JUnitCore.runClasses(ListAdapterTest.class);
        classeListIteratorAdapterTest= JUnitCore.runClasses(ListIteratorAdapterTest.class);
        esitoTest(res);
        esitoTest(classeListAdapter);
        esitoTest(classeListIteratorAdapterTest);

        System.out.println("\n*** All the " + totalTests + " tests have been completed +**");
    }

    /*  Print the test result for every suite case.
        For every suite is indicated how many test of the relative suite have been executed and how many failed.
    */
    private static void esitoTest(Result res)
    {
        totalTests += res.getRunCount();
        System.out.print("Of " + res.getRunCount() + " tests ");
        if (res.wasSuccessful())
        {
            System.out.println("all are with a positive result");
        }
        else
        {
            System.out.println("failed " + res.getFailureCount() + " tests");
            List<Failure> fails = res.getFailures();
            Iterator<Failure> iter = fails.iterator();
            while(iter.hasNext())
            {
                System.out.println(iter.next().toString());
            }
        }
    }
}

