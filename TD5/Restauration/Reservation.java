import java.util.Scanner;

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
       
       
       // Effectuer une réservation.
       
       boolean reservationTerminee = false;     // Permet à l'utilisateur d'effectuer des reservations jusqu'àce qu'il ne souhaite plus en faire.
       
       boolean numRestoCorrect = false;         // Permet de redemander un numéro de restaurant correct tant que le numéro entré n'est pas valide.
       Scanner s = new Scanner(System.in);
       while(!reservationTerminee) 
       {   
           int numResto = 0;
           while(!numRestoCorrect)
           {
               System.out.print("Entrer le numéro du restaurant : ");
               numResto = s.nextInt();
               try  // On essaye d'afficher les informations du numéro de restaurant entré, si ce numéro n'existe pas on capture une exception RestaurantInexistantException.
               {
                   System.out.println();
                   chaineResto.getRestaurant(numResto).affichage();
                   numRestoCorrect = true;
               }
               catch(RestaurantInexistantException e1)
               {
                   System.out.println("Exception : "+e1);
               }
            }
           
           boolean venteTerminee = false;   //Permet à l'utilisateur d'effectuer des achats de menus jusqu'a ce qu'il ne souhaite plus en faire.
           
           boolean nombreMenuCorrect = false;   // Permet de redemander un nombre de menu correct tan que le nombre entré n'est pas valide.
           boolean numeroMenuCorrect = false;   // Permet de redemander un numéro de menu correct tant que le numéro entré n'est pas valide.
           while(!venteTerminee)
           {     
               while(!nombreMenuCorrect || !numeroMenuCorrect)
               { 
                   System.out.print("Quel type de menu souhaitez vous acheter ? ");
                   int numMenu = s.nextInt();
                   System.out.print("Combien en voulez vous ? ");
                   int nbMenu = s.nextInt();
               
                   
                   try
                   {
                       chaineResto.getRestaurant(numResto).vendreMenus(nbMenu,numMenu);
                       numeroMenuCorrect = true;
                       nombreMenuCorrect = true;
                   }
                   catch(PasAssezDePlacesException e2)
                   {
                        System.out.println("Exception : "+e2);
                   }
                   catch(MenuInexistantException e3)
                   {
                        System.out.println("Exception : "+e3);
                   }
                    
                }
               
               System.out.print("Souhaitez vous autre chose ? (Oui/Non) ");
               s.nextLine();
               String autreVente = s.nextLine();
               if(autreVente.equals("Non"))
                    venteTerminee = true;
               
           }
           
           System.out.print("Souhaitez vous effectuer une autre reservation ? (Oui/Non) ");
           String autreReservation = s.nextLine();
           if(autreReservation.equals("Non")) 
                reservationTerminee = true;
       }

       s.close();
       
       // Afficher le bilan des reservations
       
       System.out.println("########################################################################################################");
       System.out.println("########################### BILAN DES RESERVATIONS DE LA CHAINE DE RESTAURANT ##########################");
       System.out.println("########################################################################################################");
       for(int i = 1; i<=chaineResto.taille(); i++)
       {
           System.out.println("-------------------------------------- Restaurant n°"+i+" -------------------------------------------");
           chaineResto.getRestaurant(i).affichage();
           System.out.println("Taux de remplissage :"+chaineResto.getRestaurant(i).tauxRemplissage()+"%");
           System.out.println("Chiffre d'affaire :"+ chaineResto.getRestaurant(i).chiffreAffaires()+"euros");
           System.out.println("------------------------------------------------------------------------------------------------");
           System.out.println();
        }
       
  
    }
}
