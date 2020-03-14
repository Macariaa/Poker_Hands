import java.util.*;

class KaPai {
    public char name;
    public int value;
    public char suit;

    public KaPai(char name,int value, char suit) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" +name + suit +  ")";
    }
}
public class Pai {
	
	public static int lessthan(KaPai t1, KaPai t2){
	    return (t1.value<t2.value)? 1:0;    
	}

	public static int diffence(KaPai t1, KaPai t2){
	    return (t1.value - t2.value);
	}
	
	public static void exchange(KaPai a[], int i, int j){
	    char n1=a[i].name;
	    int v1=a[i].value;
	    char s1=a[i].suit;
	    
	    a[i].name=a[j].name;
	    a[i].value=a[j].value;
	    a[i].suit=a[j].suit;
	    
	    a[j].name=n1;
	    a[j].value=v1;
	    a[j].suit=s1;
	}
	
	public static void SelectionSort(KaPai[] a, int left, int right){
	    int i,j,min;
	    for(i=left; i<right; i++) {
	        min=i;
	        for(j=i+1; j<=right; j++)
	            if(lessthan(a[j],a[min])==1) min=j;
	        exchange(a, i, min);
	    }
	}
	public static void SortCards(KaPai cardsBlack[],KaPai cardsWhite[] ){
	    SelectionSort(cardsBlack, 0, 4);
	    SelectionSort(cardsWhite, 0, 4);
	}
	public static int IsBomb(KaPai a[], int i){
	    if(  a[i+1].value==a[i].value
	        && a[i+2].value==a[i].value
	        && a[i+3].value==a[i].value)
	         return 1;
	    return 0;
	}
	public static int IsThree(KaPai a[], int i){
	    if(  a[i+1].value==a[i].value
	        && a[i+2].value==a[i].value)
	        return 1;
	    return 0;
	}
	public static int IsPair(KaPai a[], int i){
	    if(a[i+1].value==a[i].value)
	        return 1;
	    return 0;
	}
	public static int IsStraight(KaPai a[]){
	    if(  (a[1].value-a[0].value)==1
	        && (a[2].value-a[1].value)==1
	        && (a[3].value-a[2].value)==1
	        && (a[4].value-a[3].value)==1 )
	        return 1;
	    return 0;
	}
	public static int IsFlush(KaPai a[]){
	    if(  a[1].suit==a[0].suit 
	        && a[2].suit==a[0].suit
	        && a[3].suit==a[0].suit
	        && a[4].suit==a[0].suit)
	        return 1;
	    return 0;
	}
	public static int GetLevel(KaPai a[], int order[])	{
	    int level,i,t1,t2,t3;
	    order[0]=order[1]=order[2]=order[3]=order[4]=0;
	    
	    level=9;
	    if(IsStraight(a)==1 && IsFlush(a)==1) {
	        order[0]=a[4].value;
	        return level;
	    }
	    
	    level--;
	    if(IsBomb(a, 0)==1 || IsBomb(a, 1)==1) {
	        order[0]=a[1].value;
	        return level;
	    }
	    
	    level--;
	    if( (IsThree(a,0)==1 && IsPair(a,3)==1) || (IsThree(a, 2)==1 && IsPair(a, 0)==1) ){
	        order[0]=a[2].value;
	        return level;
	    }
	    
	    level--;
	    if(IsFlush(a)==1){
	        for(i=0;i<5;i++) order[i]=a[4-i].value;
	        return level;
	    }
	    

	    level--;
	    if(IsStraight(a)==1) {
	        order[0]=a[4].value;
	        return level;
	    }
	    
	    level--;
	    if(IsThree(a,0)==1 || IsThree(a,1)==1 || IsThree(a,2)==1) {
	        order[0]=a[2].value;
	        return level;
	    }
	    
	    level--;
	    i=10;
	    if(IsPair(a,1)==1 && IsPair(a,3)==1) {
	    	i=0;
	    }
	    if(IsPair(a,0)==1 && IsPair(a,3)==1) {
	    	i=2;
	    }
	    if(IsPair(a,0)==1 && IsPair(a,2)==1) {
	    	i=4;
	    }
	    if(i!=10) {
	    	order[0]=a[3].value;
	        order[1]=a[1].value;
	        order[2]=a[i].value;
	        return level;
	    }
	    
	    level--;
	    i=9;
	    t1=0;
	    t2=0;
	    t3=0;
	    if(IsPair(a,0)==1) {
	    	i=0; t1=4; t2=3; t3=2;
	    }
	    if(IsPair(a,1)==1) {
	    	i=1; t1=4; t2=3; t3=0;
	    }
	    if(IsPair(a,2)==1) {
	    	i=2; t1=4; t2=1; t3=0;
	    }
	    if(IsPair(a,3)==1) {
	    	i=3; t1=2; t2=1; t3=0;
	    }
	    if(i!=9) {
	    	order[0]=a[i].value;
	        order[1]=a[t1].value;
	        order[2]=a[t2].value;
	        order[3]=a[t3].value;
	        return level;
	    }
	    
	    level--;
	    for(i=0;i<5;i++) order[i]=a[4-i].value;
	    return level;
	}
	
	


	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		Scanner in = new Scanner(System.in);
		System.out.print("Black：");
		in.useDelimiter("\n");
        String B=in.next();
        
		System.out.print("White：");
		String W=in.next();
		
		
//		String B = "2H 3D 5S 9C KD"; 
//		String W = "2C 3H 4S 8C AH";
		char[] Black = B.toCharArray(); 
		char[] White = W.toCharArray();
		
		
		KaPai[] cardsBlack=new KaPai[5];
		KaPai[] cardsWhite=new KaPai[5];
		
		int[] orderBlack=new int[5];
		int[] orderWhite=new int[5];
		String CardValues= "23456789TJQKA";
		
		int i;
	    for(i=0;i<5;i++) {
	    	cardsBlack[i]=new KaPai(Black[i*3],0,Black[i*3+1]);
	    	cardsBlack[i].value=CardValues.indexOf(cardsBlack[i].name);
	    	//System.out.print(cardsBlack[i].value+" ");
	    	cardsWhite[i]=new KaPai(White[i*3],0,White[i*3+1]);
	    	cardsWhite[i].value=CardValues.indexOf(cardsWhite[i].name);
	    	
	    }
	    
	    int levelBlack, levelWhite;
	    SortCards(cardsBlack,cardsWhite);
	    levelBlack=GetLevel(cardsBlack, orderBlack);
        levelWhite=GetLevel(cardsWhite, orderWhite);
        if(levelBlack > levelWhite)
            System.out.print("Black wins.\n");
        else if(levelBlack < levelWhite)
        	System.out.print("White wins.\n");
        else {
            for(i=0;i<5;i++) {
                if(orderBlack[i]>orderWhite[i]) {
                	System.out.print("Black wins.\n");
                    break;
                }
                else if(orderBlack[i]<orderWhite[i]) {
                	System.out.print("White wins.\n");
                    break;
                }
            }
            if(i==5) System.out.print("Tie.\n");
        }
	    
		
		
	}

}
