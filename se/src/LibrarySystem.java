import java.util.*;
import java.util.LinkedList;
//This is the class library system that contains all the methods that will create the structure of the system,
// it has all the functionalities for the user to use the system easily.

public class LibrarySystem {
    private LinkedList<Book> booksList;
    private LinkedList<LibMember> membersList;
    private int booksListSize;
    private int membersListSize;
    //This is the default constructor  Without any parameters

    public LibrarySystem() {
        booksList = new LinkedList<Book>();
        membersList = new LinkedList<LibMember>();
        booksListSize = 0;
        membersListSize = 0;
    }

    //This method is used to add a book to the system, first it checks if the book already exists in the
    // system,if(searchBook(book.getAccessionNum()) != -1)//if already exists return false;
    //if doesn't exist then add it booksList.add(book); booksListSize++; return true;if it does not,
    // it adds the book to the system.
    public boolean addBook(Book book) {
        try{

            if (searchBook(book.getAccessionNum()) != -1)//if already exists
                return false;

            //if it doesn't exist then add it
            booksList.add(book);
            booksListSize++;
            return true;
        }
        catch (Exception e){
            System.out.println("Error :" + e);
        }
        return false;
    }
    //This method is used to delete a book from the system, checking if the object is not found it returns false,
    // otherwise returns true and deletes the book

    public boolean deleteBook(long accessionNumber) {
        if (searchBook(accessionNumber) == -1)// if the book doesn't exist return false
            return false;

        Iterator<LibMember> iter = membersList.listIterator();

        while (iter.hasNext()) {
            LibMember lm = iter.next();
            Book[] bookIssued = lm.getBooksIssued();
            for (int i = 0; i < lm.getNumBooksIssued(); i++) {
                if (bookIssued[i].getAccessionNum() == accessionNumber)
                    return false; //if book is issued to a member then return false
            }
        }

        //delete it if it exist and not issued to any member
        booksList.remove(searchBook(accessionNumber));
        booksListSize--;
        return true;
    }

    //This method is used to add a new member to the system.
    public boolean addMember(LibMember lbMem) {
        long cpr = lbMem.getCprNum();

        if (searchMember(cpr) != -1)//if already exists
            return false;

        //if doesnt exist then add it
        membersList.add(lbMem);
        membersListSize++;
        return true;
    }

    //This method is used to delete an existing member from the system.
    public boolean deleteMember(long cpr) {
        int index = searchMember(cpr);//search for the member in the list

        if (index != -1)//if found then...
        {
            LibMember member1 = membersList.get(index);

            //and if the member does not have any book issued to him delete member and return true
            if (member1.getNumBooksIssued() == 0) {
                membersList.remove(index);
                membersListSize--;
                return true;
            }
        }
        return false;//if not then return false
    }

    //This method searched if a book exists in bookList and returns the location in bookList, else it returns -1
    public int searchBook(long aNum) {
        //if the booksList is empty
        if (booksList.isEmpty())
            return -1;

        //initialize an iterator to search through all elements
        Iterator<Book> iter = booksList.iterator();
        int index = 0;

        while (iter.hasNext()) {
            Book b1 = iter.next();
            if (b1.getAccessionNum() == aNum)
                return index; //the location of the book
            index++;
        }

        return -1; //if book does not exist

    }

    //This method searches for an existing member using the CPR, and returns true if it exists, otherwise returns -1
    public int searchMember(long cpr) {
        //if membersList is empty
        if (membersList.isEmpty())
            return -1;

        //initialize an iterator to search through all elements
        Iterator<LibMember> iter = membersList.iterator();
        int index = 0;

        while (iter.hasNext()) {
            LibMember member = iter.next();
            if (member.getCprNum() == cpr)
                return index;//the location of the book
            index++;
        }

        return -1; //if member does not exist

    }
    //This method checks if bookList is empty or not.

    public boolean isEmptyBookList() {
        return (booksListSize == 0);
    }

    //This method checks if membersList is empty or not.
    public boolean isEmptyMemberList() {
        return (membersListSize == 0);
    }

    //This methods returns the size of booksList
    public int sizeBooksList() {
        return booksListSize;
    }
    //This methods returns the size of membersList

    public int sizeMembersList() {
        return membersListSize;
    }


    //This method accepts accession number and cpr as parameters,
    // the method checks three conditions to issue the book to a member, if the book exists in the bookList,
    // if the book is not issued to any other member, the member has less than 10 books issued,
    // and then issues the book to the member.
    public boolean issueBook(long aNum, long cpr) {
        int bookInd = searchBook(aNum);
        int memberInd = searchMember(cpr);

        if (searchBook(aNum) == -1)//if the book does not exist in booksList return false
            return false;

        if (searchMember(cpr) == -1)//if the member does not exist in membersList return false
            return false;

        if (isBookIssued(aNum))//if the book is issued to any member return false
            return false;

        LibMember lbMem = membersList.get(memberInd);
        if (lbMem.getNumBooksIssued() >= 10)//if number of books issued to the member 10 or more return false
            return false;

        //if all conditions passed then the book can be issued to the member...
        LibMember member1 = membersList.get(memberInd);
        Book b1 = booksList.get(bookInd);
        Book[] booksIssued = member1.getBooksIssued();
        booksIssued[member1.getNumBooksIssued()] = b1;
        member1.setBooksIssued(booksIssued);
        member1.setNumBooksIssued(member1.getNumBooksIssued() + 1);
        b1.setIssuedTo(member1);
        return true;
    }
    //This method is to return a book to the system, only if the book exists in the bookList, and it is issued to a member.

    public boolean returnBook(long aNum) {

        int bookInd = searchBook(aNum);
        if (bookInd == -1)
            return false;


        if (!isBookIssued(aNum))
            return false;

        //if the book can be returned

        Book b1 = booksList.get(bookInd);
        LibMember member = b1.getIssuedTo();
        Book[] booksIssued = member.getBooksIssued();
        int bIssuedSize = member.getNumBooksIssued();
        int removeIndex = 0;
        for (int i = 0; i < member.getNumBooksIssued(); i++) {
            if (booksIssued[i].equals(booksList.get(bookInd))) {
                //shifting and removing
                for (int j = removeIndex; j < bIssuedSize - 1; j++)
                    booksIssued[j] = booksIssued[j + 1];
                member.setNumBooksIssued(member.getNumBooksIssued() - 1);
                member.setBooksIssued(booksIssued);
                b1.setIssuedTo(null);
                return true;

            }
            removeIndex++;
        }
        return false;
    }
    //This method is to print all the details of all the books issued to the specific member.

    public void printBooksIssued(long cpr) {
        int memberInd = searchMember(cpr);
        //check if the member exists then prints details of the books issued to them
        if (memberInd != -1) {
            LibMember member1 = membersList.get(memberInd);
            Book[] books = member1.getBooksIssued();
            int booksNum = member1.getNumBooksIssued();

            for (int i = 0; i < booksNum; i++) {
                Book b1 = books[i];
                System.out.println(b1.toString());
            }
        } else
            System.out.println("Member does not exist.");
    }

    //This method is to check if the book exists in the bookList and is issued to a member, or else it returns false.
    public boolean isBookIssued(long aNum) {
        int bookInd = searchBook(aNum);
        if (bookInd == -1)
            return false; //if it does not exist in the list return false

        //if issued to a member then return true
        Book b1 = booksList.get(bookInd);
        if (b1.getIssuedTo() != null)
            return true;
        return false;
    }

}
