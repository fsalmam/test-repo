import java.util.*;
public class LibMember
{
    //data
    public String firstName;
    public String lastName;
    public char gender;
    public long cprNum;
    public String teleNum;
    public Book[] booksIssued;
    public int numBooksIssued;

    //Default constructor (without any parameters)
    public LibMember()
    {
        firstName = " ";
        lastName = " ";
        gender = ' ';
        cprNum = 0;
        teleNum = " ";
        booksIssued = new Book[10];
        numBooksIssued = 0;
    }

    //constructor with 5 parameters
    public LibMember(String fn, String ln, char g, long cpr, String tn)
    {

        firstName = fn;
        lastName = ln;
        gender = g;
        cprNum = cpr;
        teleNum = tn;
        booksIssued = new Book[10];
        numBooksIssued = 0;
    }

    //set and get methods for all attributes
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    public char getGender()
    {
        return gender;
    }

    public void setCprNum(long cprNum)
    {
        this.cprNum = cprNum;
    }

    public long getCprNum()
    {
        return cprNum;
    }

    public void setTeleNum(String teleNum)
    {
        this.teleNum = teleNum;
    }

    public String getTeleNum()
    {
        return teleNum;
    }

    public void setBooksIssued(Book[] booksIssued)
    {
        this.booksIssued = booksIssued;
    }

    public Book[] getBooksIssued()
    {
        return booksIssued;
    }

    public void setNumBooksIssued(int numBooksIssued)
    {
        this.numBooksIssued = numBooksIssued;
    }

    public int getNumBooksIssued()
    {
        return numBooksIssued;
    }

    //equals method
    public boolean equals(LibMember libMember)
    {

        if (libMember == null) return false;

        if(     gender == libMember.gender &&
                cprNum == libMember.cprNum &&
                numBooksIssued == libMember.numBooksIssued &&
                Objects.equals(firstName, libMember.firstName) &&
                Objects.equals(lastName, libMember.lastName) &&
                Objects.equals(teleNum, libMember.teleNum))
            return true;
        else
            return false;
    }

    //toString method
    public String toString()
    {
        return "\nLibMember :" +
                "\n firstName: " + firstName +
                "\n lastName: " + lastName +
                "\n gender: " + gender +
                "\n cprNum: " + cprNum +
                "\n teleNum: " + teleNum +
                "\n booksIssued: " + Arrays.toString(booksIssued) +
                "\n numBooksIssued: " + numBooksIssued +
                " }\n";
    }
}