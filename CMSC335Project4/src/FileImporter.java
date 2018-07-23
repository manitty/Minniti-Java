


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JPanel;

public class FileImporter {
	public static World readFile(File file, JPanel jobPanel) {
		World world = new World(null);
		try {
			BufferedReader fileInput = new BufferedReader(new FileReader(file));

			while (fileInput.ready()) {
				String inputString = fileInput.readLine().trim();
				Scanner scannerInput = new Scanner(inputString);

				if (!inputString.startsWith("//")) {
					String type = "";
					if (scannerInput.hasNext()) {
						type = scannerInput.next();
					}

					if (type.equalsIgnoreCase("port")) {
						world.assignPort(new SeaPort(scannerInput));
					} else if (type.equalsIgnoreCase("dock")) {
						world.assignDock(new Dock(scannerInput));
					} else if (type.equalsIgnoreCase("ship")) {
						world.assignShip(new Ship(scannerInput));
					} else if (type.equalsIgnoreCase("pship")) {
						world.assignShip(new PassengerShip(scannerInput));
					} else if (type.equalsIgnoreCase("cship")) {
						world.assignShip(new CargoShip(scannerInput));
					} else if (type.equalsIgnoreCase("person")) {
						world.assignPerson(new Person(scannerInput));
					} else if (type.equalsIgnoreCase("job")) {
						world.assignJob(new Job(scannerInput, jobPanel, world));
					}
				}
			}
			System.out.println(world.toString());
			fileInput.close();
			return world;
			
		}
		
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return world;
	}

}
