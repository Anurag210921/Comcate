package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class checkExcelFunctionalityTest {
	ArrayList<String> l = new ArrayList();

	@Test
	public void getData() throws IOException {

		l = dataDriven.getDataAsList("items");
		
		for(String list: l)
		{
		System.out.println(list);
		
		}

	}

}
