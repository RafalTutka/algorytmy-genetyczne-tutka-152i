package com.company;

import java.time.Instant;
import java.util.Random;

public class Password {
    private char[] password={'H','e','l','l','o','!',' ','ś','ż'};
//poszukuje hasla wczesniej ustalonego przy użyciu algo genetycz
    public String findPassword(){
        StringBuilder stringBuilder=new StringBuilder();
        Instant start= Instant.now();
        //generacja rodzica
        char[] parent=generateParent();
        //sprawdzenie wartosci poprawnych liter
        int bestFitnes=fitnes(parent);
        int currentFitnes=0;
        //szukanie wykonuje sie do momentu znalezienia tylu poprawnych
        // liter ile znakow ma szukane slowo
        while(currentFitnes<password.length){
            //wykonane mutacji i stworzenie w en sposow dziecka
            char [] child=mutation(parent);
            //zapisanie fitnesu dziecka jako aktualnego
            currentFitnes= fitnes(child);
            //jezeli aktualny fitnes jest mniejszy niz najlepszy jaki był
            //to nie wykonuje sie nic, jesli tak nie jest, to wyswielane jest
            //do tej pory znalezine slowo
            if (bestFitnes>=currentFitnes)
            {}
            else{
                stringBuilder.append("Found Word: "+CharUtils.parseCharTableToString(child)+"\n"+"Fitnes: "+currentFitnes+"\n"+TimeUtils.getPeriodInTime(start,Instant.now())+"ms\n");
                if (currentFitnes>=parent.length)
                    break;
                bestFitnes=currentFitnes;
                parent=child;
            }
        }
        return stringBuilder.toString();
    }
//stworzenie losowej tablicy znakow
    public char[] generateParent(){
        char [] parent=new char[password.length];
        for (int i=0;i<password.length;i++) {
            parent[i]=randomCharacter();
        }
        return parent;
    }
//losowanie z ciągu znakow jednego znaku
    public char randomCharacter() {
        Random random=new Random();
        String setList = " aąbcćdeęfghijklłmnoópqrsśtuvwxyzźżABCĆDEFGHIJKLMNOÓPQRSŚTUVWXYZŹŻ!.";
        char character = setList.charAt(random.nextInt(setList.length()));
        return character;
    }
//zliczanie poprawnych liter
    public int fitnes(char[] fitnessWord) {
        int licznik=0;
        for(int i=0;i<fitnessWord.length;i++){
            if (fitnessWord[i]==password[i])
                licznik++;
        }
        return licznik;
    }
    //mutacja jednego genu w chromosomie (jednej litery w tablicy znakow)
    public char[] mutation(char[] chromosom1) {
        char[] template=chromosom1.clone();
        int fit=fitnes(template);
        Random p=new Random();
        // added super (dowhile) loop can shun situation when character is correct and
        // on good place, and algorithm want to generate this letter again
        do
        {
            chromosom1=template.clone();
            chromosom1[p.nextInt(chromosom1.length)]=randomCharacter();
        }
        while(fitnes(chromosom1)<fit);
        return chromosom1;
    }
}