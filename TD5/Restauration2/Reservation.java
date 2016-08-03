import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Write a description of class Reservation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reservation
{
   public static void main(String[] args)
   {
       // Création de la chaine de restaurants.
       
       ChaineRestauration chaineResto = new ChaineRestauration();
       Restaurant r1 = new Restaurant("Versailles Chateau",699,23.8);
       Restaurant r2 = new Restaurant("Paris Marais",900,23.1);
       Restaurant r3 = new Restaurant("Sqy Ouest",789,78.3);
       Restaurant r4 = new Restaurant("Jouy en Josas",345,90.2);
       Restaurant r5 = new Restaurant("Gif",231,12);

       chaineResto.ajouterRestaurant(r1);  
       chaineResto.ajouterRestaurant(r2);  
       chaineResto.ajouterRestaurant(r3);  
       chaineResto.ajouterRestaurant(r4);  
       chaineResto.ajouterRestaurant(r5);
       
       boolean reservationTerminee = false;
       Scanner sc = new Scanner(System.in);
       while(!reservationTerminee)
       {
           boolean numRestoCorrect = false;
           Restaurant restoEnCours = null;
           while(!numRestoCorrect)
           {
               try
               {
                   System.out.println("Numéro restaurant :");
                   int numResto = sc.nextInt();
                   restoEnCours = chaineResto.getRestaurant(numResto);
                   numRestoCorrect = true;
                   restoEnCours.affichage();
               }
               catch(InputMismatchException e)
               {
                   System.out.println("Exception : "+e);
                   System.out.println("Vous n'avez pas entré un nombre");
                   sc.nextLine();
               }
               catch(RestaurantInexistantException e)
               {
                   System.out.println("Exception : "+e);
               }
           }
           

           
           boolean venteTerminee = false;
           while(!venteTerminee)
           {
               
               boolean achatAccepte = false;
               
               while(!achatAccepte)
               {
                   try
                   {
                       System.out.println("Type de Menu :");
                       int typeMenu = sc.nextInt();
                       System.out.println("Nombre de Menu :");
                       int nombreMenu = sc.nextInt();
                       restoEnCours.vendreMenus(nombreMenu, typeMenu);
                       System.out.println("Vente Acceptée");
                       achatAccepte = true;
                       
                   }
                   catch(InputMismatchException e)
                   {
                       System.out.println("Exception : "+e);
                       System.out.println("Vous n'avez pas entré un nombre");
                                                sc.nextLine();
                   }
                   catch(MenuInexistantException e)
                   {
                       System.out.println("Exception : "+e);
                   }
                   catch(PasAssezDePlacesException e)
                   {
                       System.out.println("Exception : "+e);
                   }
               }
               
               System.out.println("Acheter d'autres Menu ? (Oui/Non)");
               sc.nextLine();
               String autreVente = sc.nextLine();
               if(autreVente.equals("Non"))
                    venteTerminee = true;
               
            }
           
           System.out.println("Autre réservation ? (Oui/Non)");
               sc.nextLine();
               String autreReserv = sc.nextLine();
               if(autreReserv.equals("Non"))
                    reservationTerminee = true;
       }
       
       sc.close();
      
       
       
        // Afficher le bilan des reservations
       
       System.out.println("########################################################################################################");
       System.out.println("########################### BILAN DES RESERVATIONS DE LA CHAINE DE RESTAURANT ##########################");
       System.out.println("########################################################################################################");
       int i = 1;
       for(Restaurant r : chaineResto.getListeResto())
       {
           System.out.println("-------------------------------------- Restaurant n°"+i+" -------------------------------------------");
           r.affichage();
           System.out.println("Taux de remplissage :"+r.tauxRemplissage()+"%");
           System.out.println("Chiffre d'affaire :"+ r.chiffreAffaires()+"euros");
           System.out.println("------------------------------------------------------------------------------------------------");
           System.out.println();
           i++;
        }
           
    }
}
