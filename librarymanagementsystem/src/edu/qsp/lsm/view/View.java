package edu.qsp.lsm.view;

import java.util.Scanner;

import edu.qsp.lsm.controller.Controller;
import edu.qsp.lsm.model.Book;
import edu.qsp.lsm.model.Library;

public class View {
	static Scanner myInput = new Scanner(System.in);
	static Library Library = new Library();
    static Controller controller = new  Controller();
	static {
		System.out.println("- - - - WELCOME TO LIBRARY MANAGEMENT SYSTEM- - - -");
		//
		System.out.println("Enter name of lirary : ");
		String libraryName = myInput.nextLine();
		Library.setLibraryAddress(libraryName);
		System.out.println("Enter address of library : ");
		String libraryAddress = myInput.nextLine();
		Library.setLibraryAddress(libraryAddress);
		System.out.println("Enter pincode : ");
		int libraryPincode = myInput.nextInt();
		Library.setPincode(libraryPincode);
		myInput.nextLine();
	}
	
	public static void main(String[] args) {
		do {
			System.out.println("Select operation to perform : ");
			System.out.println("1.Add book\n2.Remove book\n3.Update book\n4.Get book by name\n5.Get all books\n0.Exit");
			System.out.println("Enter digit respective to desired option : ");
			int userChoice = myInput.nextInt();
			myInput.nextLine();
			switch (userChoice) {
			case 0:
				myInput.close();
				System.out.println("- - - - - EXITED - - - - -");
				System.exit(0);
				break;
			case 1:
				Book book1 = new Book();
				System.out.println("Enter book name : ");
				book1.setBookName(myInput.nextLine());
				
				
				System.out.println("Enter book author : ");
				book1.setBookAuthor(myInput.nextLine());
				
				System.out.println("Enter book price : ");
				book1.setBookPrice(myInput.nextDouble());
				myInput.nextLine();
				
				System.out.println("Enter publication : ");
				book1.setPublication(myInput.nextLine());
				//
				controller.addBook(book1);
				break;
			case 2:
				System.out.println("Enter name of book to be removed : ");
				boolean verifyBookRemove = controller.removeBook(myInput.nextLine());
				if (verifyBookRemove) {
					System.out.println("Book removed");
				}
				else
				{
					System.out.println("Book does not exist in library");
				}
				
				break;
			case 3:
				Book book3 = new Book();
				System.out.println("Enter name of book to update : ");
				String bookToUpdate = myInput.nextLine();
				book3.setBookName(bookToUpdate);
				System.out.println("Enter new price : ");
				double newPrice = myInput.nextDouble();
				/////
				myInput.nextLine();
				book3.setBookPrice(newPrice);
				//
				if (controller.updateBookPriceByBookName(book3)) {
					System.out.println("Book price updated");
				}
				else
				{
					System.out.println("Book does not exist in library");
				}
				break;
			case 4:
				System.out.println("Enter book name : ");
				String bookToGet = myInput.nextLine();
				//
				Book book = controller.searchBook(bookToGet);
				//
				if (book != null) {
					System.out.println(book);
				}
				else
				{
					System.out.println("Book is not in library");
				}
				break;
			case 5:
				System.out.println(controller.getAllBooks());
				
				break;
			default:
				System.out.println("- - - - -INVALID SELECTION- - - - -");
				break;
			}
		} while (true);
	}
}

