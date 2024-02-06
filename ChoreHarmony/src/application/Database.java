package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Database class represents a database for storing information about
 * households created in the chore management app.
 * 
 * It is designed to be a singleton class, meaning there can only be one
 * instance of the database.
 * 
 * It implements the Serializable interface, 
 * allowing objects of this class to be serialized and deserialized.
 * "它实现了Serializable接口，允许该类的对象被序列化和反序列化。"这句话的意思是，
 * 这个类实现了Serializable接口，这使得该类的对象可以被转换成字节流（序列化）
 * 以便在文件或网络上传输，同时也可以从字节流还原成对象（反序列化）。
 * 这是在Java中用于数据持久化和传输的一种机制，使得对象的状态可以被保存和恢复，
 * 或者在不同的Java应用程序之间进行通信。
 */

public class Database implements Serializable {

	/**
     * A unique identifier for the class, used during object serialization to ensure compatibility.
     */
    private static final long serialVersionUID = 1L;

	
    /**
     * The constant file name for the database file.
     * This value can be modified to change the name of the database file.
     */

    private static final String FILENAME = "householdDataBase.db";
    
    /**
     * A static variable that holds the single instance of the `Database` class.
     * This follows the Singleton pattern, ensuring that only one instance of the database exists.
     */
    private static Database single_instance = null;

    /**
     * An ArrayList that stores Household objects, representing the data within the database.
     */
    private ArrayList<Household> households = new ArrayList<>();

	/**
	 * Constructs a Database object with an initial list of households.
	 *
	 * @param households An ArrayList of Household objects to initialise the
	 *                   database.
	 */
	public Database(ArrayList<Household> households) {
		super();
		this.households = households;
	}

	/**
	 * Constructs an empty Database object.
	 */

	public Database() {
		super();
	}

	/**
	 * Retrieves the list of households stored in the database.
	 *
	 * @return An ArrayList of Household objects.
	 */

	public ArrayList<Household> getHouseholds() {
		return households;
	}

	/**
	 * Sets the list of households in the database to a new ArrayList.
	 *
	 * @param households An ArrayList of Household objects to replace the existing
	 *                   list.
	 */

	public void setHouseholds(ArrayList<Household> households) {
		this.households = households;
	}

	/**
	 * Adds a household to the database.
	 *
	 * @param household The Household object to be added to the database.
	 */

	public void addHousehold(Household household) {
		households.add(household);
		saveData();
	}

	/**
	 * Get the singleton instance of the Database class. If an instance does not
	 * exist, it loads the data from a file and creates one.
	 *
	 * @return The singleton instance of the `Database` class.
	 */

	public static synchronized Database getInstance() {
		// Check if the single_instance (the singleton instance) is null.
		if (single_instance == null) {
			// If it's null, it means there is no existing instance of the Database class.
			// So, we need to create one by loading data from a file.

			// The line below calls the loadData() method to load the data from a file.
			single_instance = loadData(); // This method typically loads the database, for example, loadDb(String)

			// Once the data is loaded, it creates a new instance of the Database class and
			// stores it in single_instance.
			// Subsequent calls to getInstance will return this single_instance.

			// After the instance is created and the data is loaded, this block will not be
			// executed again.
			// This ensures that only one instance of the Database class exists throughout
			// the program.

		}

		// Return the singleton instance of the Database class.
		return single_instance;
	}

	/**
	 * Save the data of the current database object to a file.
	 *
	 * @throws IOException if there is a file input/output error during the save
	 *                     operation.
	 */
	public void saveData() {
		// Create a file output stream to write data to a file.
		FileOutputStream fileOutputStream;
		ObjectOutputStream objectOutputStream;
		try {
			fileOutputStream = new FileOutputStream(FILENAME);
		

		// Create an object output stream to serialize and write objects to the file.
		objectOutputStream = new ObjectOutputStream(fileOutputStream);

		// Use the object output stream to write the current database object (i.e.,
		// this) to the file.
		objectOutputStream.writeObject(this);
		objectOutputStream.flush();
		objectOutputStream.close();


		// Flush and close the object output stream to ensure the data is written to the
		// file.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Load the database from a file named "householdDataBase.db".
	 * If the file exists, it reads and deserializes the data into a Database object.
	 * If the file does not exist or an error occurs during the process, it returns a new, empty Database object.
	 *
	 * @return The loaded Database instance or a new empty instance in case of errors or missing file.
	 */
	public static Database loadData() {
	    FileInputStream fileInputStream;

	    try {
	        // Create a FileInputStream to read from the "householdDataBase.db" file.
	        fileInputStream = new FileInputStream(FILENAME);
	        
	        // Create an ObjectInputStream to deserialize objects from the file.
	        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	        
	        // Read and deserialize the data from the file into a Database object.
	        Database db = (Database) objectInputStream.readObject();
	        
	        // Close the ObjectInputStream to release resources.
	        objectInputStream.close();
	        
	        // Return the loaded Database instance.
	        return db;
	    } catch (IOException | ClassNotFoundException e) {
	        // If an IOException or ClassNotFoundException occurs, it means the file doesn't exist
	        // or there's an issue reading it. In this case, it falls back to creating
	        // a new, empty Database instance and logs the error.
	        e.printStackTrace();
	        
	        // Return a new, empty Database instance as a fallback.
	        return new Database();
	    }
	}
	

}
