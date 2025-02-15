public class twodarray {
    public static void main(String[] args) {
        
        char[][] telephone = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'},
            {'*', '0', '#'}
        };

        for(char[] row : telephone) {
            for(char nums : row) {
                System.out.print(nums + " ");
            }
            System.out.println();
        }
        
    }
}