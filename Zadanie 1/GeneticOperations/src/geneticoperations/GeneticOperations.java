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
//import com.company.tools.UsefullTools;

import java.util.ArrayList;
import java.util.Random;

public class GeneticOperations {
//wykorzystanie obiektu klasy UsefullTools do wykonywania pewnych operacji na tablicach
    UsefullTools tools;
    public ArrayList<int[]> population;

    public GeneticOperations() {
        this.tools=new UsefullTools();
        this.population=tools.createPopulationArrayList();
    }
    public GeneticOperations(ArrayList<int[]> population) {

        this.population = population;
    }

    public GeneticOperations(UsefullTools tools, ArrayList<int[]> population) {
        this.tools = tools;
        this.population = population;
    }
//krzyzowanie po przez podmiane genu dla indexu point
    public ArrayList<int[]> crossing(int[] chromosom1,int[] chromosom2,int point){
       int template= chromosom1[point];
       chromosom1[point]=chromosom2[point];
       chromosom2[point]=template;
       ArrayList<int[]> returned=new ArrayList<>();
       returned.add(chromosom1);
       returned.add(chromosom2);
       return returned;
    }
//fitness zlicza wartosci parzyste i nieparzyste i odejmuje od siebie
    public int fitness(int[] chromosom){
        int solution=0;
        for(int i=0;i<10;i++){
            if(i%2==0)
                solution=solution+chromosom[i];
            if(i%2==1)
                solution=solution-chromosom[i];
        }
        return solution;
    }
//mutacja mutuje gen w tablicy o odpowiednim indeksie mutuje czyli wstawia nowy wylosowany funkcja random
    public int[] mutation(int[] chrom1, int numberMutation, int position){
        Random p=new Random();
        for(int i=0;i<numberMutation;i++){
            chrom1[position]=p.nextInt(100);
        }
        return chrom1;
    }

    public ArrayList<int[]> getPopulation() {
        return population;
    }
}

