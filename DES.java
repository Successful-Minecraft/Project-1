public class DES{

    public static short[] permu ( short []input,  short []table, int  outsize){
        int  i=0;
	short [] r= new short [outsize];
	for(i=0;i<outsize;++i)
	    r[i]=input[table[i]-1];
	return r;
    }
    public static short [] ts (String si){
	short note0[] = {0};
	if(si=="E")
	    {
		short note[]={32 ,	1 ,	2 ,	3 ,	4 ,	5 ,
		    4  ,        5 ,	6 ,	7 ,	8 ,	9 ,
		    8  ,        9 ,	10, 	11, 	12, 	13,
		    12 ,	13, 	14, 	15, 	16, 	17,
		    16 ,	17, 	18, 	19, 	20, 	21,
		    20 ,	21, 	22, 	23, 	24, 	25,
		    24 ,	25, 	26,	27, 	28, 	29,
		    28 ,	29, 	30, 	31, 	32, 	1 };
		return note;
	    }
	else if(si=="IP"){
	    short note[]={58 ,	50 ,	42 ,	34 , 	26 ,	18 , 	10 , 	2,
		    60 ,	52 ,	44 ,	36 ,	28 ,	20 ,	12 ,	4,
		    62 ,	54 ,	46 ,	38 ,	30 ,	22 ,	14 ,	6,
		    64 ,	56 ,	48 ,	40 ,	32 ,	24 ,	16 ,	8,
		    57 ,	49 ,	41 ,	33 ,	25 ,	17 ,	9  ,	1,
		    59 ,	51 ,	43 ,	35 ,	27 ,	19 ,	11 ,	3,
		    61 ,	53 ,	45 ,	37 ,	29 ,	21 ,	13 ,	5,
		    63 ,	55 ,	47 , 	39 ,	31 , 	23 ,	15 ,	7 };
	    return note;
	}
	else if(si=="IPR"){
	    short note[]={40, 	8 ,	48 ,	16 ,	56 ,	24 ,	64 ,	32,
		    39 ,	7 ,	47 ,	15 ,	55, 	23 ,	63 ,	31,
		    38 ,	6 ,	46 ,	14 ,	54 ,	22 ,	62 ,	30,
		    37 ,	5 ,	45 ,	13 ,	53 ,	21 ,	61 ,	29,
		    36 ,	4 ,	44 ,	12 ,	52 ,	20 ,	60 ,	28,
		    35 ,	3 ,	43 ,	11 ,	51 ,	19 ,	59 ,	27,
		    34 ,	2 ,	42 ,	10 ,	50 ,	18 ,	58 ,	26,
		    33 ,	1 ,	41 ,	9 ,	49 ,	17 ,	57 ,	25};
	    return note;
	}
	else if(si=="P"){
	    short note[]={16 ,	7 ,	20 ,	21 ,	29 ,	12 ,	28 ,	17,
		    1 ,	        15 ,	23 ,	26 ,	5 ,	18 ,	31 ,	10,
		    2 ,     	8 ,	24 ,	14 ,	32 ,	27 ,	3 ,	9,
		    19 ,	13 ,	30 ,	6 ,	22 ,	11 ,	4 ,	25 };
	    return note;
	}
	else if(si=="PC1l"){
	    short note[]={57 ,	49 ,	41 ,	33 ,	25 ,	17 ,	9 ,
		     1 ,	58 ,	50 ,	42 ,	34 ,	26 ,	18,
		     10, 	2  ,	59 ,	51 ,	43 ,	35 ,	27,
			19 ,	11 ,	3  ,	60 ,	52 ,	44 ,	36};
	    return note;
	}
	else if(si =="PC1r"){
	     short note[]={ 63 ,	55 , 	47 ,	39 ,	31 ,	23 ,	15,
			  7  ,	62 ,	54 ,	46 ,	38 ,	30 ,	22,
			  14 ,	6  ,	61 ,	53 ,	45 ,	37 ,	29,
			  21 ,	13 ,	5  ,	28 ,	20 ,	12 ,	4};
	    return note;
	}
	else if(si=="PC2"){
	    short note[]={14 ,	17 ,	11 ,	24, 	1  ,	5 ,
		    3  ,	28 ,	15 , 	6 ,	21 ,	10,
		    23 ,	19 ,	12 ,	4 ,	26 ,	8 ,
		    16 ,	7  ,	27 ,	20, 	13 ,	2 ,

		    41 ,	52 ,	31 ,	37, 	47 ,	55,
		    30 ,	40 ,	51 ,	45, 	33 ,	48,
		    44 ,	49 ,	39 ,	56, 	34 , 	53,
		    46 ,	42 ,	50 ,	36, 	29 ,	32 };
	    return note;
	}
	return note0;
    
    }
        
    public static short Sbox (int boxn,int  indexleft,int indexup){
        short note[]={14 ,	4  , 	13, 	1 ,	2 ,	15, 	11 ,	8  ,	3  ,	10 ,	6  ,	12, 	5 ,	9 ,	0, 	7,
		    0  ,        15 ,	7 ,     4 ,	14, 	2 ,	13 ,	1  ,	10 ,	6  ,	12 ,	11, 	9 ,	5 ,	3,	8,
		    4  ,        1  ,	14, 	8 ,	13, 	6 ,	2  ,	11 ,	15 ,	12 ,	9  ,	7 ,	3 ,	10, 	5, 	0,
		    15 ,	12 ,	8 , 	2 ,	4 ,	9 , 	1  ,	7  ,	5  ,	11 ,	3  ,	14, 	10, 	0 ,	6, 	13,

		    15 ,	1 ,	8  ,	14 ,	6 ,	11 ,	3   ,	4 ,	9 ,	7 ,	2 ,	13 ,	12, 	0 ,	5,	10,
		    3 ,	        13 ,	4 ,	7 ,	15 ,	2 ,	8 ,	14 ,	12 ,	0 ,	1 ,	10 ,	6 ,	9 ,	11,	5,
		    0 ,    	14 ,	7 ,	11 ,	10 ,	4 ,	13 ,	1 ,	5 ,	8 ,	12 ,	6 ,	9 ,	3 ,	2 ,	15,
		    13 ,	8 ,	10 ,	1 ,	3 ,	15 ,	4 ,	2 ,	11 ,	6 ,	7 ,	12 ,	0 ,	5 ,	14 ,	9,
		    
		    10 ,	0  ,	9 ,	14 ,	6 ,	3 ,	15 ,	5 ,	1 ,	13 ,	12 ,	7 ,	11 ,	4 ,	2 ,	8,
		    13 ,	7 ,	0 ,	9 ,	3 ,	4 ,	6 ,	10 ,	2 ,	8 ,	5 ,	14 ,	12 ,	11 ,	15 ,	1,
		    13 ,	6 ,	4 ,	9 ,	8 ,	15 ,	3 ,	0 ,	11 ,	1 ,	2 ,	12 ,	5 ,	10 ,	14 ,	7,
		    1 ,	        10 ,	13 ,	0 ,	6 ,	9 ,	8 ,	7 ,	4 ,	15 ,	14 ,	3 ,	11 ,	5 ,	2 ,	12,
		
		    7 ,	        13 ,	14 ,	3 ,	0 ,	6 ,	9 ,	10 ,	1 ,	2 ,	8 ,	5 ,	11 ,	12 ,	4 ,	15,
		    13 ,	8 ,	11 ,	5 ,	6 ,	15 ,	0 ,	3 ,	4 ,	7 ,	2 ,	12 ,	1 ,	10 ,	14 ,	9,
		    10 ,	6 ,	9 ,	0 ,	12 ,	11 ,	7 ,	13 ,	15 ,	1 ,	3 ,	14 ,	5 ,	2 ,	8 ,	4,
		    3 ,       	15 ,	0 ,	6 ,	10 ,	1 ,	13 ,	8 ,	9 ,	4 ,	5 ,	11 ,	12 ,	7 ,	2 ,	14,
		    
		    2 ,	        12 ,	4 ,	1 ,	7 ,	10 ,	11 ,	6 ,	8 ,	5 ,	3 ,	15 ,	13 ,	0 ,	14 ,	9,
		    14 ,	11 ,	2 ,	12 ,	4 ,	7 ,	13 ,	1 ,	5 ,	0 ,	15 ,	10 ,	3 ,	9 ,	8 ,	6,
		    4 ,	        2 ,	1 ,	11 ,	10 ,	13 ,	7 ,	8 ,	15 ,	9 ,	12 ,	5 ,	6 ,	3 ,	0 ,	14,
		    11 ,	8 ,	12 ,	7 ,	1 ,	14 ,	2 ,	13 ,	6 ,	15 ,	0 ,	9 ,	10 ,	4 ,	5 ,	3,
	       
		    12 ,	1 ,	10 ,	15 ,	9 ,	2 ,	6 ,	8 ,	0 ,	13 ,	3 ,	4 ,	14 ,	7 ,	5 ,	11,
		    10 ,	15 ,	4 ,	2 ,	7 ,	12 ,	9 ,	5 ,	6 ,	1 ,	13 ,	14 ,	0 ,	11 ,	3 ,	8,
		    9 ,   	14 ,	15 ,	5 ,	2 ,	8 ,	12 ,	3 ,	7 ,	0 ,	4 ,	10 ,	1 ,	13 ,	11 ,	6,
		    4 ,   	3 ,	2 ,	12 ,	9 ,	5 ,	15 ,	10 ,	11 ,	14 ,	1 ,	7 ,	6 ,	0 ,	8 ,	13,
		   
		    4 ,	        11 ,	2 ,	14 ,	15 ,	0 ,	8 ,	13 ,	3 ,	12 ,	9 ,	7 ,	5 ,	10 ,	6 ,	1,
		    13 ,	0 ,	11 ,	7 ,	4 ,	9 ,	1 ,	10 ,	14 ,	3 ,	5 ,	12 ,	2 ,	15 ,	8 ,	6,
		    1 ,   	4 ,	11 ,	13 ,	12 ,	3 ,	7 ,	14 ,	10 ,	15 ,	6 ,	8 ,	0 ,	5 ,	9 ,	2,
		    6 ,	        11 ,	13 ,	8 ,	1 ,	4 ,	10 ,	7 ,	9 ,	5 ,	0 ,	15 ,	14 ,	2 ,	3 ,	12,
		   
		    13 ,	2 ,	8 ,	4 ,	6 ,	15 ,	11 ,	1 ,	10 ,	9 ,	3 ,	14 ,	5 ,	0 ,	12 ,	7,
		    1 ,	        15 ,	13 ,	8 ,	10 ,	3 ,	7 ,	4 ,	12 ,	5 ,	6 ,	11 ,	0 ,	14 ,	9 ,	2,
		    7 ,	        11 ,	4 ,	1 ,	9 ,	12 ,	14 ,	2 ,	0 ,	6 ,	10 ,	13 ,	15 ,	3 ,	5 ,	8,
		    2 ,    	1 ,	14 ,	7, 	4 ,	10 ,	8 ,	13 ,	15 ,	12 ,	9 ,	0 ,	3 ,	5 ,	6 ,	11};
	return note[boxn*64+indexleft*16+indexup];
    }

    public static int Drop (int index){
        int note[]={1 ,  	2 ,	3 ,	4 ,	5 ,	6 ,	7 , 	
		    9 ,	        10, 	11, 	12, 	13, 	14, 	15, 	
		    17 ,	18, 	19, 	20, 	21, 	22, 	23,    
		    25 ,	26, 	27, 	28, 	29, 	30, 	31, 	
		    33 ,	34, 	35, 	36, 	37, 	38, 	39,     
		    49 ,	50, 	51, 	52, 	53, 	54, 	55, 	
		    57 ,	58, 	59, 	60, 	61, 	62, 	63};
	return note[index];
    }
    public static int Permutation (int index){
        int note[]={57 ,	49, 	41, 	33, 	25, 	17, 	9 ,	1 ,
		    58 ,	50, 	42,	34,	26, 	18, 	10, 	2 ,
		    59 ,	51, 	43, 	35, 	27, 	19, 	11, 	3 ,
		    60 ,	52, 	44, 	36, 	63, 	55, 	47, 	39,
		    31 ,	23, 	15, 	7 ,	62, 	54, 	46, 	38,
		    30 ,	22, 	14, 	6, 	61, 	53, 	45, 	37,
		    29 ,	21, 	13, 	5 ,	28, 	20, 	12, 	4 };
	return note[index];
    }
    public static int Compression (int index){
        int note[]={14 	, 17, 	11, 	24, 	01, 	05, 	03, 	28,
		    15 	, 06, 	21,	10, 	23, 	19, 	12, 	04,
		    26 	, 8, 	16, 	07, 	27, 	20, 	13, 	02,
		    41 	, 52, 	31, 	37, 	47, 	55, 	30, 	40,
		    51 	, 45, 	33, 	48, 	44, 	49, 	39, 	56,
		    34 	, 53, 	46, 	42, 	50, 	36, 	29, 	32 };
	return note[index];
    }

    public static int Bitrtable (int index){
        int note[]={ 	1 ,	1 ,	2, 	2, 	2, 	2, 	2, 	2, 	1, 	2, 	2, 	2, 	2, 	2, 	2, 	1 };
	return note[index];
    }

    //The methods begins at here: *************************//
    
    public static short [][]  split  (short [] input, int insize){
	int i=0;
	short [][]r= new short[2][insize/2];
	for(i=0;i<insize/2;++i){
	    r[0][i] = input[i];
	    r[1][i] = input[i+insize/2];
	}
	return r;
    }

    public static short []  merge  (short [] input1, short [] input2, int insize){
	int i  =  0;
	short  []  r = new short  [ insize*2 ];
	for(i=0;i<insize;++i){
	    r[i]=input1[i];
	    r[i+insize]=input2[i];
	}
	return r;

    }

			  
    public static short[] converter(int number){
	int i=0, a=0, number2=number, j=0,k=0;
	short retu[]={0,0,0,0,0,0,0,0};
        while(number2 > 0)
        {
            a = number2 % 2;
            number2 = number2 / 2;
	    //Fot test purpose:
	    //System.out.println("The 7-k value is "+(7-k)+" and the a is "+a+" and the number2 is: "+number2);
	    retu[7-k]=(short)a;   
	    ++k;
        }
	for(++k;k<8;++k)
	    retu[7-k]=0;
	return retu;
    }

    public static short[]  XOR (short [] s1,short []s2, int num){
	int i=0;
	short []sretu=new short[num];
	for(i=0;i<num;++i){
	    if(s1[i]==s2[i])    sretu[i]=0;
	    else                sretu[i]=1;
	}
	return sretu;
	    
    }
	
    public static short[] Feistel(short [] Hfblock, short [] Subkey){
	int i=0,j=0,k=0;
	short [] expand=new short[48], expandn= new short[48];
	////E:
        expand = (short[])permu(Hfblock,ts("E"),48);
	////
	expandn=XOR(expand, Subkey, 48);
	short []snote =new short[32];
	short []sretu =new short[32];
	////Xboxes:
       	for(j=0;j<8;++j){
	    for(k=0;k<4;++k){   
		snote[j*4+k] = converter(
					 
					 Sbox (j,  
					      (int)expandn[j*6]*2+expandn[j*6+5]  ,  
					      (int)expandn[j*6+1]*8+expandn[j*6+2]*4+expandn[j*6+3]*2+expandn[j*6+4]    
					      )
					 
					 )[k+4];
	    }
	}
	
	////P:
	sretu=permu(snote, ts("P"),32);
	////
	return sretu;
    }
    public static short[] shift(short []input, int enumb, int snum){
	short []sretu= new short[enumb];
	int i=0;
	for(i=0;i<enumb-snum;++i){
	    sretu[i]=input[i+snum];
	}
	for(i=0;i<snum;++i){
	    sretu[enumb-snum+i]=input[i];
	}
	return sretu;
    }

    public static short[][] keysche(short [] Key){

	short [][]leftright= new short[2][28];
	short []     total = new short[56] , PC1aft = new short[56];
	short []PC1        = new short[56];
	short [][]Subkey   = new short[16][48];
	int i=0,  j=0,  k=0;
	PC1 = merge(ts("PC1l"),ts("PC1r"),28);
	PC1aft = permu(Key, PC1, 56);
	leftright = split(PC1aft,56);
	for(j=0;j<16;++j){
	    leftright[0] =shift(leftright[0] , 28 , Bitrtable(j));
	    leftright[1] =shift(leftright[1] , 28 , Bitrtable(j));
	    total= merge(leftright[0],leftright[1],28);
	    Subkey[j] =  permu (total , ts("PC2"), 48);
	    
	}
	for(i=0;i<48;++i){
	    System.out.print(Subkey[0][i]);
	}
	return Subkey;
    }

    public static short [] Fmou(short []left, short []right, int round, short [][]subkeys){
	int i=0;
	short []temp= new short[32];
	temp= XOR(Feistel(right, subkeys[round]),left,32);
	System.out.println("\n The encryption round :"+ (round+1));
	return merge(right,temp,32);
    }

    public static short [] RFmou(short []left, short []right, int round, short [][]subkeys){
	int i=0;
	short []temp= new short[32];
	temp= XOR(Feistel(left, subkeys[round]),right,32);
	System.out.println("\n The decryption round :"+ (round+1));
	return merge(temp,left,32);
    }

    public static short [] DES (short[] text, short []Key, String sin, int round){
	int i=0,j=0,k=0;
	short [][] leftright= new short[2][32];
	short[]    total    = new short[64], nleft=new short[32], nright= new short[32], sretu = new short[64],  temp= new short[64];
	//Note: For encryption and decryptin, both of the inputs always go through "IP" firstly.
	temp = permu (text, ts("IP") , 64) ; 
	leftright= split (temp,64);
	short[][] subkeys=keysche(Key);
	short []note= new short[64];

	if(sin=="encrypt"){
	    for(i=0;i<round;++i){
		note=Fmou(leftright[0],leftright[1],i,subkeys);
		leftright=split(note,64);
	    }
	    //The left and right must be swapped here.
	    total = merge(leftright[1],leftright[0],32);
	    //
	    sretu = permu(total, ts("IPR"), 64);
	}
	else if( sin== "decrypt"){
	    //The left and right must be swapped here.
	    note = merge(leftright[1],leftright[0],32);
	    leftright=split(note,64);
	    //
	    for(i=0;i<round;++i){
		note=RFmou(leftright[0],leftright[1],round-1-i,subkeys);
		leftright=split(note,64);
	    }
	    total = merge(leftright[0],leftright[1],32);
	    sretu = permu(total, ts("IPR"), 64);
	}
	return sretu;	
    }


    
    public static void main(String args[]){
	
	//The plaintext and the key-----------------------//
        
	short Plaintext[] ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			    0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			    1,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0};


        short key[] ={0,1,0,0,0,0,0,1,1,0,0,1,0,1,0,0,
		      1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,1,
		      0,1,0,0,0,0,0,1,1,0,0,1,0,1,0,0,
		      1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,1};


	short Hfblock[] = {1,0,1,0,0,1,1,0,0,0,0,0,1,0,0,1,
			   1,0,1,0,0,1,1,0,0,1,0,0,1,0,0,0 };
	short Subkey [] = {1,0,1,0,0,1,1,0,0,0,0,0,1,0,0,1,
			   1,0,1,0,0,1,1,0,0,1,0,0,1,0,0,0,
			   1,0,1,0,0,1,1,0,0,0,0,0,1,0,0,1 };
 	//-------------------------------------------------//
	int i=0;
        
	//
	short note[]={1,2,3,4,5,6,7};
	short[] en= new short[64], de= new short[64];

	en= DES(Plaintext, key, "encrypt",16 );
	de= DES(en,        key, "decrypt",16 );
	System.out.println("\n The output is: ");
	for(i=0;i<64;++i)
	    System.out.print(de[i]);
    }
}
  
