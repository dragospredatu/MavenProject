package curs14;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class TestJsonProcessor {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		JsonProcessor obj = new JsonProcessor();
		obj.writeJson();
		obj.readJson("email");
		obj.updateJsonFile("email", "altemail@altemai.com");
		obj.readJson("email");
		obj.deleteFromJsonFile("name");
		obj.readJson("name");
	}

}
