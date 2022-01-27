package myprogram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;



public class projectLockedMe {
	static final String projectFilespath="C:\\Users\\KUNAL\\Desktop\\simplilearn";
	
	
	//main method
	public static void main(String[] args) throws IOException
	{
		Scanner obj=new Scanner(System.in);		
		int choice;
		
		do {
				displayMenu();
				System.out.println("Enter your choice");
				choice=Integer.parseInt(obj.nextLine());
				
				switch(choice)
				{
				case 1:getAllFiles();
				break;
				case 2:createFiles();
				break;
				case 3:deleteFiles();
				break;
				case 4:searchFiles();
				break;
				case 5:System.out.println("LockedMe.com !! Window terminated.");   //message on exiting the program
				System.exit(0);
				break;
				default: System.out.println("Invalid Choice");
				break;
				}
		}
		while(choice>0);
		obj.close();


	
	
	}
	
	
	//display method
	private static void displayMenu() {
		System.out.println("**************************************************************************************");
		System.out.println("\t\tWelcome To Lockedme.com");
		System.out.println("***********************************************************designed by-Megha Dodke****");
		System.out.println("\t\t1. Get all files");
		System.out.println("\t\t2. Create a new file");
		System.out.println("\t\t3. Delete a file");
		System.out.println("\t\t4. Search a file");
		System.out.println("\t\t5. Exit");
	}
	
	// to get all files in the directory
	
	public static void getAllFiles() 
	{
		try {
			File folder=new File(projectFilespath);
		
			//to retrieve an array of  file objects from directory
			File[] listofFiles=folder.listFiles();
		
			if(listofFiles.length==0)
				System.out.println("No files exists in the directory");
			else 
			{
				for(File l:listofFiles )
				{
					System.out.println(l.getName());
				}
			}
		} 
		catch(Exception Ex)
		{
			System.out.println("Some error occured");
		}
	}
	
	
	// creating a file in the directory
	
	public static void createFiles() {
		try
		{
			Scanner obj=new Scanner(System.in);
			String fileName;
		
			
			System.out.println("Enter the file name to be created" );
			fileName=obj.nextLine();
			
			
			//checks if file already exists
			File file=new File(projectFilespath + "\\" + fileName);
			
			if(file.exists())
			{
				System.out.println("File already exists: " + fileName);
			}
			else
			{
				int linesCount;
				System.out.println("Enter how many lines in the file");
				linesCount=Integer.parseInt(obj.nextLine());
				
				FileWriter myWriter = new FileWriter(projectFilespath + "\\" + fileName);
				
				for(int i=1; i<=linesCount; i++)
				{
					System.out.println("Enter the file lines:");
					myWriter.write(obj.nextLine()+"\n");
					
				}
				System.out.println("File created successfully");
				myWriter.close();
				
			}
		}
		catch(Exception Ex) {
			System.out.println("Some error occured");
		}
	}
	
	
	
	
	//deleting a file
	
	public static void deleteFiles() {
		
		
		try
		{
			String fileName;
			System.out.println("Enter the file name to be deleted");
			
			Scanner obj=new Scanner(System.in);
			fileName=obj.nextLine();
			
			File file=new File(projectFilespath + "\\" + fileName);
			
			if(file.exists())
			{
				file.delete();
				System.out.println("File deleted successfully: " + fileName);
			}
			else
			{
				System.out.println("File does not exists");
			}
		}
		catch(Exception Ex)
		{
			System.out.println("Some error occured");
		}
		
	}
	
	
	
	
	//searching for a file from directory
	
	public static void searchFiles()
	{
		
		
		try
		{
			String fileName;
			System.out.println("Enter the file name to be searched");
			Scanner obj=new Scanner(System.in);
			fileName=obj.nextLine();
			
			File folder=new File(projectFilespath);
			File[] listOfFiles=folder.listFiles();
			
			LinkedList<String> filenames= new LinkedList<String>();
			for(File l:listOfFiles) {
				filenames.add(l.getName());
			}
			
			if(filenames.contains(fileName))
				System.out.println("File is available");
			else
				System.out.println("File is not available");
			
		}
		catch(Exception Ex)
		{
			System.out.println("Some error occured");
		}
		
	}
	
	
	
}