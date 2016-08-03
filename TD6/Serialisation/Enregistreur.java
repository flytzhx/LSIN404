
import java.io.*;
/**
 * Write a description of class Enregistreur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enregistreur
{
    // Référence un fichier de sauvegarde pour enregister des informations concernant des instances de la classe Joueur.
    private File fichier;
    
    public Enregistreur(String nom)
    {
          fichier = new File(nom);  // Créer un flux fichier à partir d'un fichier existant ou non.
          if(!fichier.exists())
          {
              System.out.println("Le fichier de sauvegarde n'existe pas.");
              try{
                  fichier.createNewFile();  // Créer le fichier correspondant au flux si le fichier n'existe pas.
                  System.out.println("Le fichier de sauvegarde a été créé.");
              }
              catch(IOException e)
              {
                  e.printStackTrace();
              }
              
          }
          else
          {
              System.out.println("Le fichier de sauvegarde existe.");
          }
          
    }
    
    // Permet d'écrire les informations concernant un nouveau joueur dans le fichier référencé par l'attribut fichier d'un objet Enregistreur.
    public void ecrire(Joueur nouveauJoueur) 
    {
         // On effectue ici une serialisation, c'est à dire l'écriture et la lecture d'objet à partir de fichier. 
        // Pour celà on utilise les classe ObjectOutputStream et ObjectInputStream. 
        // On créer des objets de ces classes à partir des flux binaire de fichier, objets de classe FileOutputStream et FileInputStream, eux même créer à partir d'un flux fichier, objet de classe File.
        
        // On vérifie le fichier référencé par la variable d'instance fichier (fichier de sauvegarde) :
        //      - S'il est vide on n'a pas besoin de le lire pour vérifier si le nom d'un joueur existe déja, on a donc juste à ouvrir le fichier en écriture pour y ajouter le nouveau joueur.
        //      - S'il est non-vide, il faut comparer chaque joueur du fichier avec le nouveau joueur entree pour éviter l'ajout d'un joueur déja présent.
        //        Pour celà il faut :
        //                  * ouvrir le fichier (de sauvegarde) en lecture pour pouvoir effectuer la comparaison avec le nouveau joueur entré.
        //                  * créer un fichier temporaire et l'ouvrir en écriture pour y ajouter les joueurs. 
        //                  * Comparer chaque joueur lu dans le fichier (de sauvegarde) avec le nouveau joueur entré. Deux cas sont possibles :
        //                          ~ le joueur lu dans le fichier (de sauvegarde) est le même que le nouveau joueur, dans ce cas on ajoute seulement le nouveau joueur dans le fichier temporaire (pour 	actualiser son score) et on indique dans un boolean qu'il n'est plus nécéssaire d'ajouter le nouveau joueur (puisqu'on vient de l'ajouter).
        //                          ~ le joueur lu dans le fichier (de sauvegarde) est différent du nouveau joueur, dans ce cas on ajoute seulement le joueur lu dans le fichier temporaire.
        //		            * Si le boolean indique que le nouveau joueur n'a toujours pas été ajouté (il n'était pas déja existant dans ceux enregistrés), on l'ajoute à la fin du fichier temporaire.
        //                  * On efface le contenu du fichier de sauvegarde (en le supprimant/recréant) et on y copie le contenu du fichier temporaire. On supprime le fichier temporaire.
       
        
        // !! Ne pas essayer d'instancier un flux ObjectInputStream à partir d'un fichier vide !!
        //  -> Explication :
        //      Lorsqu'on essaye d'instancier un flux ObjectInputStream à partir d'un fichier de cette manière : ObjectInputStream ois = new ObjectInputStream(FileInputStream(fichier));
        //      ObjectInputStream lit l'entête du fichier avant d'essayer d'instancier le flux, si FileInputStream pointe sur un fichier vide le flux ObjectInputStream ne peut pas être instancié et une exception IO est produite. 
        
        
        boolean empty = (fichier.length() == 0);
        
        if(empty)   // Fichier vide on n'a pas besoin de le lire pour vérifier si le nom d'un joueur existe déja, on a donc juste à ouvrir le fichier en écriture pour y ajouter le nouveau joueur.
        {
            try(FileOutputStream fos = new FileOutputStream(fichier); ObjectOutputStream sortie = new ObjectOutputStream(fos);)
            {
                sortie.writeObject(nouveauJoueur);
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        else    // Fichier non-vide, il faut comparer chaque joueur du fichier de sauvegarde avec le nouveau joueur entree pour éviter l'ajout d'un joueur déja présent.
        {
            
            
            // Création du fichier temporaire
            File fileTemp = new File("temp");
            
             if(!fileTemp.exists())
              {
                  System.out.println("Le fichier temporaire n'existe pas.");
                  try{
                      fileTemp.createNewFile();
                      System.out.println("Le fichier temporaire a été créé.");
                  }
                  catch(IOException e)
                  {
                      e.printStackTrace();
                  }
                  
              }
              else
              {
                  System.out.println("Le fichier temporaire existe.");
              }
              
              
            
            try
            (
                // --> 1 - Ouvrir le fichier (de sauvegarde) en lecture pour pouvoir effectuer la comparaison avec le nouveau joueur entré.
                FileInputStream fis = new FileInputStream(fichier);
                ObjectInputStream entree = new ObjectInputStream(fis);
                // --> 2- Créer un flux en écriture à partir du fichier temporaire pour y ajouter les joueurs.
                FileOutputStream fos = new FileOutputStream(fileTemp);
                ObjectOutputStream sortie = new ObjectOutputStream(fos);
            )
            {
                
                // --> 3 - Comparer chaque joueur lu dans le fichier (de sauvegarde) avec le nouveau joueur entré.
                boolean nouveauJoueurAjoute = false;
                boolean finDuFichier = false;
                
                // On effectue une boucle qui ne peut s'arreter que lorsqu'on atteint une exception EOF (fin de fichier), c'est à dire quand on a lu le fichier de sauvegarde en entrée jusqu'à la fin.
                while(!finDuFichier)
                {
                    try{
                    
                        Joueur joueurCourant = (Joueur) entree.readObject();    // On récupère l'objet lu dans le fichier de sauvegarde qu'on convertit en Joueur pour pouvoir appliquer les méthodes specifiques à cette classe.
                        
                        // Deux cas possibles lors de la comparaison :
                        if(nouveauJoueur.getNom().equals(joueurCourant.getNom()))
                        {
                            sortie.writeObject(nouveauJoueur);  // le joueur lu dans le fichier (de sauvegarde) est le même que le nouveau joueur, dans ce cas on ajoute seulement le nouveau joueur dans le fichier temporaire (pour actualiser son score).
                            nouveauJoueurAjoute = true; //et on indique dans un boolean qu'il n'est plus nécéssaire d'ajouter le nouveau joueur (puisqu'on vient de l'ajouter)
                        }
                        else
                        {
                            sortie.writeObject(joueurCourant);          //  le joueur lu dans le fichier (de sauvegarde) est différent du nouveau joueur, dans ce cas on ajoute seulement le joueur lu dans le fichier temporaire.
                        }
                    }
                    catch(EOFException e)   // On capture une exception EOF, le fichier de sauvegarde a été lu complètement
                    {
                        System.out.println("La fin du fichier de sauvegarde a été atteinte.");
                        finDuFichier = true;
                    }
                    catch(ClassNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                }
                
                // Si le boolean indique que le nouveau joueur n'a toujours pas été ajouté (il n'était pas déja existant dans ceux enregistrés), on l'ajoute à la fin du fichier temporaire.
                if(!nouveauJoueurAjoute)
                {
                    sortie.writeObject(nouveauJoueur);
                }
                
                
                // --> 4- On efface le contenu du fichier (de sauvegarde) et on y copie le contenu du fichier temporaire.
                
                ObjectInputStream entree2 = null;
                ObjectOutputStream sortie2 = null;
                
                try
                {
                    
                    entree2 = new ObjectInputStream(new FileInputStream(fileTemp));
                 
                    // Pour effacer le contenu du fichier de sauvegarde, on enregistre le nom du fichier, on le supprimer, et on en crée un nouveau avec le meme nom.
                    String name = this.fichier.getName();
                    this.fichier.delete();
                    this.fichier = new File(name);
                   
                    sortie2 = new ObjectOutputStream(new FileOutputStream(fichier));
                    
                    finDuFichier = false;
                    
                    while(!finDuFichier)
                    {
                        try{
                            sortie2.writeObject(entree2.readObject());
                        }
                        catch(EOFException e)
                        {
                             System.out.println("La fin du fichier temporaire a été atteinte :  Tous les joueurs ont été enregistré dans le fichier de sauvegarde.");
                             finDuFichier = true;
                        }
                        catch(ClassNotFoundException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                catch(FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                 catch(IOException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try{
                        if(entree2 != null)
                            entree2.close();
                        if(sortie2 != null)
                            sortie2.close();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    
                }
                
                
                // --> 5- On supprime le fichier temporaire.
                fileTemp.delete();
               
               
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
                
                
        }
        
        
    }
    
    public void afficher() 
    {
        if(!(fichier.length() == 0))
        {
            try
            (
                FileInputStream fis = new FileInputStream(fichier);
                ObjectInputStream entree = new ObjectInputStream(fis);
            )
            {
                boolean finDuFichier = false;
                System.out.println(" #########################################################################################################");
                System.out.println(" ################################### Contenu du fichier de sauvegarde ####################################");
                System.out.println(" #########################################################################################################");
                while(!finDuFichier)
                {
                    try{
                        Joueur joueurCourant = (Joueur) entree.readObject();
                        System.out.println(joueurCourant.toString());
                    }
                    catch(EOFException e)
                    {
                        System.out.println("-> Le fichier de sauvegarde a été lu entièrement");
                        finDuFichier = true;
                    }
                    catch(ClassNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println(" ################################### Fin du fichier de sauvegarde ####################################");
            
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
        
}
