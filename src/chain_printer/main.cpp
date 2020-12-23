#include "chain.h"

int main()
{
    ChainOfPrinters linearChain;
    
    Printer printer1 ("printer1", false, 255, 22, false); //occupata
    Printer printer2 ("printer2", false, 0, 22); //no inchiostro nero
    Printer printer3 ("printer3", true, 25, 33); //bianco e nero
    Printer printer4 ("printer4", false, 42, 32, true, true); //no magenta
    Printer printer5 ("printer5", false, 12, 32, true, true, 10); //no giallo
    Printer printer6 ("printer6", false, 42, 32, true, false); //non funziona
    Printer printer7 ("printer7", false, 42, 51, true, true, 44, 45, 63);
    
    linearChain.addPrinter (&printer1);
    linearChain.addPrinter (&printer2);
    linearChain.addPrinter (&printer3);
    linearChain.addPrinter (&printer4);
    linearChain.addPrinter (&printer5);
    linearChain.addPrinter (&printer6);
    linearChain.addPrinter (&printer7);
    
    Document doc1 (5, true);
    Document doc2 (1, false);
    
    linearChain.print (doc1);
    
    linearChain.print (doc2);
    
    /*
     
name (n),
blackWhite (bw),
black (b),
paper (p),
isFree (s),
functioning (f),
magenta (m),
cyan (c),
yellow (y),
     */
}
