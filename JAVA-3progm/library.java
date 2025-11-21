import java.util.Scanner;


class Books{
    String name;
    String author;
    int price;
    int numPages;

    Books(String name, String author, int price, int numPages){
        this.name=name;
        this.author=author;
        this.price=price;
        this.numPages=numPages;
    }
   
    public String getName(){
        return this.name;
    }
    
    public String getAuthor(){
        return this.author;
    }
    public int getNumPages(){
        return this.numPages;
    }

    public void setName(String nameString){
        this.name=nameString;
    }

    public void setAuthor(String authorString){
        this.author=authorString;
    }

    public void setPrice(int price){
        this.price=price;
    }
    
    public void setNumPages(int numPagesInt){
        this.numPages=numPagesInt;
    }

    @Override
     public String toString() {
        String details = "Book name: " + this.name + "\n" +
                         "Author name: " + this.author + "\n" +
                         "Price: " + this.price + "\n" +
                         "Number of pages: " + this.numPages + "\n";
        return details;
    }
}
public class library {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int n=s.nextInt();
        s.nextLine(); 
       
        Books[] b=new Books[n];

        for(int i=0; i<n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
                
            System.out.print("Enter name: ");
            String name=s.nextLine();

            System.out.print("Enter author: ");
            String author = s.nextLine();

            System.out.print("Enter price: ");
            int price=s.nextInt();

            System.out.print("Enter number of pages: ");
            int numPages=s.nextInt();
            s.nextLine();

            b[i] = new Books(name,author,price,numPages);
        }
        System.out.println("Book Details:");
        
        for(int i=0;i<n;i++){
            System.out.println("Book "+(i+1));
            System.out.println(b[i]);
        }
    }
}