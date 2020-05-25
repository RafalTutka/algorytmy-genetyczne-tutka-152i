
package hetman;

public class Hetman {

 /*
    
    Problem 8 hetmanów polega na ustawieniu w szachownicy tzw. królowej (ruch w pionie, poziomie i po skosie) w taki sposób by żadna figura nie mogła zbić innej
    
    */
private static boolean dia_r[] = new boolean[256];
private static boolean dia_l[] = new boolean[256];
private static boolean col[] = new boolean[8];       // tablica z zajętymi kolumnami
private static boolean chart[][] = new boolean[8][8];// tablica z możliościami na szachownicy 
private static byte found = 0;                       // liczenie pozycji na szachownicy
 
@SuppressWarnings("unchecked")
private static void add_hetman(int row) {
for (int i=0; i<8; i++) {
if (!((col[i]) || (dia_r[i-row+128]) || (dia_l[row+i+128]))) {
dia_r[i-row+128] = true;     // dodawanie przekątnych
dia_l[row+i+128] = true;
col[i] = true;               // dodwanie kolumny
chart[i][row] = true;        // ustawienie hetmana w tablicy mozliwosci ruchu
if (row<7) {
add_hetman(row+1);       // analiza następnych ruchów 
}
else {                       // wydruk wyników po ostatniej możliwości 
found++;
printCombination();
}
// ) usuwanie hetmana i stawienie go na innej pozycji
dia_r[i-row+128] = false;
dia_l[row+i+128] = false;
col[i] = false;
chart[i][row] = false;
}      
}
}
 
public static void printCombination() {
System.out.println("kombinacja: " + found);
System.out.println("  ABCDEFGH");
System.out.println("");
for (int y=7; y>=0; y--) {
System.out.print(y+1 + " ");
for (int x=0; x<8; x++) {
if (chart[x][y]) {
System.out.print("H");
}
else {
System.out.print(" ");
}
}
System.out.println();
}
System.out.println("");
System.out.println("");
}

public static void main(String[] args) {
add_hetman(0);             // stawianie pierwszego hetmana na szachownicy
}
 
}