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
public class Pisnamar {
    public static long factorial(int n) {
        long ret = n;
        
        while(n > 2){
            ret *= --n;
        }
        
        return ret;
    }
}
