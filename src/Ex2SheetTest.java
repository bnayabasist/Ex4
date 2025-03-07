import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex2SheetTest {

    @Test
    public void testComputeIf() {
        Ex2Sheet sheet = new Ex2Sheet();
        String check = "=if(1<2,50,100)";
        assertEquals("50.0", sheet.computeIf(check));



    }
    @Test
    public void testComputeIf_FalseCondition() {
        Ex2Sheet sheet = new Ex2Sheet();
        assertEquals("100.0", sheet.computeIf("=if(2<1,50,100)"));

    }

    @Test
    public void testIsValidIf_ValidIf() {
        Ex2Sheet sheet = new Ex2Sheet();
        assertEquals(Ex2Utils.IF, sheet.isvalidIf("=if(1<2,50,100)"));
        assertEquals(Ex2Utils.IF, sheet.isvalidIf("=if(A1>2,big,small)"));
    }


    @Test
    public void testisvalidIf() {
        Ex2Sheet sheet = new Ex2Sheet();
        assertEquals(Ex2Utils.IF_ERR, sheet.isvalidIf("=if(1,2,3)"));
        assertEquals(Ex2Utils.IF_ERR, sheet.isvalidIf("=if(A1>1,1)"));
        assertEquals(Ex2Utils.IF_ERR, sheet.isvalidIf("=if(A1>A2,=(A1,12))"));
        assertEquals(Ex2Utils.IF_ERR, sheet.isvalidIf("if(1<2,50,100)")); // Missing '='
        assertEquals(Ex2Utils.IF_ERR, sheet.isvalidIf("=if(1<2,50)")); // Missing third argument
        assertEquals(Ex2Utils.IF_ERR, sheet.isvalidIf("=if(1<2,50,100")); // Missing closing parenthesis

    }
}