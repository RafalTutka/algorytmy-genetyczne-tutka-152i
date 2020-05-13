/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticoperations;

/**
 *
 * @author 48575
 */
import static geneticoperations.Main.geneticOperations;
import java.util.ArrayList;
import java.util.Random;

//import static com.company.Main.geneticOperations;

public class UsefullTools {
    private static int counter=1;
    public UsefullTools() {
    }
//tworzenie losowego chromosomu
    public int[] fillTabWithRandom(int[] tab){
        Random r = new Random();
        for(int i=0;i<10;i++) {
            tab[i] = r.nextInt(100);
        }
        return tab;
    }
//tworzenie losowej populacji
    public ArrayList<int[]> createPopulationArrayList(){
        ArrayList<int[]> population=new ArrayList<>();
        population.add(fillTabWithRandom(new int[100]));
        population.add(fillTabWithRandom(new int[100]));
        population.add(fillTabWithRandom(new int[100]));
        population.add(fillTabWithRandom(new int[100]));
        return population;
    }
    //tworzenie poplacji poprzez dodanie do populacji osobników=chromosomow
    public ArrayList<int[]> createPopulationArrayList(int[] chrom1,int[] chrom2, int[] chrom3, int[] chrom4){
        ArrayList<int[]> population=new ArrayList<>();
        population.add(chrom1);
        population.add(chrom2);
        population.add(chrom3);
        population.add(chrom4);
        return population;
    }
    public void showPopulation(ArrayList<int[]> population){
        System.out.println("\n\n" +"###################POPULATION###################");
        for (int[] i:population) {
            showChromosom(i);
        }
        counter=1;
    }
    //wyswietlanie populacji
    public void showPopulation(ArrayList<int[]> population,int populationCoounter){
        System.out.println("\n\n###################POPULATION "+populationCoounter+"###################");
        for (int[] i:population) {
            showChromosom(i);
        }
        counter=1;
    }
    //wyswietlanie chromosomu
    public void showChromosom(int[] chromosom){
        System.out.print("Chromosom "+counter+". :");
        System.out.println("\nFitness Result :"+ geneticOperations.fitness(chromosom));
        for(int i=0;i<10;i++) {
            System.out.print(chromosom[i]+" ");
        }
        System.out.println("\n");
        counter++;
    }
}
