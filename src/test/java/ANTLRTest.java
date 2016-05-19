import com.akos.language.*;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ANTLRTest {

    public static void main(String[] args) {
        CharStream in = new ANTLRInputStream("10 A = 10\n20 ? A");
        OrbbasicLexer lexer = new OrbbasicLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OrbbasicParser parser = new OrbbasicParser(tokens);
        parser.prog();
    }

}
