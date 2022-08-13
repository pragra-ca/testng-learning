import org.testng.Assert;
import org.testng.annotations.*;

public class HomeTest {
    static  int i =0;;
    @Test()
    public void tc(){
        System.out.println("TC1");
        Assert.fail();
    }

    @Test(dependsOnMethods = "tc", alwaysRun = true)
    public void tc2(){
        System.out.println("Test case 2");
    }

    @Test()
    public void tc3(){


        System.out.println("TC3");
    }

    @Test()
    public void tc4(){
        System.out.println("TC4");
      
    }

    @Test(dependsOnMethods = {"tc4","tc3"})
    public void tc5(){
        System.out.println("TC5");
    }
}
