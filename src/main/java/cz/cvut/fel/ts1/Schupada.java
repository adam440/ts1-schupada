/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.ts1;

/**
 *
 * @author martu
 */
public class Schupada {
    public static long factorial(int n) {
        if(n <= 1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
}
