/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipop31p2024;

import java.util.Random;

/**
 *
 * @author Joseg
 */
public class PrototipoP31P2024 {

    public static void main(String[] args) {
        double notaMasAlta =0;
        double notaMasBaja =0;
        int numFacultades = 3;
        int numAlumnosPorFacultad = 5;
        double[][] notasPrimerParcial = new double[numFacultades][numAlumnosPorFacultad];
        double[][] notasSegundoParcial = new double[numFacultades][numAlumnosPorFacultad];
        double[][] notasExamenFinal = new double[numFacultades][numAlumnosPorFacultad];
        double[][] notasActividades = new double[numFacultades][numAlumnosPorFacultad];

    
        Random random = new Random();
        for (int i = 0; i < numFacultades; i++) {
            for (int j = 0; j < numAlumnosPorFacultad; j++) {
                notasPrimerParcial[i][j] = random.nextDouble() * 20;
                notasSegundoParcial[i][j] = random.nextDouble() * 25;
                notasExamenFinal[i][j] = random.nextDouble() * 35;
                notasActividades[i][j] = random.nextDouble() * 20;
            }
        }

    
        double[] promediosFacultad = new double[numFacultades];
        double mejorPromedio = 0;
        String mejorFacultad = "";

        for (int i = 0; i < numFacultades; i++) {
            double sumaPromedios = 0;
             notaMasAlta = 0;
             notaMasBaja = Double.MAX_VALUE;

            for (int j = 0; j < numAlumnosPorFacultad; j++) {
                double promedioAlumno = (notasPrimerParcial[i][j] + notasSegundoParcial[i][j]
                        + notasExamenFinal[i][j] + notasActividades[i][j]) / 4;
                sumaPromedios += promedioAlumno;

                notaMasAlta = Math.max(notaMasAlta, promedioAlumno);
                notaMasBaja = Math.min(notaMasBaja, promedioAlumno);
            }

            promediosFacultad[i] = sumaPromedios / numAlumnosPorFacultad;

            if (promediosFacultad[i] > mejorPromedio) {
                mejorPromedio = promediosFacultad[i];
                mejorFacultad = "Facultad " + (i + 1);
            }
        }

       
        System.out.println("Resultados por facultad:");
        for (int i = 0; i < numFacultades; i++) {
            System.out.println("Facultad " + (i + 1));
            System.out.println("Promedio: " + promediosFacultad[i]);
            System.out.println("Nota más alta: " + notaMasAlta);
            System.out.println("Nota más baja: " + notaMasBaja);
            System.out.println();
        }

        System.out.println("Mejor facultad: " + mejorFacultad);
        System.out.println("Promedio obtenido: " + mejorPromedio);
    }
    }
