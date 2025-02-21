package com.examenFinal;

import javax.swing.SwingUtilities;

import com.examenFinal.view.FenetrePrincipale;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SwingUtilities.invokeLater(() -> {
            FenetrePrincipale frame = new FenetrePrincipale();
            frame.setVisible(true);
        });
    }
    }

