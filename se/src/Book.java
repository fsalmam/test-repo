import java.util.*;
public class Book
{
    //data
    public String title, author1, author2, publisher,isbn;
    public int yearPublication;
    public long accessionNum=1001;
    public LibMember issuedTo;

    //Default constructor (without any parameters)
    public Book()
    {
        title="Unknown";
        author1="Unknown";
        author2="Unknown";
        publisher="Unknown";
        isbn="Unknown";
        yearPublication=0000;
        accessionNum=1001;
        issuedTo= null;
    }

    //constructor with 6 parameters
    public Book(String title, String author1, String author2, String publisher, int yearPublication, String isbn,
                long accessionNum)
    {
        if(isbn.length()==13)
            this.isbn = isbn;
        else
        {
            System.out.println("ISBN must be 13 digit");
            return;
        }
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.publisher = publisher;
        this.yearPublication = yearPublication;
        if(accessionNum<1001)
            accessionNum=1001;
        else
            this.accessionNum = accessionNum;
    }

    //set and get methods for all attributes
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getAuthor1()
    {
        return author1;
    }
    public void setAuthor1(String author1)
    {
        this.author1 = author1;
    }
    public String getAuthor2()
    {
        return author2;
    }
    public void setAuthor2(String author2)
    {
        this.author2 = author2;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    public int getYearPublication()
    {
        return yearPublication;
    }
    public void setYearPublication(int yearPublication)
    {
        this.yearPublication = yearPublication;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public void setIsbn(String isbn)
    {
        if(isbn.length()==13)
            this.isbn = isbn;
        else
        {
            System.out.println("ISBN not 13 light");
            return;
        }
    }
    public long getAccessionNum()
    {
        return accessionNum;
    }
    public void setAccessionNum(long accessionNum)
    {
        if(accessionNum<1001)
            accessionNum=1001;
        else
            this.accessionNum = accessionNum;
    }
    public LibMember getIssuedTo()
    {
        return issuedTo;
    }
    public void setIssuedTo(LibMember issuedTo)
    {
        this.issuedTo = issuedTo;
    }

    //equals method
    public boolean equals(Book b1)
    {

        return   yearPublication == b1.yearPublication &&
                accessionNum == b1.accessionNum &&
                title.equals( b1.title) &&
                author1.equals( b1.author1) &&
                author2.equals( b1.author2) &&
                publisher.equals( b1.publisher) &&
                isbn.equals( b1.isbn) &&
                issuedTo.equals( b1.issuedTo);
    }


    //toString method
    public String toString()
    {
        return ("Book: \nTitle = " + title +
                "\nFirst Author =" + author1 + "\nSecond Author =" + author2
                + "\nPublisher =" + publisher
                + "\nYear of Publication=" + yearPublication + "\nISBN=" + isbn
                + "\nAccession Number=" + accessionNum + "\nIssued To=" + issuedTo.getCprNum());
    }

}//end of class Book