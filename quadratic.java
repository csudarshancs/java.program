import java.util.Scanner;

class quadratic
{
    public static void main (String args[])
    {
        int a,b,c,d;
        Scanner in =new Scanner(System.in);
        System.out.println("enter co-efficient of of A:");
        a=in.nextInt();

        System.out.println("enter co-efficient of of B:");
        b=in.nextInt();

        System.out.println("enter co-efficient of of C:");
        c=in.nextInt();

        if( a==0){
            System.out.println("Not a quadratic equation");
        }

        else{
            d=b*b-4*a*c;
            if (d==0){
                int r1;
                r1=(-b)/(2*a);
                System.out.println("Roots are real and equal");
                System.out.println("Root1 and Root2");
            }
            else if (d>0) {
            double r1,r2;
                r1 = ((-b) + (Math.sqrt(d)))/(double)(2*a);
                r2 = ((-b) - (Math.sqrt(d)))/(double)(2*a);
                System.out.println(r1);
                System.out.println(r2);
                
            }

            else if(d<0){
                System.out.println("Roots are imaginary");
                double r1,r2;
                r1 = (-b)/(2*a);
                r2 = Math.sqrt(-d)/(2*a);
                System.out.println(r1);
                System.out.println(r2);

            }

            }
        }

    }