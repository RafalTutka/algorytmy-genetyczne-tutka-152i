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
//import com.company.model.GeneticOperations;
//import com.company.tools.UsefullTools;

import java.util.ArrayList;

public class Main {
    //implementacja potrzebnych pól
   public static UsefullTools tools;
   public static GeneticOperations geneticOperations;
   public static ArrayList<int[]> population;


    public static void main(String[] args) {
        //przypisanie nowych obiektów
        tools=new UsefullTools();
        geneticOperations =new GeneticOperations();
        //wczytanie populacji
        population = geneticOperations.getPopulation();
        //wyswietlenie populacji losowej
        tools.showPopulation(population,1);
        //stworzenie drugiej populacji, mutowanie genow z pierwszej populacji
        ArrayList<int[]> populationTwo=tools.createPopulationArrayList(
                geneticOperations.mutation(population.get(0),2,1),
                geneticOperations.mutation(population.get(1),2,1),
                geneticOperations.mutation(population.get(2),2,1),
                geneticOperations.mutation(population.get(3),2,1));
        //wyswietlenie populacji
        tools.showPopulation(populationTwo,2);

        ArrayList<int[]> populationThree=new ArrayList<>();

        ArrayList<int[]> template= new ArrayList<int[]>();
        //wykonanie pętli z krzyżowaniem i zapisanie nowych osobbników do populacji trzeciej
        for (int i=0;i<2;i++){
            template= geneticOperations.crossing(populationTwo.get(i),populationTwo.get(i+2),2 );
            populationThree.add(template.get(0));
            populationThree.add(template.get(1));
        }
        //wyswietlnenie trzeciej populacji
        tools.showPopulation(populationThree,3);
       }
    }
