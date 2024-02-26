import java.util.*;
public class LibraryMain
{
    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);
        int chooseNumber=0;

        LibrarySystem libaray=new LibrarySystem();

        //create books

        //public Book(String title, String author1, String author2, String publisher,
        //int yearPublication, String isbn, long accessionNum)
        Book obj1 =new Book("Islands","Ackerley","Acton","Adamaris",1991,"1234100000000",1001);
        Book obj2 =new Book("Sea","Aaliyah","Sabina","Sachi",1992,"1234100000001",1002);
        Book obj3 =new Book("Explore","Marley","Peyton","Presley",1993,"1234100000002",1003);
        Book obj4 =new Book("Forest","Tobin","Shaw","Oscar",1994,"1234100000003",1004);
        Book obj5 =new Book("Animal","Winston","Oberon","Sawyer",1995,"1234100000004",1005);
        Book obj6 =new Book("Trust","Oberon","Kinsley","Lily",1996,"1234100000005",1006);
        Book obj7 =new Book("What","Juliet","Birch","Garrison",1997,"1234100000006",1007);

        //add books
        libaray.addBook(obj1);
        libaray.addBook(obj2);
        libaray.addBook(obj3);
        libaray.addBook(obj4);
        libaray.addBook(obj5);
        libaray.addBook(obj6);
        libaray.addBook(obj7);


        //public LibMember(String fn, String ln, char g, long cpr, String tn)
        LibMember obje1 =new LibMember("Carter","William",'M',10176535,"34567281");
        LibMember obje2 =new LibMember("Olive","Henry",'F',10176534,"34567282");
        LibMember obje3 =new LibMember("Miles","Charles",'F',1076533,"34567283");
        LibMember obje4 =new LibMember("Oscar","George",'M',1076532,"34567284");
        LibMember obje5 =new LibMember("Juliet","Louis",'M',1076531,"34567285");
        LibMember obje6 =new LibMember("Georgia","Leo",'F',1076530,"34567286");
        LibMember obje7 =new LibMember("Emmett","Alfie",'M',1076500,"34567287");

        //add members
        libaray.addMember(obje1);
        libaray.addMember(obje2);
        libaray.addMember(obje3);
        libaray.addMember(obje4);
        libaray.addMember(obje5);
        libaray.addMember(obje6);
        libaray.addMember(obje7);

        System.out.println(
                "\n\t------------------------------------------------" +
                        "\n\t           Libaray Management System \t\n" +
                        "\t-------------------------------------------------");
        do{

            System.out.println(
                    "=================================================\n"+
                            "1- Books.\n2- Member.\n3- Issue Book. \n4- Return Book.\n0- Exit!\n"+
                            "================================================="
            );
            System.out.println("Enter number from 0-4:");
            chooseNumber=read.nextInt();

            long accessionNum=0,cpr=0;
            Book book;
            LibMember member;
            String title=" ",author1=" ",author2=" ",publisher=" ",isbn=" ",
                    firstName=" ",lastName=" ",teleNum=" ",answer=" ";
            int yearPublication=0;
            char gender;


            switch (chooseNumber){
                case 1:
                    do {
                        System.out.println(
                                "=================================================\n" +
                                        "1- Add Book.\n2- Delete Book.\n3- Search Book." +
                                        "\n4- Number of Books in List." +
                                        "\n5- Is Books List Empty?"+
                                        "\n6- Is this book issued?"+
                                        "\n7- Return to main menu." +
                                        "\n0- Exit!\n" +
                                        "================================================="
                        );
                        System.out.println("Enter number from 0-7:");
                        chooseNumber = read.nextInt();
                        switch (chooseNumber) {
                            case 1://Add Book
                                do{
                                    System.out.println("Enter title:");
                                    title = read.next();
                                    System.out.println("Enter first author:");
                                    author1 = read.next();
                                    System.out.println("Enter second author:");
                                    author2 = read.next();
                                    System.out.println("Enter publisher:");
                                    publisher = read.next();
                                    System.out.println("Enter year Publication:");
                                    yearPublication = read.nextInt();
                                    System.out.println("Enter ISBN");
                                    isbn = read.next();
                                    System.out.println("Enter accession number:");
                                    accessionNum = read.nextLong();
                                    book = new Book(
                                            title, author1, author2, publisher,
                                            yearPublication,isbn, (int) accessionNum);
                                    if (libaray.addBook(book)) {
                                        System.out.println("The book successfully added.");
                                    } else
                                        System.out.println("The book can't be added.");
                                    System.out.println("\nEnter \"Y\" to add  a book or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 2://Delete Book
                                do{
                                    System.out.println("Enter long Accession Number for book.");
                                    accessionNum = read.nextLong();
                                    if (libaray.deleteBook(accessionNum))
                                        System.out.println("The book successfully deleted.");

                                    else
                                        System.out.println("The book can't be delete.");
                                    System.out.println("\nEnter \"Y\" to Delete  a Book or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 3://Search Book
                                do{
                                    System.out.println("Enter long Accession Number for book.");
                                    accessionNum = read.nextLong();

                                    if (libaray.searchBook(accessionNum)!=-1)
                                        System.out.println("The book available in list.");

                                    else
                                        System.out.println("The book can't be found.");
                                    System.out.println("\nEnter \"Y\" to Search Book or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 4://Number of Books in List
                                do{
                                    System.out.printf("%d available book in list.\n",
                                            libaray.sizeBooksList());
                                    System.out.println("\nEnter \"Y\" to check Number of Books in List or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 5://Is Books List Empty?
                                do{
                                    if(libaray.isEmptyBookList())
                                        System.out.println("No book available in books list.");

                                    else
                                        System.out.println("The list is not empty.");
                                    System.out.println("\nEnter \"Y\" to check Is Books List Empty? or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;

                            case 6://Is this book issued?
                                do{
                                    System.out.println("Enter long Accession Number for book.");
                                    accessionNum = read.nextLong();
                                    if (libaray.isBookIssued(accessionNum))
                                        System.out.println("The book is issued!!");

                                    else
                                        System.out.println("The book is not issued!!");
                                    System.out.println("\nEnter \"Y\" to check Is this book issued? or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 0:
                                System.exit(1);
                                break;
                        }//switch

                    }while(chooseNumber !=7);
//////////////////////////////////////////////end of book menu/////////////////////////////////////////
                    break;
////////////////////////////////////////////////member menu//////////////////////////////////////
                case 2:
                    do {
                        System.out.println(
                                "=================================================\n" +
                                        "1- Add Member.\n2- Delete Member." +
                                        "\n3- Search Member." +
                                        "\n4- Number of Member in List." +
                                        "\n5- Is Member List Empty?" +
                                        "\n6- Print Books Issued for member"+
                                        "\n7- Return to main menu." +
                                        "\n0- Exit!\n" +
                                        "================================================="
                        );
                        System.out.println("Enter number from 0-7:");
                        chooseNumber = read.nextInt();
                        switch(chooseNumber){
                            case 1://Add Member
                                do{
                                    //public LibMember(
                                    // String firstName, String lastName, String teleNum,
                                    //                     char gender, long cprNum)

                                    System.out.println("Enter firstName, lastName," +
                                            "telephone number, gender and cpr:");
                                    firstName=read.next();
                                    lastName=read.next();
                                    teleNum=read.next();
                                    gender=read.next().charAt(0);
                                    cpr=read.nextLong();
                                    member=new LibMember(firstName,lastName,gender,cpr,teleNum);
                                    if (libaray.addMember(member)) {
                                        System.out.println("The member successfully added.");
                                    } else
                                        System.out.println("The member can't be added.");
                                    System.out.println("\nEnter \"Y\" to add Member or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 2://Delete Member
                                do{
                                    System.out.println("Enter member cpr Number:");
                                    cpr = read.nextLong();
                                    if (libaray.deleteMember(cpr))
                                        System.out.printf("The member cpr %d successfully deleted.\n",cpr);

                                    else
                                        System.out.printf("The member cpr %d can't be delete.\n",cpr);
                                    System.out.println("\nEnter \"Y\" to Delete Member or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 3://Search Member.
                                do{
                                    System.out.println("Enter member cpr Number:");
                                    cpr = read.nextLong();
                                    if (libaray.searchMember(cpr)!=-1)
                                        System.out.printf("The member cpr %d available in list.\n",cpr);

                                    else
                                        System.out.printf("The member cpr %d not available in list.\n",cpr);
                                    System.out.println("\nEnter \"Y\" to search for Member or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 4:// Member List size
                                do{
                                    System.out.printf("%d available member in list.\n",
                                            libaray.sizeMembersList() );
                                    System.out.println("\nEnter \"Y\" to recheck Member List number or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;

                            case 5://Is Member List Empty?
                                do{
                                    if(libaray.isEmptyMemberList())
                                        System.out.println("No member available in list.");

                                    else
                                        System.out.println("The list not member empty.");
                                    System.out.println("\nEnter \"Y\" to recheck member list empty or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;

                            case 6://Print Books Issued for member
                                do{
                                    System.out.println("Enter member cpr Number:");
                                    cpr = read.nextLong();
                                    libaray.printBooksIssued(cpr);
                                    System.out.println("\nEnter \"Y\" to reprint member book details or " +
                                            "\"N\" to stop...... ");
                                    answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));

                                break;

                            case 0:
                                System.exit(1);
                                break;

                        }//switch
                    }while (chooseNumber != 7);
                    break;
///////////////////////////////////////////////end of member meun//////////////////////////////////
                case 3://Issue Book
                    System.out.println("Enter long Accession Number for book.");
                    accessionNum=read.nextLong();
                    System.out.println("Enter CPR Number of the member.");
                    cpr=read.nextLong();
                    if((libaray.issueBook(accessionNum,cpr))){
                        System.out.println("The book successfully issued.");
                    }
                    else
                        System.out.printf(
                                "\n\"The book Accession Number %d & CPR %d not issued\"\n"
                                ,accessionNum,cpr);
                    System.out.println("\nEnter any thing to continue & press enter...... ");
                    read.next();
                    break;
                case 4://Return Book
                    System.out.println("Enter long Accession Number for book.");
                    accessionNum=read.nextLong();

                    if(libaray.returnBook(accessionNum)){
                        System.out.println("The book successfully returned.");
                    }
                    else
                        System.out.printf(
                                "\n\"The book Accession Number %d can't be return\"\n"
                                ,accessionNum);
                    System.out.println("\nEnter any thing to continue & press enter...... ");
                    read.next();
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("invited number please, try again!");
            }
            /*
            "1- Add Book.\n2- Delete Book.\n3- Search Book.\n4- sizeBooksList" +
            "5- Is Empty Books List?\n6- Add Member.\n7- Delete Member\n" +
            "8- Size Members List.\n 9- Is Empty Members List.\n10- Issue Book\n" +
                    "11- Return Book.\n 12-printBooksIssued. 0- Exit!"
             */
        }while(true);




    }//main
}//class