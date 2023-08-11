import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class poki {
	
	public void generate(List<String> data) throws InterruptedException{
		if (data.size()>50){
			throw new InterruptedException("Error");
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		poki obj = new poki();
		List<String> data = new ArrayList<>(Collections.nCopies(500,"Method"));
		obj.generate(data);
	}
}

