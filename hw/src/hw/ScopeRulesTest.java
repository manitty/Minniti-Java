package hw;

public class ScopeRulesTest {
public static void main(String[] args) {
        ScopeRulesTest scopeRulesTest = new ScopeRulesTest();
        scopeRulesTest.legalSameNameVariables(false);
        scopeRulesTest.legalForwardReferences();
        scopeRulesTest.illegalForwardReferences();
    }
/** Two local variables with same name exit in same method. **/
public void legalSameNameVariables(boolean b) {
        boolean isTrue = b;
        if (isTrue == true) {
            int x = 1; // Adds 1 to local variable x.
            System.out.println("x is " + x);
        } else {
            int x = 0; // Adds 0 to local variable x.
            System.out.println("x is " + x);
        }
    }
/** Forward references are not always illegal. **/
public void legalForwardReferences() {
        int x = y; // Adds global variable y to local variable x.
        System.out.println("x is " + x);
    }
    private static int y = 1; // Defines static global variable y.
public void illegalForwardReferences() {
        int y = x; // x is unresolved. You will get a compile error.
        System.out.println("y is " + y);
    }
}