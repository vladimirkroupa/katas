package stoupa.acm11.clock;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Ignore;

public class InputParserTest {

	@Ignore
	public void test() {
		BufferedReader br = new BufferedReader(new InputStreamReader(readTestFile()));
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(line, "1");
	}

	public InputStream readTestFile() {
		
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("clock.in");
		return in;
	}
	
}
