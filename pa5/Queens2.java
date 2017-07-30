public class Queens2
{
    public static void main(String[] args)
    {
        int num = 0;
        long factorial;
        int[] A;
        int count = 0;
        String verbosity = "-v";
        
        if (args.length == 0)
        {
            printUsage();
            System.exit(0);
        }
        else if (args.length == 1)
        {
            try
            {
                num = Integer.parseInt(args[0]);
            }
            catch(Exception e)
            {
                printUsage();
                System.exit(0);
            }
            
            A = new int[num + 1];
            for (int i = 0; i < A.length; i++)
            {
                A[i] = i;
            }
            
            factorial = fact(num);
            for (int i = 0; i <= factorial; i++)
            {
                nextPermutation(A);
                if (isSolution(A))
                {
                    count++;
                }
            }
            System.out.println(num + "-Queens has " + count + " solutions");
        }
        else if (args.length == 2 && verbosity.equals(args[0]))
        {
            try
            {
                num = Integer.parseInt(args[1]);
            }
            catch(Exception e)
            {
                printUsage();
                System.exit(0);
            }
            
            A = new int[num + 1];
            for (int i = 0; i < A.length; i++)
            {
                A[i] = i;
            }
            
            factorial = fact(num);
            for (int i = 0; i <= factorial; i++)
            {
                nextPermutation(A);
                if (isSolution(A))
                {
                    printSolutions(A);
                    count++;
                }
            }
            System.out.println(num + "-Queens has " + count + " solutions");
 
        }
    }

    // nexPermutation(int[] A)
    // checks all the permutations of Rooks
    public static void nextPermutation(int[] A)
    {
        int pivot = 0;
        int successor = 0;
        int n = A.length - 1;
        
        // loop through array
        for (int i = n - 1; i > 0; i--)
        {
            // if current element is less than right hand neighbor
            // assign pivot to index of current element
            if (A[i] < A[i + 1])
            {
                pivot = i;
                break;
            }
        }
        
        // if pivot was not found, reverse array
        if (pivot == 0)
        {
            reverse(A, 1, A.length - 1);
            return;
        }
        
        // scan the array from left to right again
        // this time stoping at pivot
        for (int j = n; j > pivot; j--)
        {
            // if current element is larger than pivot
            // assign successor to index of current element
            if (A[j] > A[pivot])
            {
                successor = j;
                break;
            }
        }
        
        swap(A, pivot, successor);
        reverse(A, pivot + 1, A.length - 1);
        return;
    }
    
    // isSolution()
    // checks if there are Queens in any diagonals
    // if there are no Queens in diagonals, it
    // is a solution to NQueens
    public static boolean isSolution(int[] A)
    {
        for (int r = 2; r < A.length; r++)
        {
            for (int c = 1; c < r; c++)
            {
                if ((A[r] - A[c]) == (r - c))
                {
                    return false;
                }
                else if ((A[c] - A[r]) == (r - c))
                {
                    return false;
                }
            }
        }
        return true;
    }

    // swap(int[]A, int i, int j)
    // swaps the contents
    public static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // reverse(int[] A, int i, int j)
    // reverses array
    public static void reverse(int[] A, int i, int j)
    {
        while (i < j)
        {
            swap(A, i, j);
            i++;
            j--;
        }
    }

    // printSolutions(int[] A
    // printts the solutions
    public static void printSolutions(int[] A)
    {
        System.out.print("(");
        for (int i = 1; i < A.length; i++)
        {
            System.out.print(A[i]);
            if (i != A.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.print(")\n");
    }

    // fact(long n)
    // finds factorials to aid in finding permutations
    public static long fact(long n)
    {
        if (n <= 1)
        {
            return 1;
        }
        else
        {
            return n * fact(n - 1);
        }
    }
    
    // printUsage()
    // prints usage whenever there is an error
    public static void printUsage()
    {
        System.out.println("Usage: Queens [-v] number");
        System.out.println("Option: -v verbose output, print all solutions");
    }
}
