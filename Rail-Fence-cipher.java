public class railfence{
    public static void main(String args[]){
        int []record= new int[4];
        int i=0,j=0,k=0,outer=2;
        for(outer=2;outer<36;++outer) {
            String note = "AVUEVLETSEISBNACBOOLEOBTILBDLCOBOOE";
            int row = outer, total = 35;


            record = split(total, row);                  //split and record
            int[] numofeachrow = NumOfEachRow(total, row);  //find number of elements in each row

            int positionnumber = (total+record[1]* record[2]) ;

            int[][] Position = new int[row][positionnumber];

            String[] note2 = new String[row];

            for (i = 0; i < row; ++i)
                note2[i] = "";
            for (i = 0; i < row; ++i) {
                for (j = 0; j < numofeachrow[i]; ++j) {
                    note2[i] = note2[i] + note.charAt(k);
                    ++k;
                }

            }


            Position = handler(total, row);
            Position = handleremainder(Position, total, row);

            k = 0;

            for (i = 0; i < row; ++i) {
                System.out.println();
                for (j = 0; j < positionnumber; ++j) {
                    if (Position[i][j] == 1) {
                        System.out.print(note2[i].charAt(k));
                        ++k;
                    } else System.out.print("_");
                }

                k = 0;
            }
            System.out.println("\n" +
                    "");
        }
    }
    public static int[][] handleremainder(int [][]Position,int total, int row) {
        int i = 0, j = 0, k = 0;
        int []xy={0,0};
        int[] record = split(total, row);
        int space = record[1] * record[2];
        int[][] Position2 = Position;
        int remainder = record[3];
        if(record[1]==0) return Position;
        for(i=0;i<remainder;++i){
            Position2[xy[1]][xy[0]+space]=1;
            xy=iterator2(xy,total, row);
        }
        return Position2;
    }
    public static int []iterator2  (int []lastxy, int total, int row){
        int i=0, j=0, k=0;
        int []xy= {0,0};
        int []record= split(total,row);
        if(lastxy[1]<row-1 && lastxy[0]<row-1) {
            xy[1] = lastxy[1] + 1;
            xy[0] = lastxy[0] + 1;
        }
        else if(lastxy[0]>=row-1){
            xy[1] = lastxy[1] - 1;
            xy[0] = lastxy[0] + 1;
        }
        return xy;
    }

    public static int [][] handler (int total, int row) {
        int i = 0, j = 0, k = 0;
        int[] xy = {0, 0};
        int record[] = split(total, row);
        int positionnumber = (total+record[1]* record[2]) ;
        int[][] r = new int[row][positionnumber];
        if(record[1]==0
        ){
            xy[0] = 0;
            xy[1] = 0;
            for (j = 0; j < record[3]; ++j) {
                if (j == 0) {
                    r[0][0] = 1;
                } else {
                    xy = iterator2(xy, total, row);
                    r[xy[1]][xy[0]] = 1;
                }
            }
        }
        for (i = 0; i < record[1]; ++i) {
            xy[0] = 0;
            xy[1] = 0;
            for (j = 0; j < record[2]; ++j) {
                if (j == 0) {
                    r[0][0+i*record[2]] = 1;
                } else {
                    xy = iterator2(xy, total, row);
                    r[xy[1]][xy[0]+i*record[2]] = 1;
                }
            }
        }
        return r;
    }



    public static int []split  (int total, int row ){
        int r[]= new  int[4];
        int g= 2*row-2;
        r[0]=total;   //total number
        r[1]=total/g; //number of group
        r[2]=g;       //number of elements in a group
        r[3]=total-( total/g )*g;//the remainder
        return r;
    }

    public static int[] findpad(int total, int row){
        int []rowtopad =new int[row];
        int i=0,j=0,k=0;
        int []record= split(total,row);
        int pad=0;

        for(i=0;i<row;++i)
            rowtopad[i]=0;

        if(record[3]<=row && record[3]>0) {
            for (i = 0; i < record[3]; ++i)
                rowtopad[i] = 1;
        }
        else if(record[3]>row){
            pad=record[3]-row;
            for (i = 0; i < row; ++i)
                rowtopad[i] = 1;
            for(i=0;i<pad;++i)
                rowtopad[row-i-2]=rowtopad[row-i-2]+1;
        }
        return rowtopad;
    }

    public static int[] NumOfEachRow(int total, int row){
        int []rowtopad    =findpad(total,row);
        int []numofeachrow= new int [row];
        int []record=split(total,row);
        int i=0,j=0;
        /*
        r[0]=total;   //total number
        r[1]=total/g; //number of group
        r[2]=g;       //number of elements in a group
        r[3]=total -(total/g )*g;//the remainder
         */
        numofeachrow[0]=record[1]+rowtopad[0];
        for(i=1;i<row-1;++i)
            numofeachrow[i]=2*record[1]+rowtopad[i];
        numofeachrow[row-1]=record[1]+rowtopad[row-1];

        return numofeachrow;
    }
}
